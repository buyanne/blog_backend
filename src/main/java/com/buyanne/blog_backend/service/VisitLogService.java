package com.buyanne.blog_backend.service;

import com.buyanne.blog_backend.entity.VisitLog;
import com.buyanne.blog_backend.model.dto.VisitLogUuidTime;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface VisitLogService {
	List<VisitLog> getVisitLogListByUUIDAndDate(String uuid, String startDate, String endDate);

	List<VisitLogUuidTime> getUUIDAndCreateTimeByYesterday();

	@Async
	void saveVisitLog(VisitLog log);

	void deleteVisitLogById(Long id);
}
