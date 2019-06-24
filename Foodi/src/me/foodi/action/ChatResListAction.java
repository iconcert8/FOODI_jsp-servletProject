package me.foodi.action;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.domain.ChatNotifyVO;
import me.foodi.service.ChatService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ChatResListAction implements ActionJson {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<String> resList = ChatService.getInstance().chatResListService(request);
		List<String> reqList = ChatService.getInstance().chatReqListService(request);
		List<ChatNotifyVO> readlessList = ChatService.getInstance().chatReadlessService(request);
		Map<String, String> readlessMap = readlessList.stream().collect(Collectors.toMap(ChatNotifyVO::getResId, ChatNotifyVO::getReadless));

		TreeSet<String> tree = new TreeSet<String>();
		tree.addAll(resList);
		tree.addAll(reqList);
		
		JSONArray arr = new JSONArray();
		String resId = (String) request.getParameter("resId");
		
//		if (request.getParameter("new") != null) {
//			resId = request.getParameter("new");
//			tree.add(resId);
//		}
		
		if(!tree.contains(resId)) {
			tree.add(resId);
		}
		
		for (String s : tree) {
			JSONObject jobj = new JSONObject();
			if (s.equals(resId)) {
				jobj.put("selected", s);
				arr.add(jobj);
			} else {
				jobj.put("resId", s);
				
				if(readlessMap.containsKey(s)) {
					jobj.put("readless", readlessMap.get(s));
				}
				arr.add(jobj);
			}
		}

		return arr.toString();
	}

}
