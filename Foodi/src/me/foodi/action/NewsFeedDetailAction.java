package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
import me.foodi.service.NewsFeedService;

public class NewsFeedDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NewsFeedService service = NewsFeedService.getInstance();
		ActionForward forward = new ActionForward();
		
		FeedVO feedVO = service.detailNewsFeedService(request);
		List<ReplyVO> reply = service.newsfeedReplyService(request);
		
		request.setAttribute("feedVO", feedVO);
		request.setAttribute("reply", reply);
		
		forward.setRedirect(false);
		forward.setPath("/newsfeedDetail.jsp");
		
		return forward;
	}

}
