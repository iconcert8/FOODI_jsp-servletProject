package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FeedVO;
import me.foodi.service.FeedService;
import me.foodi.service.NewsFeedService;
import net.sf.json.JSONArray;
 
public class NewsFeedAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		
		forward.setRedirect(false);
		forward.setPath("newsfeed.jsp");
		
		return forward;
	}

	
}
