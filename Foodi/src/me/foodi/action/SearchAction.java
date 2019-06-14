package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import me.foodi.domain.FeedVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.service.SearchService;

public class SearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		SearchService service = SearchService.getInstance();
		service.insertSearchService(request);
		/*List<UserInfoVO> userlist = service.searchUserService(keyword);
		List<FeedVO> feedlist = service.searchFeedService(keyword);
		request.setAttribute("userlist", userlist);
		request.setAttribute("feedlist", feedlist);*/
		String keyword=request.getParameter("searchKeyword");
		request.setAttribute("keyword", keyword);
		ActionForward forward = new ActionForward();
		forward.setPath("/searchresult.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
