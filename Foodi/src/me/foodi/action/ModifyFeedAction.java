package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import me.foodi.service.FeedService;
import me.foodi.service.TagService;

public class ModifyFeedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FeedService feedService = FeedService.getInstance();
		ActionForward forward = new ActionForward();
		
		String uploadPath = "\\WebContent\\upload";
		
		int size = 100 * 1024 * 1024; // 100mb 설정
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		System.out.println(123321321);
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		
		TagService tagService = TagService.getInstance();
		tagService.modifyTag(multi, feedNo);

		forward.setRedirect(true);
		forward.setPath("/Foodi/makeFeed.jsp");
		
		return forward;
	}
}