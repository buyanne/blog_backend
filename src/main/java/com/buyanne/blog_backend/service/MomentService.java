package com.buyanne.blog_backend.service;

import com.buyanne.blog_backend.entity.Moment;

import java.util.List;

public interface MomentService {
	List<Moment> getMomentList();

	List<Moment> getMomentVOList(Integer pageNum, boolean adminIdentity);

	void addLikeByMomentId(Long momentId);

	void updateMomentPublishedById(Long momentId, Boolean published);

	Moment getMomentById(Long id);

	void deleteMomentById(Long id);

	void saveMoment(Moment moment);

	void updateMoment(Moment moment);
}
