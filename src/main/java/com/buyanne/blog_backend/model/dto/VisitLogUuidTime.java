package com.buyanne.blog_backend.model.dto;

import lombok.*;

import java.util.Date;

/**
 * @Description: 访客更新DTO
 * @Date: 2021-02-05
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VisitLogUuidTime {
	private String uuid;
	private Date time;
	private Integer pv;
}
