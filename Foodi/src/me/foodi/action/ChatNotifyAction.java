package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.service.ChatService;

public class ChatNotifyAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String notify = ChatService.getInstance().chatNotifyService(request);
		if(notify == null) {
			notify = "0";
		}
		return notify;
	}

}
