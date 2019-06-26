package me.foodi.mapper;

import java.util.List;

import me.foodi.domain.NotifyVO;

public interface NotifyMapper {
	int notifyInsert(NotifyVO notifyVO);
	List<NotifyVO> notifyList(NotifyVO notifyVO);
	int notifyChkUpdate(NotifyVO notifyVO);
	int notifyCntList(NotifyVO notifyVO);
}
