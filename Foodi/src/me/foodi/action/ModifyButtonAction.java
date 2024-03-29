package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FeedVO;
import me.foodi.domain.TagVO;
import me.foodi.service.FeedService;
import me.foodi.service.TagService;

public class ModifyButtonAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		
		
		FeedService feedService = FeedService.getInstance();
		FeedVO feedVO = feedService.callFeed(feedNo);
		
		String imgPath = "/Foodi/upload/" + feedVO.getFeedImg();
		feedVO.setFeedImg(imgPath);
		
		TagService tagService = TagService.getInstance();
		List<TagVO> tagVO= tagService.callTag(feedNo);

		String tagName = "";
		for(int i = 0; i < tagVO.size(); i++){
			tagName += tagVO.get(i).getTagName();
		}
		
		
		request.setAttribute("feedVO", feedVO);
		request.setAttribute("tagName", tagName);
		
		forward.setRedirect(false);
		forward.setPath("/modifyFeed.jsp");

		return forward;
	}
}