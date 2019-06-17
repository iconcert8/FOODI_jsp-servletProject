package me.foodi.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import me.foodi.DAO.ChatDAO;
import me.foodi.domain.ChatVO;

public class ChatService {
	
	private static ChatService instance = new ChatService();
	private static ChatDAO dao;
	
	private ChatService() { }

	public static ChatService getInstance(){
		dao = ChatDAO.getInstance();
		return instance;
	}
	
	public List<ChatVO> chatListService(HttpServletRequest request) {
		Map<String , String> user = new HashMap<String, String>();
		String req = (String) request.getSession().getAttribute("userId");
		String res = (String) request.getAttribute("res");
		user.put("reqId", req);
		user.put("resId", res);
//		System.out.println(user);
		return dao.chatList(user);
	}

	public int chatSendService(HttpServletRequest request) throws JsonIOException, JsonSyntaxException, IOException {
		ChatVO send = new ChatVO();
//		send.setChatMsg(request.getParameter("chatMsg"));
		send.setChatMsg((String) request.getAttribute("chatMsg"));

		send.setReqId((String) request.getSession().getAttribute("userId"));
		send.setResId((String) request.getAttribute("res"));
		
		return dao.chatSend(send);
	}
	
	public int chatUpdateCheckService(HttpServletRequest request) throws JsonIOException, JsonSyntaxException, IOException {
		Map<String , String> user = new HashMap<String, String>();
		String req = (String) request.getSession().getAttribute("userId");
		String res = (String) request.getAttribute("res");
		user.put("reqId", req);
		user.put("resId", res);
		return dao.chatUpdateCheck(user);
	}
	
	public ChatVO chatSelectLastMsgService(HttpServletRequest request) {

		String userId = ((String) request.getSession().getAttribute("userId"));
		return dao.chatSelectLastMsg(userId);
	}

	public List<String> chatResListService(HttpServletRequest request) {
		String userId = (String) request.getSession().getAttribute("userId");
		return dao.chatResList(userId);
	}
	
	

}
