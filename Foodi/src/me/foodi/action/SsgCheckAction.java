package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.SearchService;
import net.sf.json.JSONArray;

public class SsgCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<String> ssgCheck = SearchService.getInstance().ssgCheckService(request);
		String json = null;
		
		if(ssgCheck != null) {
			json = JSONArray.fromObject(ssgCheck).toString();
		}
		response.getWriter().write(json);
		
		
		return null;
	}

}
