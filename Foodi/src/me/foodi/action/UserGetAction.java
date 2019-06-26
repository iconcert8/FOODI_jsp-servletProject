package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FollowInfoVO;
import me.foodi.service.UserInfoService;
import net.sf.json.JSONObject;

public class UserGetAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserInfoService service = UserInfoService.getInstance();
		FollowInfoVO info = service.userGet(request);
		
		JSONObject obj = new JSONObject();
		obj.put("info", info);
		response.getWriter().print(obj);
		
		return null;
	}

}
