package me.foodi.service;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.QookDAO;
import me.foodi.domain.QookVO;

public class QookService {
	private static QookService service = new QookService();
	private static QookDAO dao;
	
	public static QookService getInstance(){
		dao=QookDAO.getInstance();
		return service;
	}
	
	public int qookInsertService(HttpServletRequest request){
		String loginId = (String)request.getSession().getAttribute("loginId");
		QookVO qookVO = new QookVO();
		qookVO.setUserId(loginId);
		qookVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.qookInsert(qookVO);
	}
	
	public int qookDeleteService(HttpServletRequest request){
		String loginId = (String)request.getSession().getAttribute("loginId");
		QookVO qookVO = new QookVO();
		qookVO.setUserId(loginId);
		qookVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.qookDelete(qookVO);
	}
}
