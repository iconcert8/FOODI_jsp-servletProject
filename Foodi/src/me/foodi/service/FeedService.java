package me.foodi.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import me.foodi.DAO.FeedDAO;
import me.foodi.domain.FeedVO;
import me.foodi.util.ImageUtil;

public class FeedService {
	private static FeedService service = new FeedService();
	private static FeedDAO dao;

	public static FeedService getInstance() {
		dao = FeedDAO.getInstance();
		return service;
	}

	public int insertFeed(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String uploadPath = "C:\\Users\\kosta\\git\\foodi\\Foodi\\WebContent\\upload";
		int size = 100 * 1024 * 1024; // 100mb 설정
		
		System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8",
				new DefaultFileRenamePolicy());

		FeedVO feedVO = new FeedVO();
		feedVO.setUserId(multi.getParameter("userId"));
		
		System.out.println(multi.getParameter("userId"));
		
		feedVO.setFeedContent(multi.getParameter("feedContent"));
		feedVO.setFeedLoc(multi.getParameter("feedLoc"));
		// feedVO.setFeedLock(multi.getParameter("feedLock"));

		if (multi.getFilesystemName("feedImg") != null) {
			String feedImg = (String) multi.getFilesystemName("feedImg");
			feedVO.setFeedImg(feedImg);

			String head = feedImg.substring(0, feedImg.indexOf(".")); // 파일 이름
			String extension = feedImg.substring(feedImg.indexOf(".") + 1); // 파일
																			// 확장자
			String imgPath = uploadPath + "\\" + feedImg;
			File src = new File(imgPath);

			String thumbImgPath = uploadPath + "_thumbImg." + "\\" + head + "_thumbImg." + extension;
			File dest = new File(thumbImgPath);

			if (extension.equals("gif") || extension.equals("jpg") || extension.equals("bmp")
					|| extension.equals("jpeg")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
			System.out.println(feedImg);
		}
		/*
		 * if (multi.getFilesystemName("feedImgs") != null) { String feedImgs =
		 * (String) multi.getFilesystemName("feedImgs");
		 * feedVO.setFeedImgs(feedImgs); System.out.println(feedImgs); }
		 */

		System.out.println(feedVO);

		return dao.insertFeed(feedVO);
	}

}