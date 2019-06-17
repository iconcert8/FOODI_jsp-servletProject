package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.FeedService;

public class InsertFeedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest

	request, HttpServletResponse response) throws Exception {
		FeedService service = FeedService.getInstance();
		ActionForward forward = new ActionForward();
		System.out.println("1");
		service.insertFeed(request, response);
		System.out.println("2");
		forward.setRedirect(true);
		System.out.println("3");
		forward.setPath("");
		System.out.println("4");

		return forward;
	}
}