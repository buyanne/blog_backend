package com.buyanne.blog_backend.mapper;

import com.buyanne.blog_backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户持久层接口
 * @Date: 2020-07-19
 */
@Mapper
@Repository
public interface UserMapper {
	User findByUsername(String username);
}
