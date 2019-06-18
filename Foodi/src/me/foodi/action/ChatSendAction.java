package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatVO;
import me.foodi.service.ChatService;
import net.sf.json.JSONArray;

public class ChatSendAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int re = ChatService.getInstance().chatSendService(request);
		if(re > 0) {
			List<ChatVO> chatList = ChatService.getInstance().chatListService(request);
			System.out.println("chatsend : " + re);
//			String json = new Gson().toJson(chatList);
			String json = JSONArray.fromObject(chatList).toString();
			System.out.println(json);

			return json;
		} else {
			return null;
		}
	}
	
	

}
