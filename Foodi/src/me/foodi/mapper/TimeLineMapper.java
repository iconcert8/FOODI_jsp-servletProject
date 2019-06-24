package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.UserInfoVO;

public interface TimeLineMapper {
	List<SearchFeedVO> searchFeed(String userId);
	String[] matchTag(int feedNo);
	String[] searchQook(String userId);
	UserInfoVO searchUser(String userId);
}
