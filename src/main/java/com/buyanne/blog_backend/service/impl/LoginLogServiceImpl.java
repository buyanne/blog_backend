package com.buyanne.blog_backend.service.impl;

import com.buyanne.blog_backend.entity.LoginLog;
import com.buyanne.blog_backend.exception.PersistenceException;
import com.buyanne.blog_backend.mapper.LoginLogMapper;
import com.buyanne.blog_backend.service.LoginLogService;
import com.buyanne.blog_backend.util.IpAddressUtils;
import com.buyanne.blog_backend.util.UserAgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Description: 登录日志业务层实现
 * @Date: 2020-12-03
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
	@Autowired
	LoginLogMapper loginLogMapper;
	@Autowired
	UserAgentUtils userAgentUtils;

	@Override
	public List<LoginLog> getLoginLogListByDate(String startDate, String endDate) {
		return loginLogMapper.getLoginLogListByDate(startDate, endDate);
	}

	@Transactional
	@Override
	public void saveLoginLog(LoginLog log) {
		String ipSource = IpAddressUtils.getCityInfo(log.getIp());
		Map<String, String> userAgentMap = userAgentUtils.parseOsAndBrowser(log.getUserAgent());
		String os = userAgentMap.get("os");
		String browser = userAgentMap.get("browser");
		log.setIpSource(ipSource);
		log.setOs(os);
		log.setBrowser(browser);
		if (loginLogMapper.saveLoginLog(log) != 1) {
			throw new PersistenceException("日志添加失败");
		}
	}

	@Transactional
	@Override
	public void deleteLoginLogById(Long id) {
		if (loginLogMapper.deleteLoginLogById(id) != 1) {
			throw new PersistenceException("删除日志失败");
		}
	}
}
