package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.ChatService;

public class ChatNotifyAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String json = ChatService.getInstance().chatNotifyService(request);
		
		return json;
	}

}
