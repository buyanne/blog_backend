package com.buyanne.blog_backend.mapper;

import com.buyanne.blog_backend.entity.VisitRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 访问记录持久层接口
 * @Date: 2021-02-23
 */
@Mapper
@Repository
public interface VisitRecordMapper {
	List<VisitRecord> getVisitRecordListByLimit(Integer limit);

	int saveVisitRecord(VisitRecord visitRecord);
}
