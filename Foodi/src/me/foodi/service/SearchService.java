package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.SearchDAO;
import me.foodi.domain.FeedVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.UserInfoVO;

public class SearchService {
	private static SearchService service = new SearchService();
	private static SearchDAO dao;
	
	public static SearchService getInstance(){
		dao=SearchDAO.getInstance();
		return service;
	}
	
	/*public List<UserInfoVO> searchUserService(HttpServletRequest request) throws Exception{
		
		List<UserInfoVO> list = dao.searchUser();
		return list;
	}
	
	public List<FeedVO> searchFeedService(String keyword){
		List<FeedVO> list = dao.searchFeed(keyword);
		return list;
	}*/
	
	public void insertSearchService(HttpServletRequest request)throws Exception{
		SearchVO search=new SearchVO();
		search.setSearchKeyword(request.getParameter("searchKeyword"));
		dao.insertSearch(search);
	}
}
