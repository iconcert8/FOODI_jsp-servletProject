package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.NewsFeedService;

public class NewsFeedReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NewsFeedService service = NewsFeedService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.insertNewsfeedReplyService(request);
		
		forward.setRedirect(true);
		forward.setPath("feed/newsfeed.do?feedNo="+request.getParameter("feedNo"));
		
		return forward;
	}

}
