package com.buyanne.blog_backend.controller.admin;

import com.buyanne.blog_backend.entity.Blog;
import com.buyanne.blog_backend.entity.Category;
import com.buyanne.blog_backend.entity.Tag;
import com.buyanne.blog_backend.model.vo.BlogInfo;
import com.buyanne.blog_backend.model.vo.Result;
import com.buyanne.blog_backend.service.BlogService;
import com.buyanne.blog_backend.service.CategoryService;
import com.buyanne.blog_backend.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class BlogAdminController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public Result blogs(@RequestParam(defaultValue = "") String title,
                        @RequestParam(defaultValue = "") Integer categoryId,
                        @RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "10") Integer pageSize) {
        String orderBy = "create_time desc";
        PageHelper.startPage(pageNum, pageSize, orderBy);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogService.getListByTitleAndCategoryId(title, categoryId));
        List<Category> categories = categoryService.getCategoryList();
        Map<String, Object> map = new HashMap<>();
        map.put("blogs", pageInfo);
        map.put("categories", categories);
        return Result.ok("请求成功", map);
    }

    @GetMapping("/blog")
    public Result getBlog(@RequestParam Long id) {
        Blog blog = blogService.getBlogById(id);
        return Result.ok("获取成功", blog);
    }

    @GetMapping("/categoryAndTag")
    public Result categoryAndTag() {
        List<Category> categories = categoryService.getCategoryList();
        List<Tag> tags = tagService.getTagList();
        Map<String, Object> map = new HashMap<>();
        map.put("categories", categories);
        map.put("tags", tags);
        return Result.ok("请求成功", map);
    }

}
