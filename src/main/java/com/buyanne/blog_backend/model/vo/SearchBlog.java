package com.buyanne.blog_backend.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: 关键字搜索博客
 * @Date: 2020-09-06
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SearchBlog {
	private Long id;
	private String title;
	private String content;
}
