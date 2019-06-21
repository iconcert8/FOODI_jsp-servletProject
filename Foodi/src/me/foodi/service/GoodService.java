package me.foodi.service;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.GoodDAO;
import me.foodi.domain.GoodVO;

public class GoodService {
	private static GoodService service = new GoodService();
	private static GoodDAO dao;
	
	public static GoodService getInstance(){
		dao=GoodDAO.getInstance();
		return service;
	}
	
	public int goodInsertService(HttpServletRequest request){
		String loginId = (String)request.getSession().getAttribute("loginId");
		GoodVO goodVO = new GoodVO();
		goodVO.setUserId(loginId);
		goodVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.goodInsert(goodVO);
	}
	
	public int goodDeleteService(HttpServletRequest request){
		String loginId = (String)request.getSession().getAttribute("loginId");
		GoodVO goodVO = new GoodVO();
		goodVO.setUserId(loginId);
		goodVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.goodDelete(goodVO);
	}
}
