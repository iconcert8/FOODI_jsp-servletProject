package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.ChatService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ChatResListAction implements ActionJson {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String resId = (String) request.getParameter("resId");
		List<String> resList = ChatService.getInstance().chatResListService(request);
		
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
		
		return arr.toString();
	}

}
