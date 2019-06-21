package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.ChatService;

public class ChatDeleteMessageAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int re = ChatService.getInstance().chatDeleteMessageService(request);
		if(re > 0) {
			return "delete success";
		} else {
			return "delete fail";
		}
		
	}

}
