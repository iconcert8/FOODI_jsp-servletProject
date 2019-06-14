package me.foodi.service;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.NewsFeedDAO;
import me.foodi.domain.Feed;

public class NewsFeedService {
	private static NewsFeedService service = new NewsFeedService();
	private static NewsFeedDAO dao;
	
	public static NewsFeedService getInstance(){
		dao = NewsFeedDAO.getInstance();
		return service;
	}
	
	public detailNewsFeedService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		
		Feed feed = new Feed();
		feed.setUserId(request.getParameter("userId"));
		feed.setFeedContent(request.getParameter("content"));
		feed.setFeedImg(request.getParameter("img"));
		feed.setFeedImgs(request.getParameter("imgs"));
		feed.setFeedLoc(request.getParameter("loc"));
		feed.setFeedDate(request.getParameter("date"));
		feed.setFeedUpdate(request.getParameter("upate"));
		feed.setFeedLoc(request.getParameter("lock"));
		
		return dao.
	} 
		
}

	
