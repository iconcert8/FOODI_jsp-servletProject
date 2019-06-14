package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.Feed;
import me.foodi.domain.UserInfo;
import me.foodi.service.SearchService;

public class SearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		SearchService service = SearchService.getInstance();
		String keyword = "%"+request.getParameter("keyword")+"%";
		List<UserInfo> userlist = service.searchUserService(keyword);
		List<Feed> feedlist = service.searchFeedService(keyword);
		request.setAttribute("userlist", userlist);
		request.setAttribute("feedlist", feedlist);
		
		ActionForward forward = new ActionForward();
		forward.setPath("searchresult.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
