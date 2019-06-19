package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.FollowDAO;
import me.foodi.domain.FollowInfoVO;
import me.foodi.domain.FollowVO;
import me.foodi.domain.SearchVO;
import me.foodi.domain.UserInfoVO;

public class FollowService {
	
	private static FollowService service = new FollowService();
	private static FollowDAO dao;
	
	public static FollowService getInstance(){
		dao=FollowDAO.getInstance();
		return service;
	}
	
	public UserInfoVO getUser(HttpServletRequest request){
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		return userInfoVO;
	}

	public List<FollowInfoVO> followerListService(HttpServletRequest request, String searchKeyword){
		SearchVO searchVO = new SearchVO();
		searchVO.setUserId(getUser(request).getUserId());
		searchVO.setSearchKeyword(searchKeyword);
		return dao.followerList(searchVO);
	}
	
	public List<FollowInfoVO> followingListService(HttpServletRequest request, String searchKeyword){
		SearchVO searchVO = new SearchVO();
		searchVO.setUserId(getUser(request).getUserId());
		searchVO.setSearchKeyword(searchKeyword);
		return dao.followingList(searchVO);
	}
	
	public int followInsertService(HttpServletRequest request) {
		FollowVO followVO = new FollowVO();
		followVO.setReqId(getUser(request).getUserId());
		followVO.setResId(request.getParameter("resId"));
		return dao.followInsert(followVO);
	}
	
	public int followDeleteService(HttpServletRequest request) {
		FollowVO followVO = new FollowVO();
		followVO.setReqId(getUser(request).getUserId());
		followVO.setResId(request.getParameter("resId"));
		return dao.followDelete(followVO);
	}
}
