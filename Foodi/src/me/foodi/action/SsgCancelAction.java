package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.SearchService;

public class SsgCancelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int re = SearchService.getInstance().ssgCancelService(request);
		if(re != -1) {
			response.getWriter().write("success");
		}
		
		return null;
	}

}
