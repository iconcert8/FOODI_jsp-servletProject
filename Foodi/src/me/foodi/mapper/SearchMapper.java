package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.FeedVO;
import me.foodi.domain.UserInfoVO;

public interface SearchMapper {
	List<UserInfoVO> searchUser(String keyword);
	List<FeedVO> searchFeed(String keyword);
}
