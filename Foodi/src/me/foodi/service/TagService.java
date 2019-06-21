package me.foodi.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.foodi.DAO.TagDAO;
import me.foodi.domain.TagVO;

public class TagService {
	private static TagService service = new TagService();
	private static TagDAO dao;

	public static TagService getInstance() {
		dao = TagDAO.getInstance();
		return service;
	}

	public int insertTag(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int feedNo = Integer.parseInt(request.getParameter(""));

		String tagName[] = request.getParameter("tagName").replaceAll(" ", "").split("#");

		return dao.insertTag(feedNo, tagName);
	}
	
	public List<TagVO> listHTG(HttpServletRequest request) throws Exception{
		return dao.listHTG();
	}
}