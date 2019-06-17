package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import me.foodi.service.ChatService;

public class ChatResListAction implements ActionJson {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<String> resList = ChatService.getInstance().chatResListService(request);
		Gson gson = new Gson();
		return new Gson().toJson(resList);
	}

}
