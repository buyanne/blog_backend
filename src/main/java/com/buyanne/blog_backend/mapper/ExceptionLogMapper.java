package com.buyanne.blog_backend.mapper;

import com.buyanne.blog_backend.entity.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 异常日志持久层接口
 * @Date: 2020-12-03
 */
@Mapper
@Repository
public interface ExceptionLogMapper {
	List<ExceptionLog> getExceptionLogListByDate(String startDate, String endDate);

	int saveExceptionLog(ExceptionLog log);

	int deleteExceptionLogById(Long id);
}
