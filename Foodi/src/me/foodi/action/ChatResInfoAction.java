package me.foodi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.DAO.ChatDAO;
import me.foodi.domain.UserInfoVO;
import me.foodi.service.ChatService;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class ChatResInfoAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserInfoVO userInfo = ChatService.getInstance().chatResInfoService(request);
		JSONObject json = (JSONObject) JSONSerializer.toJSON(userInfo);
		
		return json.toString();
	}

}
