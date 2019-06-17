package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FollowInfoVO;
import me.foodi.service.FollowService;

public class FollowListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FollowService service = FollowService.getInstance();
		ActionForward forward = new ActionForward();
		String searchKeyword = request.getParameter("flwSearchKey");		
		if(searchKeyword == null || searchKeyword.equals("")) {
			searchKeyword = null;
		}else {
			searchKeyword = "%"+searchKeyword+"%";
		}
		
		List<FollowInfoVO> followerList = service.followerListService(request, searchKeyword);
		List<FollowInfoVO> followingList = service.followingListService(request, searchKeyword);
		
		request.setAttribute("followerList", followerList);
		request.setAttribute("followingList", followingList);
		
		forward.setRedirect(false);
		forward.setPath("/follow.jsp");
		
		return forward;
	}

}
