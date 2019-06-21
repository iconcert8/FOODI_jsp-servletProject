package me.foodi.action;

import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.UserInfoVO;
import me.foodi.service.ChatService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ChatSearchCheckAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String json = ChatService.getInstance().chatsearchCheckService(request);
		if(json != null) {
			String resId = (String) request.getParameter("resId");
			List<String> resList = ChatService.getInstance().chatResListService(request);
			List<String> reqList = ChatService.getInstance().chatReqListService(request);
			TreeSet<String> tree = new TreeSet<String>();
			tree.addAll(resList);
			tree.addAll(reqList);
			
			if(tree.contains(resId)) {
				JSONObject jobj = new JSONObject();
				jobj.put("resId", resId);
				json = jobj.toString();
			} else {
				UserInfoVO userInfo = ChatService.getInstance().chatResInfoService(request);
				JSONObject jobj = (JSONObject) JSONSerializer.toJSON(userInfo);
				json = jobj.toString();
				System.out.println(json);
			}
	
		}
		
		return json;
	}

}
