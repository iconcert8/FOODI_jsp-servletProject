package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.QookVO;
import me.foodi.domain.UserAndFeedVO;

public interface QookMapper {
	int qookInsert(QookVO qookVO);
	int qookDelete(QookVO qookVO);
	List<UserAndFeedVO> qookFeedList(QookVO qookVO);
}
