package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		request.getSession().setAttribute("loginUser", null);
		
		forward.setRedirect(true);
		forward.setPath("../toolbar.jsp");
		
		return forward;
	}
}