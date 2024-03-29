package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.UserAndFeedVO;
import me.foodi.service.FeedService;
import net.sf.json.JSONObject;

public class FeedGetAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FeedService service = FeedService.getInstance();
		
		UserAndFeedVO feedVO = service.detailNewsFeedService(request);
		
		String json = JSONObject.fromObject(feedVO).toString();
		response.getWriter().print(json);
		
		return null;
	}

}
