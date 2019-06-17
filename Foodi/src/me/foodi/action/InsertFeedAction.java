package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.FeedService;

public class InsertFeedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest 

request, HttpServletResponse response) throws Exception {
		FeedService service = 

FeedService.getInstance();
		ActionForward forward = new 

ActionForward();
		
		service.insertFeed(request, response);
		
		forward.setRedirect(true);
		forward.setPath("");
		
		
		return forward;
	}
}