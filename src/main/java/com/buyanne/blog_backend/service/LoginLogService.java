package com.buyanne.blog_backend.service;

import com.buyanne.blog_backend.entity.LoginLog;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface LoginLogService {
	List<LoginLog> getLoginLogListByDate(String startDate, String endDate);

	@Async
	void saveLoginLog(LoginLog log);

	void deleteLoginLogById(Long id);
}
