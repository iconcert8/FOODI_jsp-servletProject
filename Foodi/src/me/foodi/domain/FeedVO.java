package me.foodi.domain;

import java.sql.Date;

public class FeedVO {
	private int feedNo;
	private String userId;
	private String feedContent;
	private String feedImg;
	private String feedImgs;
	private String feedGoodCnt;
	private String feedLoc;
	private Date feedDate;
	
	public FeedVO(){}
	 
	
	public FeedVO(int feedNo, String userId, String feedContent, String feedImg, String feedImgs, String feedGoodCnt,
			String feedLoc, Date feedDate, Date feedLock) {
		super();
		this.feedNo = feedNo;
		this.userId = userId;
		this.feedContent = feedContent;
		this.feedImg = feedImg;
		this.feedImgs = feedImgs;
		this.feedGoodCnt = feedGoodCnt;
		this.feedLoc = feedLoc;
		this.feedDate = feedDate;
		this.feedLock = feedLock;
	}

	@Override
	public String toString() {
		return "FeedVO [feedNo=" + feedNo + ", userId=" + userId + ", feedContent=" + feedContent + ", feedImg="
				+ feedImg + ", feedImgs=" + feedImgs + ", feedGoodCnt=" + feedGoodCnt + ", feedLoc=" + feedLoc
				+ ", feedDate=" + feedDate + ", feedLock=" + feedLock + "]";
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public String getFeedImg() {
		return feedImg;
	}

	public void setFeedImg(String feedImg) {
		this.feedImg = feedImg;
	}

	public String getFeedImgs() {
		return feedImgs;
	}

	public void setFeedImgs(String feedImgs) {
		this.feedImgs = feedImgs;
	}

	public String getFeedGoodCnt() {
		return feedGoodCnt;
	}

	public void setFeedGoodCnt(String feedGoodCnt) {
		this.feedGoodCnt = feedGoodCnt;
	}

	public String getFeedLoc() {
		return feedLoc;
	}

	public void setFeedLoc(String feedLoc) {
		this.feedLoc = feedLoc;
	}

	public Date getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(Date feedDate) {
		this.feedDate = feedDate;
	}

	public Date getFeedLock() {
		return feedLock;
	}

	public void setFeedLock(Date feedLock) {
		this.feedLock = feedLock;
	}

	private Date feedLock;
 
}
