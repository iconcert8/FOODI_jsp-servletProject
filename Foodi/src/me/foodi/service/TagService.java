package me.foodi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

import me.foodi.DAO.TagDAO;
import me.foodi.domain.TagVO;

public class TagService {
	private static TagService service = new TagService();
	private static TagDAO dao;

	public static TagService getInstance() {
		dao = TagDAO.getInstance();
		return service;
	}

	public void insertTag(MultipartRequest multi, int feedNo) throws Exception {
		String tagName[] = multi.getParameter("tagName").replaceAll(" ", "").replaceAll(",", "").split("#");
		TagVO tagVO = new TagVO();
		TreeSet<String> tagNameOverlap = new TreeSet<>();

		for (int i = 1; i < tagName.length; i++) {
			tagNameOverlap.add("#" + tagName[i]);
		}

		// 태그 삽입 용
		Iterator<String> iter = tagNameOverlap.iterator();

		while (iter.hasNext()) {
			if (iter.equals("")) {
				break;
			}
			tagVO.setFeedNo(feedNo);
			tagVO.setTagName(iter.next());

			dao.insertTag(tagVO);
		}
	}

	public List<TagVO> callTag(int feedNo) {
		List<TagVO> list = new ArrayList<>();
		list = dao.callTag(feedNo);

		return list;
	}

	public List<TagVO> listHTG(HttpServletRequest request) throws Exception {
		return dao.listHTG();
	}

	public List<String> searchAutoCompleteService(HttpServletRequest request) {
		String keyword = "%" + request.getParameter("search") + "%";
		System.out.println(keyword);
		return dao.searchAutoComplete(keyword);
	}

	public void modifyTag(MultipartRequest multi, int feedNo) {
		String tagName[] = multi.getParameter("tagName").replaceAll(" ", "").replaceAll(",", "").split("#");
		TagVO tagVO = new TagVO();
		TreeSet<String> tagNameOverlap = new TreeSet<>();

		dao.deleteTag(feedNo);

		for (int i = 1; i < tagName.length; i++) {
			tagNameOverlap.add("#" + tagName[i]);
		}

		// 태그 삽입 용
		Iterator<String> iter = tagNameOverlap.iterator();


		while (iter.hasNext()) {
			if (iter.equals("")) {
				break;
			}
			tagVO.setFeedNo(feedNo);
			tagVO.setTagName(iter.next());

			dao.insertTag(tagVO);
		}
	}
}