package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.NotifyService;

public class NotifyInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NotifyService service = NotifyService.getInstance();
		
		service.notifyInsertService(request);
		
		return null;
	}

}
