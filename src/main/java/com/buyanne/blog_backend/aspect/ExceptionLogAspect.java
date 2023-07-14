package com.buyanne.blog_backend.aspect;

import com.buyanne.blog_backend.annotation.OperationLogger;
import com.buyanne.blog_backend.annotation.VisitLogger;
import com.buyanne.blog_backend.entity.ExceptionLog;
import com.buyanne.blog_backend.service.ExceptionLogService;
import com.buyanne.blog_backend.util.AopUtils;
import com.buyanne.blog_backend.util.IpAddressUtils;
import com.buyanne.blog_backend.util.JacksonUtils;
import com.buyanne.blog_backend.util.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description: AOP记录异常日志
 * @Date: 2020-12-03
 */
@Component
@Aspect
public class ExceptionLogAspect {
	@Autowired
	ExceptionLogService exceptionLogService;

	/**
	 * 配置切入点
	 */
	@Pointcut("execution(* com.buyanne.blog_backend.controller..*.*(..))")
	public void logPointcut() {
	}

	@AfterThrowing(value = "logPointcut()", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Exception e) {
		ExceptionLog log = handleLog(joinPoint, e);
		exceptionLogService.saveExceptionLog(log);
	}

	/**
	 * 设置ExceptionLog对象属性
	 *
	 * @return
	 */
	private ExceptionLog handleLog(JoinPoint joinPoint, Exception e) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String ip = IpAddressUtils.getIpAddress(request);
		String userAgent = request.getHeader("User-Agent");
		//todo 使用swagger后，可以直接使用注解上的内容作为 ExceptionLog 的 description
		String description = getDescriptionFromAnnotations(joinPoint);
		String error = StringUtils.getStackTrace(e);
		ExceptionLog log = new ExceptionLog(uri, method, description, error, ip, userAgent);
		Map<String, Object> requestParams = AopUtils.getRequestParams(joinPoint);
		log.setParam(StringUtils.substring(JacksonUtils.writeValueAsString(requestParams), 0, 2000));
		return log;
	}

	private String getDescriptionFromAnnotations(JoinPoint joinPoint) {
		String description = "";
		Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
		OperationLogger operationLogger = method.getAnnotation(OperationLogger.class);
		if (operationLogger != null) {
			description = operationLogger.value();
			return description;
		}
		VisitLogger visitLogger = method.getAnnotation(VisitLogger.class);
		if (visitLogger != null) {
			description = visitLogger.behavior();
			return description;
		}
		return description;
	}
}
