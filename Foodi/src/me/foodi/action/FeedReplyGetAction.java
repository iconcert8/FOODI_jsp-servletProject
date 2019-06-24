package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ReplyVO;
import me.foodi.service.FeedService;
import net.sf.json.JSONArray;

public class FeedReplyGetAction implements Action{
 
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FeedService service = FeedService.getInstance();
		
		List<ReplyVO> list = service.feedReplyGetService(request);
		String json = JSONArray.fromObject(list).toString();
		response.getWriter().write(json);
		
		return null;
	}
}
 