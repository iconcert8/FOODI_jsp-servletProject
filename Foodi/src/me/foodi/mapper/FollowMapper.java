package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.FollowInfoVO;
import me.foodi.domain.SearchVO;

public interface FollowMapper {
	
	List<FollowInfoVO> followerList(SearchVO searchVO);
	List<FollowInfoVO> followingList(SearchVO searchVO);
	int followInsert(FollowInfoVO followInfoVO);
	int followDelete(FollowInfoVO followInfoVO);
}
