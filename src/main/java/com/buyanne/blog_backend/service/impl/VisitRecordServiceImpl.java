package com.buyanne.blog_backend.service.impl;

import com.buyanne.blog_backend.entity.VisitRecord;
import com.buyanne.blog_backend.mapper.VisitRecordMapper;
import com.buyanne.blog_backend.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 访问记录业务层实现
 * @Date: 2021-02-23
 */
@Service
public class VisitRecordServiceImpl implements VisitRecordService {
	@Autowired
	VisitRecordMapper visitRecordMapper;

	@Override
	public void saveVisitRecord(VisitRecord visitRecord) {
		visitRecordMapper.saveVisitRecord(visitRecord);
	}
}
