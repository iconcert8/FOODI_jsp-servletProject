package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.Feed;
import me.foodi.domain.UserInfo;

public interface SearchMapper {
	List<UserInfo> searchUser(String keyword);
	List<Feed> searchFeed(String keyword);
}
