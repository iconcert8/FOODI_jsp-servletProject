package me.foodi.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

import me.foodi.DAO.FeedDAO;
import me.foodi.domain.FeedVO;
import me.foodi.domain.ReplyVO;
import me.foodi.domain.UserAndFeedVO;
import me.foodi.domain.UserInfoVO;
import me.foodi.util.ImageUtil;

public class FeedService {
	private static FeedService service = new FeedService();
	private static FeedDAO dao;

	public static FeedService getInstance() {
		dao = FeedDAO.getInstance();
		return service;
	}

	public int insertFeed(MultipartRequest multi) throws Exception {
		String uploadPath = "C:\\Users\\kosta\\git\\foodi\\Foodi\\WebContent\\upload";
		int size = 100 * 1024 * 1024; // 100mb 설정

		FeedVO feedVO = new FeedVO();
		feedVO.setUserId(multi.getParameter("userId"));
		feedVO.setFeedContent(multi.getParameter("feedContent"));
		feedVO.setFeedLoc(multi.getParameter("feedLoc"));
		feedVO.setFeedLock(multi.getParameter("feedLock"));

		if (multi.getFilesystemName("feedImg") != null) {
			String feedImg = (String) multi.getFilesystemName("feedImg");
			feedVO.setFeedImg(feedImg);

			String head = feedImg.substring(0, feedImg.indexOf("."));
			String extension = feedImg.substring(feedImg.indexOf(".") + 1);
			String imgPath = uploadPath + "\\" + feedImg;
			File src = new File(imgPath);

			String thumbImgPath = uploadPath + "_thumbImg." + "\\" + head + "_thumbImg." + extension;
			File dest = new File(thumbImgPath);

			if (extension.equals("gif") || extension.equals("jpg") || extension.equals("bmp")
					|| extension.equals("jpeg")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}

		if (multi.getFilesystemName("feedImgs") != null) {
			String feedImgs = (String) multi.getFilesystemName("feedImgs");
			feedVO.setFeedImgs(feedImgs);
		}

		return dao.insertFeed(feedVO);
	}

	public List<UserAndFeedVO> listTagFeedService(HttpServletRequest request) throws Exception {
		String tagName = request.getParameter("tagName");
		if (tagName.equals("")) {
			tagName = null;
		}
		return dao.listTagFeed(tagName);
	}

	public List<UserAndFeedVO> newsFeedListService(HttpServletRequest request) throws Exception {
		UserInfoVO userInfoVO = (UserInfoVO) request.getSession().getAttribute("loginUser");

		FeedVO feedVO = new FeedVO();
		feedVO.setUserId(userInfoVO.getUserId());

		return dao.newsFeedList(feedVO);
	}

	public List<ReplyVO> feedReplyGetService(HttpServletRequest request) {
		return dao.feedReplyGet(Integer.parseInt(request.getParameter("feedNo")));
	}

	public int feedReplyInsertService(HttpServletRequest request) {
		UserInfoVO userInfoVO = (UserInfoVO) request.getSession().getAttribute("loginUser");

		ReplyVO replyVO = new ReplyVO();
		replyVO.setUserId(userInfoVO.getUserId());
		replyVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		String replyContent = request.getParameter("replyContent");
		if (replyContent == null || replyContent == "") {
			return -1;
		}
		replyVO.setReplyContent(replyContent);

		return dao.feedReplyInsert(replyVO);
	}

	public UserAndFeedVO detailNewsFeedService(HttpServletRequest request) {
		UserInfoVO userInfoVO = (UserInfoVO) request.getSession().getAttribute("loginUser");
		FeedVO feedVO = new FeedVO();
		feedVO.setUserId(userInfoVO.getUserId());
		feedVO.setFeedNo(Integer.parseInt(request.getParameter("feedNo")));
		return dao.detailNewsFeed(feedVO);
	}

	public FeedVO callFeed(int feedNo) {
		return dao.callFeed(feedNo);
	}

	public int modifyFeed(MultipartRequest multi) throws Exception {
		String uploadPath = "C:\\Users\\kosta\\git\\foodi\\Foodi\\WebContent\\upload";
		
		FeedVO feedVO = new FeedVO();
		feedVO.setFeedNo(Integer.parseInt(multi.getParameter("feedNo")));
		feedVO.setUserId(multi.getParameter("userId"));
		feedVO.setFeedContent(multi.getParameter("feedContent"));
		feedVO.setFeedLoc(multi.getParameter("feedLoc"));
		feedVO.setFeedLock(multi.getParameter("feedLock"));

		if (multi.getFilesystemName("feedImg") != null) {
			String feedImg = (String) multi.getFilesystemName("feedImg");
			feedVO.setFeedImg(feedImg);

			String head = feedImg.substring(0, feedImg.indexOf("."));
			String extension = feedImg.substring(feedImg.indexOf(".") + 1);
			String imgPath = uploadPath + "\\" + feedImg;
			File src = new File(imgPath);

			String thumbImgPath = uploadPath + "_thumbImg." + "\\" + head + "_thumbImg." + extension;
			File dest = new File(thumbImgPath);

			if (extension.equals("gif") || extension.equals("jpg") || extension.equals("bmp")
					|| extension.equals("jpeg")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}else{
			// feedVO.setFeedImg("0");
		}

		if (multi.getFilesystemName("feedImgs") != null) {
			String feedImgs = (String) multi.getFilesystemName("feedImgs");
			feedVO.setFeedImgs(feedImgs);
		}
		
		System.out.println(feedVO.toString());
		return dao.modifyFeed(feedVO);
	}

	public void deleteFeed(HttpServletRequest request) {
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		
		dao.deleteFeed(feedNo);
	}
}