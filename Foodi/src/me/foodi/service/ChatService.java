package me.foodi.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.DAO.ChatDAO;
import me.foodi.domain.ChatVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

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
		String resId = (String) request.getParameter("resId");
		user.put("reqId", reqId);
		user.put("resId", resId);
		return dao.chatUpdateCheck(user);
	}

	public ChatVO chatSelectLastMsgService(HttpServletRequest request) {
		Map<String, String> user = new HashMap<String, String>();
		String reqId = (String) request.getAttribute("userId");
		String resId = (String) request.getParameter("resId");
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

	public String chatCookieService(HttpServletRequest request, HttpServletResponse response, List<ChatVO> chatList,
			String command) throws UnsupportedEncodingException {

		JSONArray cookieArr = new JSONArray();
		int lastNo = 0;

//		for (Cookie c : request.getCookies()) {
//			if (c.getName().equals(request.getAttribute("userId") + "|" + request.getParameter("resId"))) {
//				String old = URLDecoder.decode(c.getValue(), "UTF-8");
//				cookieArr = (JSONArray) JSONSerializer.toJSON(old);
//			}
//		}
		
		for (Cookie c : request.getCookies()) {
			if(c.getName().indexOf(request.getAttribute("userId") + "|" + request.getParameter("resId")) != -1) {
				String old = URLDecoder.decode(c.getValue(), "UTF-8");
				JSONObject jobj = (JSONObject) JSONSerializer.toJSON(old);
				lastNo = jobj.getInt("chatNo") > lastNo ? jobj.getInt("chatNo") : lastNo;
				cookieArr.add(jobj);
			}
		}
		System.out.println("lastNo : " + lastNo);
		
//		if (cookieArr.size() != 0) {
//			JSONObject last = (JSONObject) cookieArr.get(cookieArr.size() - 1);
//			lastNo = last.getInt("chatNo");
//			System.out.println("lastNo : " + lastNo);
//		}
		
//		new msg add
		if (command.equals("add")) {
			for (ChatVO chat : chatList) {
				if (chat.getChatNo() > lastNo) {
					cookieArr.add(chat);
				}
			}
		} else if (command.equals("update")) {
			for (int i = 0; i < cookieArr.size(); i++) {
				JSONObject obj = (JSONObject) cookieArr.get(i);
				if (obj.get("reqId").equals(request.getAttribute("userId")) && obj.get("chatChk").equals("1")) {
					obj.element("chatChk", "0");
					cookieArr.set(i, obj);
				}
			}
		}
		
//		cookieArr.sort(new Comparator<JSONObject>() {
//
//			@Override
//			public int compare(JSONObject o1, JSONObject o2) {
//				return o1.getInt("chatChk") - o2.getInt("chatChk");
//			}
//		});
		cookieArr.sort((o1, o2) -> ((JSONObject)o1).getInt("chatChk") - ((JSONObject)o2).getInt("chatChk"));
		
		System.out.println(cookieArr);
		for(int i=0; i < cookieArr.size(); i++) {
			JSONObject jobj = (JSONObject) cookieArr.get(i);
			Cookie cookie = new Cookie(request.getAttribute("userId") + "|" + request.getParameter("resId") + (i + 1), URLEncoder.encode(jobj.toString(), "utf-8"));
			cookie.setMaxAge(60 * 60 * 24 * 365);
			cookie.setPath("Foodi/chat/");
			response.addCookie(cookie);
		}
			
		return cookieArr.toString();
	}

}
