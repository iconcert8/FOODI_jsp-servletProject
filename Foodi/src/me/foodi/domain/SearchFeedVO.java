package me.foodi.domain;

public class SearchFeedVO {

	private int feedNo;
	private String userId;
	private String feedContent;
	private String feedImg;
	private int feedGoodCnt;
	private String feedLoc;
	private String feedDate;
	private String feedLock;
	private String userImg;
	private String tagName;
	
	
	public SearchFeedVO(){}


	public SearchFeedVO(int feedNo, String userId, String feedContent, String feedImg, int feedGoodCnt, String feedLoc,
			String feedDate, String feedLock, String userImg,String tagName) {
		super();
		this.feedNo = feedNo;
		this.userId = userId;
		this.feedContent = feedContent;
		this.feedImg = feedImg;
		this.feedGoodCnt = feedGoodCnt;
		this.feedLoc = feedLoc;
		this.feedDate = feedDate;
		this.feedLock = feedLock;
		this.userImg = userImg;
		this.tagName = tagName;
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


	public int getFeedGoodCnt() {
		return feedGoodCnt;
	}


	public void setFeedGoodCnt(int feedGoodCnt) {
		this.feedGoodCnt = feedGoodCnt;
	}


	public String getFeedLoc() {
		return feedLoc;
	}


	public void setFeedLoc(String feedLoc) {
		this.feedLoc = feedLoc;
	}


	public String getFeedDate() {
		return feedDate;
	}


	public void setFeedDate(String feedDate) {
		this.feedDate = feedDate;
	}


	public String getFeedLock() {
		return feedLock;
	}


	public void setFeedLock(String feedLock) {
		this.feedLock = feedLock;
	}



	public String getUserImg() {
		return userImg;
	}


	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


	@Override
	public String toString() {
		return "SearchFeedVO [feedNo=" + feedNo + ", userId=" + userId + ", feedContent=" + feedContent + ", feedImg="
				+ feedImg + ", feedGoodCnt=" + feedGoodCnt + ", feedLoc=" + feedLoc + ", feedDate=" + feedDate
				+ ", feedLock=" + feedLock + ", userImg=" + userImg + ", tagName=" + tagName + "]";
	}

	
	
	
	
	
}
