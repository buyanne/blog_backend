package com.buyanne.blog_backend.controller;

import com.buyanne.blog_backend.annotation.VisitLogger;
import com.buyanne.blog_backend.model.vo.BlogInfo;
import com.buyanne.blog_backend.model.vo.PageResult;
import com.buyanne.blog_backend.model.vo.Result;
import com.buyanne.blog_backend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    @Autowired
    private BlogService blogService;


    @VisitLogger(behavior = "查看标签")
    @GetMapping("/tag")
    public Result tag(@RequestParam String tagName,
                      @RequestParam(defaultValue = "1") Integer pageNum) {

        PageResult<BlogInfo> pageResult = blogService.getBlogInfoListByTagNameAndIsPublished(tagName, pageNum);
        return Result.ok("请求成功", pageResult);
    }

}
