package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.MapDAO;
import me.foodi.domain.FeedVO;
import me.foodi.domain.UserInfoVO;

public class MapService {
	private static MapService service = new MapService();
	private static MapDAO dao;
	
	public static MapService getInstance(){
		dao=MapDAO.getInstance();
		return service;
	}
	
	public List<FeedVO> listMapService(HttpServletRequest request)throws Exception{
		List<FeedVO> list = dao.listMap(request.getParameter("userId"));
		return list;
	}

	
}
