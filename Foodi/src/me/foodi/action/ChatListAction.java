package me.foodi.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatVO;
import me.foodi.service.ChatService;
import net.sf.json.JSONArray;

public class ChatListAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		상대방 메세지 읽음 업데이트
		int re = ChatService.getInstance().chatUpdateCheckService(request);
		
		
		ChatVO lastMsg = ChatService.getInstance().chatSelectLastMsgService(request);	

		
//		쿠키 기능 실패
//		if(lastMsg.getReqId().equals(request.getParameter("resId"))) {		
//			ChatService.getInstance().chatCookieService(request, response, null, "update");
//		} else if(lastMsg.getChatChk().equals("0")) {
//			ChatService.getInstance().chatCookieService(request, response, null, "update");
//		}
				
		List<ChatVO> chatList = ChatService.getInstance().chatListService(request);
//		String json = ChatService.getInstance().chatCookieService(request, response, chatList, "add");
		
		String json = JSONArray.fromObject(chatList).toString();
	
		return json;
	}

}
