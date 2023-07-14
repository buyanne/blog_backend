package com.buyanne.blog_backend.mapper;

import com.buyanne.blog_backend.entity.Tag;
import com.buyanne.blog_backend.model.vo.TagBlogCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 博客标签持久层接口
 * @Date: 2020-07-30
 */
@Mapper
@Repository
public interface TagMapper {
	List<Tag> getTagList();

	List<Tag> getTagListNotId();

	List<Tag> getTagListByBlogId(Long blogId);

	int saveTag(Tag tag);

	Tag getTagById(Long id);

	Tag getTagByName(String name);

	int deleteTagById(Long id);

	int updateTag(Tag tag);

	List<TagBlogCount> getTagBlogCount();
}
