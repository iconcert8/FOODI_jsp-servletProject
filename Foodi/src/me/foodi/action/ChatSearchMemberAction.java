package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.DAO.FollowDAO;
import me.foodi.domain.FollowInfoVO;
import me.foodi.domain.SearchVO;
import me.foodi.service.FollowService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ChatSearchMemberAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		FollowService service = FollowService.getInstance();

		String searchKeyword = request.getParameter("keyword");
		if (searchKeyword == null || searchKeyword.equals("")) {
			searchKeyword = null;
		} else {
			searchKeyword = "%" + searchKeyword + "%";
		}

//		List<FollowInfoVO> followerList = service.followerListService(request, searchKeyword);
		List<FollowInfoVO> followingList = service.followingListService(request, searchKeyword);
		
		JSONArray listArr = new JSONArray();
		
		for(FollowInfoVO f : followingList) {
//			JSONObject jobj = new JSONObject();
//			jobj.put("value", f.getUserId());
//			listArr.add(jobj);
			listArr.add(f.getUserId());
		}
		
		System.out.println(listArr);

		return listArr.toString();
	}

}
