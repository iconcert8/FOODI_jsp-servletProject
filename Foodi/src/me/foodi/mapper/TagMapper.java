package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.TagVO;

public interface TagMapper {
	int insertTag(TagVO tagVO);
	List<TagVO> listHTG();
	List<TagVO> callTag(int feedNo);
	List<String> searchAutoComplete(String keyword);
	int deleteTag(int feedNo);
}
