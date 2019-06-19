package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.foodi.domain.SearchFeedVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.service.MapService;
import me.foodi.service.TimeLineService;

public class TimelineAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//session으로부터 아이디 불러오기
		HttpSession session = request.getSession(true);
		UserInfoVO user = (UserInfoVO) session.getAttribute("loginUser");
		request.setAttribute("user", user);
		String userId= user.getUserId();
		
		//지도
		MapService service = MapService.getInstance();
		String[] locs = service.listMapService(userId);
		for(int i=0;i<locs.length;i++){
			request.setAttribute("loc"+i, locs[i]);
		}
		
		//피드
		TimeLineService service2 = TimeLineService.getInstance();
		List<SearchFeedVO> feeds = service2.searchFeedService(userId);
		request.setAttribute("feeds", feeds);
		
		//쿡
		String[] qooks = service2.searchQookService(userId);
		for(int i=0;i<qooks.length;i++){
			request.setAttribute("qooks"+i, qooks[i]);
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("/timeline.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
