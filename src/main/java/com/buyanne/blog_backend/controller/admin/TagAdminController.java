package com.buyanne.blog_backend.controller.admin;

import com.buyanne.blog_backend.annotation.OperationLogger;
import com.buyanne.blog_backend.entity.Tag;
import com.buyanne.blog_backend.model.vo.Result;
import com.buyanne.blog_backend.service.BlogService;
import com.buyanne.blog_backend.service.TagService;
import com.buyanne.blog_backend.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class TagAdminController {

    @Autowired
    private BlogService blogService;


    @Autowired
    private TagService tagService;


    @GetMapping("/tags")
    public Result tags(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, pageSize, orderBy);
        PageInfo<Tag> pageInfo = new PageInfo<>(tagService.getTagList());
        return Result.ok("请求成功", pageInfo);
    }
    /**
     * 添加新标签
     *
     * @param tag 标签实体
     * @return
     */
    @OperationLogger("添加标签")
    @PostMapping("/tag")
    public Result saveTag(@RequestBody Tag tag) {
        return getResult(tag, "save");
    }

    /**
     * 按id删除标签
     *
     * @param id 标签id
     * @return
     */
    @OperationLogger("删除标签")
    @DeleteMapping("/tag")
    public Result delete(@RequestParam Long id) {
        //删除存在博客关联的标签后，该博客的查询会出异常
        int num = blogService.countBlogByTagId(id);
        if (num != 0) {
            return Result.error("已有博客与此标签关联，不可删除");
        }
        tagService.deleteTagById(id);
        return Result.ok("删除成功");
    }
    /**
     * 修改标签
     *
     * @param tag 标签实体
     * @return
     */
    @OperationLogger("修改标签")
    @PutMapping("/tag")
    public Result updateTag(@RequestBody Tag tag) {
        return getResult(tag, "update");
    }




    /**
     * 执行标签添加或更新操作：校验参数是否合法，标签是否已存在
     *
     * @param tag  标签实体
     * @param type 添加或更新
     * @return
     */
    private Result getResult(Tag tag, String type) {
        if (StringUtils.isEmpty(tag.getName())) {
            return Result.error("参数不能为空");
        }
        //查询标签是否已存在
        Tag tag1 = tagService.getTagByName(tag.getName());
        //如果 tag1.getId().equals(tag.getId()) == true 就是更新标签
        if (tag1 != null && !tag1.getId().equals(tag.getId())) {
            return Result.error("该标签已存在");
        }
        if ("save".equals(type)) {
            tagService.saveTag(tag);
            return Result.ok("添加成功");
        } else {
            tagService.updateTag(tag);
            return Result.ok("更新成功");
        }
    }

}
