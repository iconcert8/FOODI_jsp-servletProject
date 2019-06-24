package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FeedVO;
import me.foodi.service.NewsFeedService;
import net.sf.json.JSONArray;

public class NewsFeedListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NewsFeedService service = NewsFeedService.getInstance();
		
		
		List<FeedVO> list = service.newsFeedListService(request);
		
		String json = JSONArray.fromObject(list).toString();
		System.out.println(json);
		response.getWriter().write(json);
		  
		  
		return null;
	}                                    

}
