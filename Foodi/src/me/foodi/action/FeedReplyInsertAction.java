package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.NewsFeedService;

public class FeedReplyInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		NewsFeedService service = NewsFeedService.getInstance();
		service.feedReplyInsertService(request);
		
		return null;
	}

}
