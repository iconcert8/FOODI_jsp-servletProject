package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.FeedService;
import me.foodi.service.TagService;

public class InsertFeedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FeedService feedService = FeedService.getInstance();
		TagService tagService = TagService.getInstance();
		ActionForward forward = new ActionForward();
		
		tagService.insertTag(request, response);
		feedService.insertFeed(request, response);
		
		forward.setRedirect(true);
		
		forward.setPath("foodi/makeFeed.jsp");
		
		return forward;
	}
}