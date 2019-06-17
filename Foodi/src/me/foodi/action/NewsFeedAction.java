package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FeedVO;
import me.foodi.service.FeedService;
import me.foodi.service.NewsFeedService;
 
public class NewsFeedAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NewsFeedService service = NewsFeedService.getInstance();
		ActionForward forward = new ActionForward();
		 
		List<FeedVO> list = service.newsFeedListService();
		
		request.setAttribute("feedlist", list);
		
		forward.setRedirect(false);
		forward.setPath("newsfeed.jsp");
		
		 
		return forward;
	}

	
}
