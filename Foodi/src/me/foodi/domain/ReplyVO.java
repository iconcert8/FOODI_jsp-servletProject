package me.foodi.domain;

import java.util.Date;

public class ReplyVO {
	
	private int replyNo;
	private int feedNo;
	private String replyContent;
	private Date replyDate;
	private String userId;
	 
	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", feedNo=" + feedNo + ", replyContent=" + replyContent + ", replyDate="
				+ replyDate + ", userId=" + userId + "]";
	}

	public int getReplyNo() { 
		return replyNo;
	}

	public ReplyVO(int replyNo, int feedNo, String replyContent, Date replyDate, String userId) {
		super();
		this.replyNo = replyNo;
		this.feedNo = feedNo;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.userId = userId;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ReplyVO(){}
	
}
