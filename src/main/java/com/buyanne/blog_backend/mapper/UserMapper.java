package com.buyanne.blog_backend.mapper;

import com.buyanne.blog_backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User findByUsername(String username);
}
