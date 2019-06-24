package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.TagService;
import net.sf.json.JSONArray;

public class SearchAutoCompleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String keyword = request.getParameter("search");
		List<String> searchAutoList = TagService.getInstance().searchAutoCompleteService(request);
		System.out.println(searchAutoList);
		if(searchAutoList != null) {
			String json = JSONArray.fromObject(searchAutoList).toString();
			System.out.println(json);
			response.getWriter().write(json);
		}
		return null;
	}

}
