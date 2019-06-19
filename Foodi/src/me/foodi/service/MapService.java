package me.foodi.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import me.foodi.DAO.MapDAO;
import me.foodi.domain.MapVO;

public class MapService {
	private static MapService service = new MapService();
	private static MapDAO dao;
	
	public static MapService getInstance(){
		dao=MapDAO.getInstance();
		return service;
	}
	
	public String[] listMapService(String userId){
		String[] locs = dao.listMap(userId);
		return locs;
	}

	
}
