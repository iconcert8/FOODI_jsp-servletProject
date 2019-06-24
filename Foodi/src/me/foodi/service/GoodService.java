package me.foodi.service;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.GoodDAO;
import me.foodi.domain.GoodVO;
import me.foodi.domain.UserInfoVO;

public class GoodService {
	private static GoodService service = new GoodService();
	private static GoodDAO dao;
	
	public static GoodService getInstance(){
		dao=GoodDAO.getInstance();
		return service;
	}
	
	public UserInfoVO getUser(HttpServletRequest request){
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		return userInfoVO;
	}
	
	public int goodInsertService(HttpServletRequest request){
		String loginId = getUser(request).getUserId();
		GoodVO goodVO = new GoodVO();
		goodVO.setUserId(loginId);
		goodVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.goodInsert(goodVO);
	}
	
	public int goodDeleteService(HttpServletRequest request){
		String loginId = getUser(request).getUserId();
		GoodVO goodVO = new GoodVO();
		goodVO.setUserId(loginId);
		goodVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.goodDelete(goodVO);
	}
}
