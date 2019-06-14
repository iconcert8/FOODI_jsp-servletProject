package me.foodi.service;

import me.foodi.DAO.FeedDAO;

public class FeedService {
	private static FeedService service = new FeedService();
	private static FeedDAO dao;

	public static FeedService getInstance(){
		dao = FeedDAO.getInstance();
		return service;
	}
	
	
	
}