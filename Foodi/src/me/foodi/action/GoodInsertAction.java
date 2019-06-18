package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.GoodService;

public class GoodInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoodService service = GoodService.getInstance();
		
		service.goodInsertService(request);
		
		return null;
	}

}
