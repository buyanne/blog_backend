package com.buyanne.blog_backend.service;

import com.buyanne.blog_backend.entity.User;
import com.buyanne.blog_backend.mapper.UserMapper;
import com.buyanne.blog_backend.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user=userMapper.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");

        }
        if(!HashUtils.matchBC(password,user.getPassword())){
            throw new UsernameNotFoundException("密码错误");
        }

        return user;
    }
}
