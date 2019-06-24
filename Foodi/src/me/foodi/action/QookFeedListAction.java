package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.UserAndFeedVO;
import me.foodi.service.QookService;

public class QookFeedListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		QookService service = QookService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<UserAndFeedVO> list = service.qookFeedListService(request);
		
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setPath("/qook.jsp");
		return forward;
	}

}
