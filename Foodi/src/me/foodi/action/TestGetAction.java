package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.DAO.UserInfoDao;
import me.foodi.domain.UserInfoVO;

public class TestGetAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		UserInfoDao dao = UserInfoDao.getInstance();
		
		UserInfoVO loginUser = dao.testGet(request.getParameter("id"));
		if(loginUser == null){
			forward.setRedirect(false);
			forward.setPath("/TestLoginFalse.jsp");
		}else{
			request.getSession().setAttribute("loginUser", loginUser);
			
			forward.setRedirect(false);
			forward.setPath("/TestPageList.jsp");			
		}
		
		return forward;
	}
}
