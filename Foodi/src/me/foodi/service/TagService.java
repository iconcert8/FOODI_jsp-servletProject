package me.foodi.service;

import java.util.Iterator;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import me.foodi.DAO.TagDAO;
import me.foodi.domain.TagVO;

public class TagService {
	private static TagService service = new TagService();
	private static TagDAO dao;

	public static TagService getInstance() {
		dao = TagDAO.getInstance();
		return service;
	}

	public int insertTag(MultipartRequest multi, int feedNo) throws Exception {
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
		return 0;
	}
}