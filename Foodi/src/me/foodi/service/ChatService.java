package me.foodi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
		String res = request.getParameter("resId");
		String lastNo;
		if(request.getParameter("lastNo") != null) {
			lastNo = request.getParameter("lastNo");
			user.put("lastNo", lastNo);
		}
		user.put("reqId", req);
		user.put("resId", res);
		
		System.out.println(user);
		return dao.chatList(user);
	}

	public int chatSendService(HttpServletRequest request) {
		ChatVO send = new ChatVO();
		send.setChatMsg(request.getParameter("chatMsg"));

		send.setReqId((String) request.getSession().getAttribute("userId"));
		send.setResId(request.getParameter("resId"));
		
		System.out.println(send);
		
		return dao.chatSend(send);
	}
	
	public int chatUpdateCheckService(HttpServletRequest request) {
		Map<String , String> user = new HashMap<String, String>();
		String reqId = (String) request.getSession().getAttribute("userId");
		String resId = (String) request.getParameter("resId");
		user.put("reqId", reqId);
		user.put("resId", resId);
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
