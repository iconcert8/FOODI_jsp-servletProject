package me.foodi.service;

import java.util.List;

import me.foodi.DAO.FollowDAO;
import me.foodi.domain.FollowVO;

public class FollowService {
	
	private static FollowService service = new FollowService();
	private static FollowDAO dao;
	
	public static FollowService getInstance(){
		dao=FollowDAO.getInstance();
		return service;
	}
	
	public List<FollowVO> followListService(){
		return dao.followList();
	}
}
