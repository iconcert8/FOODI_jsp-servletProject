package me.foodi.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.FollowInfoVO;
import me.foodi.service.FollowService;
import net.sf.json.JSONArray;

public class FollowListSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FollowService service = FollowService.getInstance();
		
		String searchKeyword = request.getParameter("flwSearchKey");		
		if(searchKeyword == null || searchKeyword.equals("")) {
			searchKeyword = null;
		}else {
			searchKeyword = "%"+searchKeyword+"%";
		}
		
		List<FollowInfoVO> followerList = service.followerListService(request, searchKeyword);
		List<FollowInfoVO> followingList = service.followingListService(request, searchKeyword);
		
		List<List> list = new ArrayList<List>();
		list.add(followerList);
		list.add(followingList);
		
		String json = JSONArray.fromObject(list).toString();
		PrintWriter out = response.getWriter();
		out.print(json);
		
		return null;
	}

}
