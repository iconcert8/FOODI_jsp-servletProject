package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.foodi.domain.UserAndFeedVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.service.MapService;
import me.foodi.service.QookService;
import me.foodi.service.TimeLineService;

public class QookFeedListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QookService service = QookService.getInstance();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession(true);
		UserInfoVO user = (UserInfoVO) session.getAttribute("loginUser");
		String userId = user.getUserId();

		// Áöµµ
		MapService service2 = MapService.getInstance();
		String[] locs = service2.listMapService(userId);
		for (int i = 0; i < locs.length; i++) {
			request.setAttribute("loc" + i, locs[i]);
		}
		// Äî
		TimeLineService service3 = TimeLineService.getInstance();
		String[] qooks = service3.searchQookService(userId);
		for (int i = 0; i < qooks.length; i++) {
			request.setAttribute("qooks" + i, qooks[i]);
		}

		List<UserAndFeedVO> list = service.qookFeedListService(request);

		request.setAttribute("list", list);

		forward.setRedirect(false);
		forward.setPath("/qook.jsp");
		return forward;
	}

}
