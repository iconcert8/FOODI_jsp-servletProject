package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatVO;
import me.foodi.service.ChatService;

public class ChatSelectLastResIdAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ChatVO lastRes = ChatService.getInstance().ChatSelectLastResIdService(request);
		String userId = (String) request.getAttribute("userId");
		String resId = "";
		if(lastRes != null) {
			if(!userId.equals(lastRes.getResId())) {
				resId = lastRes.getResId();
			} else {
				resId = lastRes.getReqId();
			}
			
		}
		return resId;
	}

}
