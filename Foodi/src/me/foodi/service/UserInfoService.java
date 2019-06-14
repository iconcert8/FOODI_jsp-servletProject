package me.foodi.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.DAO.UserInfoDao;
import me.foodi.domain.UserInfoVO;

public class UserInfoService {
	private static UserInfoService service = new UserInfoService();
	private static UserInfoDao dao;
	
	public static UserInfoService getInstance() {
		dao = UserInfoDao.getInstance();
		return service;
	}
	
	public int insertUserInfoService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		UserInfoVO userInfoVO = new UserInfoVO();
		userInfoVO.setUserId(request.getParameter("userId"));
		userInfoVO.setUserPass(request.getParameter("userPass"));
		userInfoVO.setUserNick(request.getParameter("userNick"));
		userInfoVO.setUserEamil(request.getParameter("userEamil"));
		userInfoVO.setUserImg(request.getParameter("userImg"));
		userInfoVO.setUserLock(request.getParameter("userLock"));
		return dao.userInfoInsert(userInfoVO);
		
		
	}
}
