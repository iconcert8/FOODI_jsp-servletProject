package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.TagVO;
import me.foodi.service.TagService;
import net.sf.json.JSONArray;

public class TagHTGListACtion implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		TagService service = TagService.getInstance();
		
		List<TagVO> list = service.listHTG(request);
		String json = JSONArray.fromObject(list).toString();
		response.getWriter().write(json);
		
		return null;
	}
}
