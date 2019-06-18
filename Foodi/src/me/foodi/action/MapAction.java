package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.MapService;

public class MapAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MapService service = MapService.getInstance();
		String[] locs = service.listMapService(request);
		String[] loc=new String[locs.length];
		for(int i=0;i<locs.length;i++){
			loc[i]=locs[i];
			request.setAttribute("loc"+i, loc[i]);
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("mapexam.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
