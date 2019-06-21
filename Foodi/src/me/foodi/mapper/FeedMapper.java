package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.FeedVO;
import me.foodi.domain.UserAndFeedVO;

public interface FeedMapper {
	int insertFeed(FeedVO feedVO);
	List<UserAndFeedVO> listTagFeed(String tagName);
	
}
