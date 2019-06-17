package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FeedVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.service.MapService;

public class MapAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MapService service = MapService.getInstance();
		List<FeedVO> feeds = service.listMapService(request);
		request.setAttribute("feeds", feeds);
		ActionForward forward = new ActionForward();
		forward.setPath("mapexam.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
