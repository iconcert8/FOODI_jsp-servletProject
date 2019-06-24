package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.NewsFeedDAO;
import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
import me.foodi.domain.UserAndFeedVO;
import me.foodi.domain.UserInfoVO;

public class NewsFeedService {
	private static NewsFeedService service = new NewsFeedService();
	private static NewsFeedDAO dao;

	public static NewsFeedService getInstance() {
		dao = NewsFeedDAO.getInstance();
		return service;
	}
  
	public List<UserAndFeedVO> newsFeedListService(HttpServletRequest request) throws Exception {
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		
		FeedVO feedVO = new FeedVO();
		feedVO.setUserId(userInfoVO.getUserId());
		
		return dao.newsFeedList(feedVO);
	}
	
	public List<ReplyVO> feedReplyGetService(HttpServletRequest request){
		return dao.feedReplyGet(Integer.parseInt(request.getParameter("feedNo")));
	}
	public int feedReplyInsertService(HttpServletRequest request){ 
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		
		ReplyVO replyVO = new ReplyVO();
		replyVO.setUserId(userInfoVO.getUserId());
		replyVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		replyVO.setReplyContent(request.getParameter("replyContent"));
		
		return dao.feedReplyInsert(replyVO);
	}
	
	public UserAndFeedVO detailNewsFeedService(HttpServletRequest request){
		UserInfoVO userInfoVO = (UserInfoVO)request.getSession().getAttribute("loginUser");
		FeedVO feedVO = new FeedVO();
		feedVO.setUserId(userInfoVO.getUserId());
		feedVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.detailNewsFeed(feedVO);
	}
}
