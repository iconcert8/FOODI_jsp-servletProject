package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FollowVO;
import me.foodi.service.FollowService;

public class FollowAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FollowService service = FollowService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<FollowVO> list = service.followListService();
		
		request.setAttribute("userInfos", list);
		
		forward.setRedirect(false);
		forward.setPath("/follow.jsp");
		
		return forward;
	}

}
