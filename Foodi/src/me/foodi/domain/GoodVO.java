package me.foodi.domain;

public class GoodVO {
	private String userId;
	private int feedNo;
	private String goodDate;
	
	public GoodVO() {
		super();
	}

	public GoodVO(String userId, int feedNo, String goodDate) {
		super();
		this.userId = userId;
		this.feedNo = feedNo;
		this.goodDate = goodDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}

	public String getGoodDate() {
		return goodDate;
	}

	public void setGoodDate(String goodDate) {
		this.goodDate = goodDate;
	}

	@Override
	public String toString() {
		return "GoodVO [userId=" + userId + ", feedNo=" + feedNo + ", goodDate=" + goodDate + "]";
	}
	
	
	
}
