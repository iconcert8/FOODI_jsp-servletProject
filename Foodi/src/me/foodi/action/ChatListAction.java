package me.foodi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatVO;

public class ChatListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<ChatVO> chatList;
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("chat.jsp");
		return forward;
	}

}
