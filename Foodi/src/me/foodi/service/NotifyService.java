package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.NotifyDAO;
import me.foodi.domain.NotifyVO;

public class NotifyService {
	
	private static NotifyService service = new NotifyService();
	private static NotifyDAO dao;
	
	public static NotifyService getInstance(){
		dao = NotifyDAO.getInstance();
		return service;
	}
	
	public int notifyInsertService(HttpServletRequest request){
		String loginId = (String)request.getSession().getAttribute("loginId");
		NotifyVO notifyVO = new NotifyVO();
		notifyVO.setReqId(loginId);
		notifyVO.setResId(request.getParameter("resId"));
		
		String type = request.getParameter("type");
		if(type.equals("follow")){
			notifyVO.setNotifyMsg(loginId+"님이 팔로우 하였습니다");			
		}else if(type.equals("good")){
			notifyVO.setNotifyMsg(loginId+"님이 게시물에 좋아요를 눌렀습니다");
		}else if(type.equals("qook")){
			notifyVO.setNotifyMsg(loginId+"님이 게시물을 쿡 했습니다");
		}else{
			notifyVO.setNotifyMsg("기타 알림");
		}
		
		return dao.notifyInsert(notifyVO);
	}
	
	public List<NotifyVO> notifyListService(HttpServletRequest request){
		String loginId = (String)request.getSession().getAttribute("loginId");
		NotifyVO notifyVO = new NotifyVO();
		notifyVO.setResId(loginId);
		
		String startRowStr = request.getParameter("startRow");
		int startRow = -1;
		if(startRowStr == null || startRowStr.equals("")){
		}else {
			startRow = Integer.parseInt(startRowStr);
		}
		notifyVO.setNotifyNo(startRow);
		
		return dao.notifyList(notifyVO);
	}
	
	public int notifyCheckNewService(HttpServletRequest request){
		String loginId = (String)request.getSession().getAttribute("loginId");
		NotifyVO notifyVO = new NotifyVO();
		notifyVO.setResId(loginId);
		
		int currentSum = Integer.parseInt(request.getParameter("ntfSum"));
		int dbSum = dao.notifyCntList(notifyVO);
		if(currentSum < dbSum){
			return currentSum+1;
		}else{
			return 0;
		}
		
	}
}
