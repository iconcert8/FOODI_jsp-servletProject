package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.NotifyVO;
import me.foodi.service.NotifyService;
import net.sf.json.JSONArray;

public class NotifyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NotifyService service = NotifyService.getInstance();
		
		List<NotifyVO> list = service.notifyListService(request);
		String json = JSONArray.fromObject(list).toString();
		response.getWriter().write(json);
		
		return null;
	}

}
