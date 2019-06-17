package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import me.foodi.service.ChatService;

public class ChatResListAction implements ActionJson {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<String> resList = ChatService.getInstance().chatResListService(request);
		JSONArray arr = new JSONArray();
		for(String s : resList) {
			JSONObject jobj = new JSONObject();
			jobj.put("resId", s);
			arr.add(jobj);
		}
		
//		return new Gson().toJson(resList);
		return arr.toJSONString();
	}

}
