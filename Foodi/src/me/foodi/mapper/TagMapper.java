package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.TagVO;

public interface TagMapper {
	int insertTag(int feedNo, String tagName[]);
	List<TagVO> listHTG();
}
