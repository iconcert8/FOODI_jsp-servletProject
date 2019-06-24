package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.QookDAO;
import me.foodi.domain.QookVO;
import me.foodi.domain.UserAndFeedVO;
import me.foodi.domain.UserInfoVO;

public class QookService {
	private static QookService service = new QookService();
	private static QookDAO dao;
	
	public static QookService getInstance(){
		dao=QookDAO.getInstance();
		return service;
	}
	
	public UserInfoVO getUser(HttpServletRequest request){
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		return userInfoVO;
	}
	
	public int qookInsertService(HttpServletRequest request){
		String loginId = getUser(request).getUserId();
		QookVO qookVO = new QookVO();
		qookVO.setUserId(loginId);
		qookVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.qookInsert(qookVO);
	}
	
	public int qookDeleteService(HttpServletRequest request){
		String loginId = getUser(request).getUserId();
		QookVO qookVO = new QookVO();
		qookVO.setUserId(loginId);
		qookVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.qookDelete(qookVO);
	}
	
	public List<UserAndFeedVO> qookFeedListService(HttpServletRequest request){
		String loginId = getUser(request).getUserId();
		QookVO qookVO = new QookVO();
		qookVO.setUserId(loginId);
		return dao.qookFeedList(qookVO);
	}
}
