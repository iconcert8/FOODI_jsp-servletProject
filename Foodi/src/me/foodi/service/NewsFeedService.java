package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.foodi.DAO.NewsFeedDAO;
import me.foodi.domain.FeedVO;

public class NewsFeedService {
	private static NewsFeedService service = new NewsFeedService();
	private static NewsFeedDAO dao;

	public static NewsFeedService getInstance() {
		dao = NewsFeedDAO.getInstance();
		return service;
	}

	public List<FeedVO> newsFeedListService() {
		return dao.newsFeedList();
	}
}
