package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatVO;
import me.foodi.service.ChatService;

public class ChatSelectLastResIdAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ChatVO lastRes = ChatService.getInstance().ChatSelectLastResIdService(request);
		return lastRes.getResId();
	}

}
