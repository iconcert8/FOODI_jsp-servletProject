package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.FollowService;

public class FollowDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FollowService service = FollowService.getInstance();
		
		service.followDeleteService(request);
		
		return null;
	}

}
