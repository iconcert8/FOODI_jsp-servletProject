package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.NewsFeedService;

public class NewsFeedAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		
		NewsFeedService service = NewsFeedService.getInstance();
		ActionForward forward = new ActionForward();
		
		int seq = Integer.
		 
		return null;
	}

	
}
