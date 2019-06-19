package me.foodi.action;

import java.util.List;

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
//		상대방의 메세지 이면
		if(lastMsg.getReqId().equals(request.getParameter("resId"))) {		
			ChatService.getInstance().chatCookieService(request, response, null, "update");
//		자신이보낸 메세지를 상대방이 읽은것이 확인되면
		} else if(lastMsg.getChatChk().equals("0")) {
			ChatService.getInstance().chatCookieService(request, response, null, "update");
		}
		
		
		List<ChatVO> chatList = ChatService.getInstance().chatListService(request);
		ChatService.getInstance().chatCookieService(request, response, chatList, "add");
		
		String json = JSONArray.fromObject(chatList).toString();
	
		return json;
	}

}
