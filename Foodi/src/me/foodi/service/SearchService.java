package me.foodi.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.SearchDAO;
import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.SsgVO;
import me.foodi.domain.TagVO;
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
		String userId = (String) request.getAttribute("userId");
		List<UserInfoVO> list = dao.searchUser(search);
		if(list != null) {
			UserInfoVO user = null;
			for(int i=0; i < list.size(); i++) {
				if(list.get(i).getUserId().equals(userId)) {
					list.remove(i);
				}
			}
		}
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
		search.setUserId((String) request.getAttribute("userId"));
		search.setSearchKeyword(request.getParameter("searchKeyword"));
		if(!search.getSearchKeyword().equals("")) {
			dao.insertSearch(search);
		}
		
	}
	
	public int insertSsgService(HttpServletRequest request)throws Exception{
		String userId=(String) request.getAttribute("userId");
		String tagName=request.getParameter("tagName");
		SsgVO ssg = new SsgVO();
		ssg.setTagName(tagName);
		ssg.setUserId(userId);
		return dao.insertSsg(ssg);
	}
	
	public String[] searchSsgService(String userId){
		String[] list = dao.searchSsg(userId);
		
		return list;
	}

	public List<String> searchTagService(HttpServletRequest request) {
		String keyword = "%" + request.getParameter("searchKeyword") + "%";
		return dao.searchTag(keyword);
	}

	public List<String> ssgCheckService(HttpServletRequest request) {
		String ssgString = request.getParameter("ssglist");
		String[] ssgArr = ssgString.split(",");
		Map ssgMap = new HashMap();
		ssgMap.put("ssgArr", ssgArr);
		return dao.ssgCheck(ssgMap);
	}

	public int ssgCancelService(HttpServletRequest request) {
		String userId=(String) request.getAttribute("userId");
		String tagName=request.getParameter("tagName");
		SsgVO ssg = new SsgVO();
		ssg.setTagName(tagName);
		ssg.setUserId(userId);
		return dao.ssgCancel(ssg);
	}
}
