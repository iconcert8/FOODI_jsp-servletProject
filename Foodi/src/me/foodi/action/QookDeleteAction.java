package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.QookService;

public class QookDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		QookService service = QookService.getInstance();
		
		service.qookDeleteService(request);
		
		return null;
	}

}
