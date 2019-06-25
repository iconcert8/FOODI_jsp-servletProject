package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.TagVO;

public interface TagMapper {
	int insertTag(TagVO tagVO);
	List<TagVO> listHTG();
	List<String> searchAutoComplete(String keyword);
}
