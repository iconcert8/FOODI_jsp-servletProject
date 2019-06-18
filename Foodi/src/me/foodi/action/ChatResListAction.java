package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import me.foodi.service.ChatService;

public class ChatResListAction implements ActionJson {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String resId = (String) request.getParameter("resId");
		List<String> resList = ChatService.getInstance().chatResListService(request);
		
		System.out.println(resList);
		
		JSONArray arr = new JSONArray();
		for(String s : resList) {
			JSONObject jobj = new JSONObject();
			if(s.equals(resId)) {
				jobj.put("selected", s);
				arr.add(jobj);
			} else {
				jobj.put("resId", s);
				arr.add(jobj);
			}
			
			
		}
		System.out.println(arr);
		
		
		return arr.toJSONString();
	}

}
