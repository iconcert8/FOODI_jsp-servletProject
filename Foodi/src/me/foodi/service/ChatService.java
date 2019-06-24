package me.foodi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.ChatDAO;
import me.foodi.domain.ChatNotifyVO;
import me.foodi.domain.ChatVO;
import me.foodi.domain.UserInfoVO;

public class ChatService {

	private static ChatService instance = new ChatService();
	private static ChatDAO dao;

	private ChatService() {
	}

	public static ChatService getInstance() {
		dao = ChatDAO.getInstance();
		return instance;
	}

	public List<ChatVO> chatListService(HttpServletRequest request) {
		Map<String, String> user = new HashMap<String, String>();
		String req = (String) request.getAttribute("userId");
		String res = request.getParameter("resId");
		String lastNo;
		if (request.getParameter("lastNo") != null) {
			lastNo = request.getParameter("lastNo");
			user.put("lastNo", lastNo);
		}
		user.put("reqId", req);
		user.put("resId", res);

		return dao.chatList(user);
	}

	public int chatSendService(HttpServletRequest request) {
		ChatVO send = new ChatVO();
		send.setChatMsg(request.getParameter("chatMsg"));

		send.setReqId((String) request.getAttribute("userId"));
		send.setResId(request.getParameter("resId"));

		System.out.println(send);

		return dao.chatSend(send);
	}

	public int chatUpdateCheckService(HttpServletRequest request) {
		Map<String, String> user = new HashMap<String, String>();
		String reqId = (String) request.getAttribute("userId");
		String resId = request.getParameter("resId");
		user.put("reqId", reqId);
		user.put("resId", resId);
		return dao.chatUpdateCheck(user);
	}

	public ChatVO chatSelectLastMsgService(HttpServletRequest request) {
		Map<String, String> user = new HashMap<String, String>();
		String reqId = (String) request.getAttribute("userId");
		String resId = request.getParameter("resId");
		user.put("reqId", reqId);
		user.put("resId", resId);
		return dao.chatSelectLastMsg(user);
	}

	public List<String> chatResListService(HttpServletRequest request) {
		String userId = (String) request.getAttribute("userId");
		return dao.chatResList(userId);
	}
	
	public List<String> chatReqListService(HttpServletRequest request) {
		String userId = (String) request.getAttribute("userId");
		return dao.chatReqList(userId);
	}

	public ChatVO ChatSelectLastResIdService(HttpServletRequest request) {
		String userId = ((String) request.getAttribute("userId"));
		return dao.chatSelectLastResId(userId);
	}

	public UserInfoVO chatResInfoService(HttpServletRequest request) {
		String resId = request.getParameter("resId");
		return dao.chatResInfo(resId);
	}

	public String chatsearchCheckService(HttpServletRequest request) {
		Map<String, String> user = new HashMap<String, String>();
		String reqId = (String) request.getAttribute("userId");
		String resId = request.getParameter("resId");
		user.put("reqId", reqId);
		user.put("resId", resId);
		return dao.chatSearchCheck(user);
	}

	public int chatDeleteMessageService(HttpServletRequest request) {
		Map<String, String> del = new HashMap<String, String>();
		String reqId = (String) request.getAttribute("userId");
		String chatNo = request.getParameter("chatNo");
		del.put("reqId", reqId);
		del.put("chatNo", chatNo);
		return dao.chatDeleteMessage(del);
	}

	public List<ChatNotifyVO> chatReadlessService(HttpServletRequest request) {
		String userId = (String) request.getAttribute("userId");
		return dao.chatReadless(userId);
	}

	public String chatNotifyService(HttpServletRequest request) {
		String userId = (String) request.getAttribute("userId");
		return dao.chatNotify(userId);
	}

}
