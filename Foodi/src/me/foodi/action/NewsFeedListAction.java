package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.UserAndFeedVO;
import me.foodi.service.FeedService;
import net.sf.json.JSONArray;

public class NewsFeedListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FeedService service = FeedService.getInstance();
		
		
		List<UserAndFeedVO> list = service.newsFeedListService(request);
		
		String json = JSONArray.fromObject(list).toString();
		response.getWriter().write(json);
		  
		  
		return null;
	}                                    

}
