package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatVO;
import me.foodi.service.ChatService;

public class ChatListAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
//		ChatService.getInstance().chatUpdateCheckService(request);
		List<ChatVO> chatList = ChatService.getInstance().chatListService(request);
		System.out.println("[!]chatList : " + chatList);
		
		return null;
	}

}
