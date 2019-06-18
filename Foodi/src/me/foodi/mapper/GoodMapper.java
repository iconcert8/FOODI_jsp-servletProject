package me.foodi.mapper;

import me.foodi.domain.GoodVO;

public interface GoodMapper {
	int isGood(GoodVO goodVO);
	int goodInsert(GoodVO goodVO);
	int goodDelete(GoodVO goodVO);
}
