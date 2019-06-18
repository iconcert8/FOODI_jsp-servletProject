package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.FollowDAO;
import me.foodi.domain.FollowInfoVO;
import me.foodi.domain.SearchVO;

public class FollowService {
	
	private static FollowService service = new FollowService();
	private static FollowDAO dao;
	
	public static FollowService getInstance(){
		dao=FollowDAO.getInstance();
		return service;
	}

	public List<FollowInfoVO> followerListService(HttpServletRequest request, String searchKeyword){
		String loginId = (String)request.getSession().getAttribute("loginId");
		SearchVO searchVO = new SearchVO();
		searchVO.setUserId(loginId);
		searchVO.setSearchKeyword(searchKeyword);
		return dao.followerList(searchVO);
	}
	
	public List<FollowInfoVO> followingListService(HttpServletRequest request, String searchKeyword){
		String loginId = (String)request.getSession().getAttribute("loginId");
		SearchVO searchVO = new SearchVO();
		searchVO.setUserId(loginId);
		searchVO.setSearchKeyword(searchKeyword);
		return dao.followingList(searchVO);
	}
	
	public int followInsertService(HttpServletRequest request) {
		String loginId = (String)request.getSession().getAttribute("loginId");
		FollowInfoVO followInfoVO = new FollowInfoVO();
		followInfoVO.setLoginId(loginId);
		followInfoVO.setUserId(request.getParameter("resId"));
		return dao.followInsert(followInfoVO);
	}
	
	public int followDeleteService(HttpServletRequest request) {
		String loginId = (String)request.getSession().getAttribute("loginId");
		FollowInfoVO followInfoVO = new FollowInfoVO();
		followInfoVO.setLoginId(loginId);
		followInfoVO.setUserId(request.getParameter("resId"));
		return dao.followDelete(followInfoVO);
	}
}
