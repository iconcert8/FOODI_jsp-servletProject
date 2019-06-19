package me.foodi.action;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatVO;
import me.foodi.service.ChatService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ChatAsyncAction implements ActionJson {
	
	private static int a = 0;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int lastNo = Integer.parseInt(request.getParameter("lastNo"));
		ChatVO lastMsg = ChatService.getInstance().chatSelectLastMsgService(request);
//		System.out.println("lastNO : " + lastNo + " | lastMsg chatNO" + lastMsg.getChatNo());
		
		
		List<ChatVO> updateList = null;
		String json = null;
		if(lastMsg.getChatNo() > lastNo) {
//			상대방 메세지 읽음 업데이트
			ChatService.getInstance().chatUpdateCheckService(request);
			updateList = ChatService.getInstance().chatListService(request);
//			ChatService.getInstance().chatCookieService(request, response, updateList, "add");
			System.out.println("[!]updateList : " + updateList);
			json = JSONArray.fromObject(updateList).toString();
		} else {
			json = JSONArray.fromObject(lastMsg).toString();
		}
		
		return json;
	}

}
