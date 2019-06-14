package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.SearchDAO;
import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.UserInfoVO;

public class SearchService {
	private static SearchService service = new SearchService();
	private static SearchDAO dao;
	
	public static SearchService getInstance(){
		dao=SearchDAO.getInstance();
		return service;
	}
	

	public List<UserInfoVO> searchUserService(HttpServletRequest request) throws Exception{
		SearchVO search = new SearchVO();
		search.setSearchKeyword("%"+request.getParameter("searchKeyword")+"%");
		List<UserInfoVO> list = dao.searchUser(search);
		return list;
	}
	

	public List<SearchFeedVO> searchFeedService(HttpServletRequest request)throws Exception{
		SearchVO search = new SearchVO();
		search.setSearchKeyword("%"+request.getParameter("searchKeyword")+"%");
		List<SearchFeedVO> list = dao.searchFeed(search);

		return list;
	}
	
	public void insertSearchService(HttpServletRequest request)throws Exception{
		SearchVO search=new SearchVO();
		search.setSearchKeyword(request.getParameter("searchKeyword"));
		dao.insertSearch(search);
	}
}
