package me.foodi.service;

import java.util.List;

import me.foodi.DAO.SearchDAO;
import me.foodi.domain.FeedVO;
import me.foodi.domain.UserInfoVO;

public class SearchService {
	private static SearchService service = new SearchService();
	private static SearchDAO dao;
	
	public static SearchService getInstance(){
		dao=SearchDAO.getInstance();
		return service;
	}
	
	public List<UserInfoVO> searchUserService(String keyword){
		List<UserInfoVO> list = dao.searchUser(keyword);
		return list;
	}
	
	public List<FeedVO> searchFeedService(String keyword){
		List<FeedVO> list = dao.searchFeed(keyword);
		return list;
	}
}
