package me.foodi.mapper;

import java.util.List;
import java.util.Map;

import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.SsgVO;
import me.foodi.domain.UserInfoVO;

public interface SearchMapper {
	List<UserInfoVO> searchUser(SearchVO search);
	List<SearchFeedVO> searchFeed(SearchVO search);
	int insertSearch(SearchVO search);
	int insertSsg(SsgVO ssg);
	String[] searchSsg(String userId);
	List<String> searchTag(String keyword);
	List<String> ssgCheck(Map ssgMap);
	int ssgCancel(SsgVO ssg);
}
