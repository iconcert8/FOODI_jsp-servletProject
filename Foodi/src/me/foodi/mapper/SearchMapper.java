package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.FeedVO;
import me.foodi.domain.UserInfo;

public interface SearchMapper {
	List<UserInfo> searchUser(String keyword);
	List<FeedVO> searchFeed(String keyword);
}
