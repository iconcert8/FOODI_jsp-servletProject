package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.FeedService;

public class DeleteFeedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		FeedService service = FeedService.getInstance();
		
		service.deleteFeed(request);
		
		forward.setRedirect(true);
		forward.setPath("/Foodi/timeline/timeline");
		
		return forward;
	}
}