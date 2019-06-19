package me.foodi.domain;

public class QookVO {
	private String userId;
	private int feedNo;
	private String qookDate;
	
	public QookVO() {
		super();
	}

	public QookVO(String userId, int feedNo, String qookDate) {
		super();
		this.userId = userId;
		this.feedNo = feedNo;
		this.qookDate = qookDate;
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

	public String getQookDate() {
		return qookDate;
	}

	public void setQookDate(String qookDate) {
		this.qookDate = qookDate;
	}

	@Override
	public String toString() {
		return "QookVO [userId=" + userId + ", feedNo=" + feedNo + ", qookDate=" + qookDate + "]";
	}
	
	
}
