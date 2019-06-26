package me.foodi.mapper;

import me.foodi.domain.FollowInfoVO;
import me.foodi.domain.FollowVO;
import me.foodi.domain.UserInfoVO;

public interface UserInfoMapper {
	
	int userInfoInsert(UserInfoVO userInfoVO);
	UserInfoVO testGet(String userId);
	FollowInfoVO userGet(FollowVO followVO);
}
