package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.foodi.domain.UserInfoVO;
import me.foodi.service.SearchService;

public class SsgInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		SearchService service = SearchService.getInstance();
		int re = service.insertSsgService(request);
		if(re != -1) {
			response.getWriter().write("success");
		}
		

		return null;
	}

}
