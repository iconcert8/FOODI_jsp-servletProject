package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.FeedVO;
import me.foodi.domain.UserInfoVO;

public interface MapMapper {
	List<FeedVO> listMap(String userId);
}
