package com.buyanne.blog_backend.controller;

import com.buyanne.blog_backend.annotation.VisitLogger;
import com.buyanne.blog_backend.model.vo.Result;
import com.buyanne.blog_backend.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutMeController {
    @Autowired
    AboutService aboutService;


    @VisitLogger(behavior = "访问页面" ,content = "关于我")
    @GetMapping("/about")
    public Result about(){

        return Result.ok("获取成功",aboutService.getAboutInfo());
    }
}
