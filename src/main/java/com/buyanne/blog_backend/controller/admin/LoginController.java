package com.buyanne.blog_backend.controller.admin;

import com.buyanne.blog_backend.entity.User;
import com.buyanne.blog_backend.model.dto.LoginInfo;
import com.buyanne.blog_backend.model.vo.Result;
import com.buyanne.blog_backend.service.UserService;
import com.buyanne.blog_backend.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public Result login(@RequestBody LoginInfo loginInfo) {
        User user = userService.findUserByUsernameAndPassword(loginInfo.getUsername(), loginInfo.getPassword());
        if (!"ROLE_admin".equals(user.getRole())) {
            return Result.create(403, "无权限");

        }
        user.setPassword(null);
        String jwt = JwtUtil.generateToken("admin" + user.getUsername());

        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("token", jwt);
        return Result.ok("登陆成功", map);
    }

}
