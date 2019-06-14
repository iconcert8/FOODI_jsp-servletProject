package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.UserInfoVO;

public interface SearchMapper {
	List<UserInfoVO> searchUser(SearchVO search);
	List<SearchFeedVO> searchFeed(SearchVO search);
	int insertSearch(SearchVO search);
}
