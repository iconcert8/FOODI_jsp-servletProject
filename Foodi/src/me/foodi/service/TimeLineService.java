package me.foodi.service;

import java.util.List;

import me.foodi.DAO.TimeLineDAO;
import me.foodi.domain.SearchFeedVO;

public class TimeLineService {
	private static TimeLineService service = new TimeLineService();
	private static TimeLineDAO dao;
	
	public static TimeLineService getInstance(){
		dao=TimeLineDAO.getInstance();
		return service;
	}
	

	
	public List<SearchFeedVO> searchFeedService(String userId){
		List<SearchFeedVO> list = dao.searchFeed(userId);

		return list;
	}
	
	public String[] searchQookService(String userId){
		String[] list = dao.searchQook(userId);
		return list;
	}

}
