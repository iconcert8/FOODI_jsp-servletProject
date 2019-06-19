package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.foodi.DAO.NewsFeedDAO;
import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
import me.foodi.domain.UserInfoVO;

public class NewsFeedService {
	private static NewsFeedService service = new NewsFeedService();
	private static NewsFeedDAO dao;

	public static NewsFeedService getInstance() {
		dao = NewsFeedDAO.getInstance();
		return service;
	}
  
	public List<FeedVO> newsFeedListService(HttpServletRequest request) throws Exception {
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		
		FeedVO feedVO = new FeedVO();
		feedVO.setUserId(userInfoVO.getUserId());
		
		return dao.newsFeedList(feedVO);
	}
	
	public List<ReplyVO> newsfeedReply(HttpServletRequest request){
		return dao.newsfeedReply(Integer.parseInt(request.getParameter("feedNo")));
	}
	public int insertNewsfeedReplyService(HttpServletRequest request){ 
		ReplyVO replyVO = new ReplyVO();
		
		replyVO.setReplyNo(Integer.parseInt(request.getParameter("replyNo")));
		replyVO.setFeedNo(Integer.parseInt(request.getParameter("replyno")));
		replyVO.setReplyContent(request.getParameter("replyContent"));
		replyVO.setUserId(request.getParameter("userId"));
		
		return dao.insertNewsfeedReply(replyVO);
	}
}
