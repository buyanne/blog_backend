package com.buyanne.blog_backend.mapper;

import com.buyanne.blog_backend.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 友链持久层接口
 * @Date: 2020-09-08
 */
@Mapper
@Repository
public interface FriendMapper {
	List<Friend> getFriendList();

	List<com.buyanne.blog_backend.model.vo.Friend> getFriendVOList();

	int updateFriendPublishedById(Long id, Boolean published);

	int saveFriend(Friend friend);

	int updateFriend(com.buyanne.blog_backend.model.dto.Friend friend);

	int deleteFriend(Long id);

	int updateViewsByNickname(String nickname);
}
