package com.buyanne.blog_backend.service;

import com.buyanne.blog_backend.entity.User;

public interface UserService {
    User findUserByUsernameAndPassword(String username,String password);

}
