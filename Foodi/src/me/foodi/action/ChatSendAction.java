package me.foodi.action;

import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import me.foodi.domain.ChatVO;
import me.foodi.service.ChatService;

public class ChatSendAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(new InputStreamReader(request.getInputStream()));
		request.setAttribute("res", jsonObject.get("res").getAsString());
		request.setAttribute("chatMsg", jsonObject.get("chatMsg").getAsString());
		
		int re = ChatService.getInstance().chatSendService(request);
		if(re > 0) {
			List<ChatVO> chatList = ChatService.getInstance().chatListService(request);
			
			String json = new Gson().toJson(chatList);
//			JsonArray array = new JsonParser().parse(json).getAsJsonArray();
			return json;
		} else {
			return null;
		}
	}
	
	

}
