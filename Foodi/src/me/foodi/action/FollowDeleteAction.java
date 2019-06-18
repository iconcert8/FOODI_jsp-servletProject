package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.FollowService;
import net.sf.json.JSONObject;

public class FollowDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FollowService service = FollowService.getInstance();
		
		service.followDeleteService(request);
		
		String resId = request.getParameter("resId");
		JSONObject obj = new JSONObject();
		obj.put("resId", resId);
		response.getWriter().print(obj);
		
		return null;
	}

}
