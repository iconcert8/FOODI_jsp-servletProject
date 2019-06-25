package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.NotifyDAO;
import me.foodi.domain.NotifyVO;
import me.foodi.domain.UserInfoVO;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class NotifyService {
	
	private static NotifyService service = new NotifyService();
	private static NotifyDAO dao;
	
	public static NotifyService getInstance(){
		dao = NotifyDAO.getInstance();
		return service;
	}
	
	public UserInfoVO getUser(HttpServletRequest request){
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		return userInfoVO;
	}
	
	public int notifyInsertService(HttpServletRequest request){
		NotifyVO notifyVO = new NotifyVO();
		notifyVO.setReqId(getUser(request).getUserId());
		notifyVO.setResId(request.getParameter("resId"));
		
		String type = request.getParameter("type");
		if(type.equals("follow")){
			notifyVO.setNotifyType("follow");
			notifyVO.setNotifyMsg(getUser(request).getUserId()+"님이 팔로우 하였습니다");			
		}else if(type.equals("good")){
			String feed = request.getParameter("feed");
			JSONObject json = (JSONObject)JSONSerializer.toJSON(feed);
			
			int feedNo = Integer.parseInt(json.getString("feedNo"));
			String feedContent = json.getString("feedContent");
			if(feedContent.length() > 6){feedContent = feedContent.substring(0, 6)+"..";}
			
			notifyVO.setNotifyType("good");
			notifyVO.setFeedNo(feedNo);
			notifyVO.setNotifyMsg(getUser(request).getUserId()+"님이 "+feedContent+" 게시물에 좋아요를 눌렀습니다");
		}else if(type.equals("qook")){
			String feed = request.getParameter("feed");
			JSONObject json = (JSONObject)JSONSerializer.toJSON(feed);
			
			int feedNo = Integer.parseInt(json.getString("feedNo"));			
			String feedContent = json.getString("feedContent");
			if(feedContent.length() > 6){feedContent = feedContent.substring(0, 6)+"..";}
			
			notifyVO.setNotifyType("qook");
			notifyVO.setFeedNo(feedNo);
			notifyVO.setNotifyMsg(getUser(request).getUserId()+"님이 "+feedContent+" 게시물을 쿡 하였습니다");
		}else if(type.equals("reply")){
			String reply = request.getParameter("reply");
			JSONObject json = (JSONObject)JSONSerializer.toJSON(reply);
			
			int feedNo = Integer.parseInt(json.getString("feedNo"));
			String feedContent = json.getString("feedContent");
			if(feedContent.length() > 6){feedContent = feedContent.substring(0, 6)+"..";}
			String replyContent = json.getString("replyContent");
			if(replyContent.length() > 6){replyContent = replyContent.substring(0, 6)+"..";}
			
			notifyVO.setNotifyType("reply");
			notifyVO.setFeedNo(feedNo);
			notifyVO.setNotifyMsg(getUser(request).getUserId()+"님이 " +feedContent+" 게시물에 \""+replyContent+"\" 댓글을 달았습니다");
		}else{
			notifyVO.setNotifyMsg("기타 알림");
		}
		
		return dao.notifyInsert(notifyVO);
	}
	
	public List<NotifyVO> notifyListService(HttpServletRequest request){
		NotifyVO notifyVO = new NotifyVO();
		notifyVO.setResId(getUser(request).getUserId());
		
		String startRowStr = request.getParameter("startRow");
		int startRow = -1;
		if(startRowStr == null || startRowStr.equals("")){
		}else {
			startRow = Integer.parseInt(startRowStr);
		}
		notifyVO.setNotifyNo(startRow);
		
		return dao.notifyList(notifyVO);
	}
	
	public int notifyCheckNewService(HttpServletRequest request){
		NotifyVO notifyVO = new NotifyVO();
		notifyVO.setResId(getUser(request).getUserId());
		
		int currentSum = Integer.parseInt(request.getParameter("ntfSum"));
		int dbSum = dao.notifyCntList(notifyVO);
		if(currentSum < dbSum){
			return currentSum+1;
		}else{
			return 0;
		}
		
	}
}
