package com.buyanne.blog_backend.controller.admin;

import com.buyanne.blog_backend.entity.SiteSetting;
import com.buyanne.blog_backend.model.vo.Result;
import com.buyanne.blog_backend.service.SiteSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class SiteSettingAdminController {

    @Autowired
    SiteSettingService siteSettingService;

    @GetMapping("/siteSettings")
    public Result siteSettings() {

        Map<String, List<SiteSetting>> typeMap = siteSettingService.getList();
        return Result.ok("请求成功", typeMap);
    }

    @GetMapping("/webTitleSuffix")
    public Result getWebTieleSuffix() {

        return Result.ok("请求", siteSettingService.getWebTitleSuffix());
    }
}
