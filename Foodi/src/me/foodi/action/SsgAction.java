package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.foodi.domain.UserInfoVO;
import me.foodi.service.SearchService;

public class SsgAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SearchService service = SearchService.getInstance();
		HttpSession session = request.getSession(true);
		UserInfoVO user = (UserInfoVO) session.getAttribute("loginUser");
		String userId=user.getUserId();
		service.insertSsgService(request,userId);


		return null;
	}

}
