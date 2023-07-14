package com.buyanne.blog_backend.service.impl;

import com.buyanne.blog_backend.entity.CityVisitor;
import com.buyanne.blog_backend.mapper.CityVisitorMapper;
import com.buyanne.blog_backend.service.CityVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 城市访客数量统计业务层实现
 * @Date: 2021-02-26
 */
@Service
public class CityVisitorServiceImpl implements CityVisitorService {
	@Autowired
	CityVisitorMapper cityVisitorMapper;

	@Override
	public void saveCityVisitor(CityVisitor cityVisitor) {
		cityVisitorMapper.saveCityVisitor(cityVisitor);
	}
}
