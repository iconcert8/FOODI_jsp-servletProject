package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.SearchFeedVO;

public interface TimeLineMapper {
	List<SearchFeedVO> searchFeed(String userId);
	String[] searchQook(String userId);
}
