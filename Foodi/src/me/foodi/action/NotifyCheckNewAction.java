package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.NotifyService;
import net.sf.json.JSONObject;

public class NotifyCheckNewAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		NotifyService service = NotifyService.getInstance();
		
		int result = service.notifyCheckNewService(request);
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		response.getWriter().print(obj);
		
		return null;
	}
}
