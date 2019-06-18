package me.foodi.domain;

public class FeedVO {
	private int feedNo; //피드 번호
	private String userId; //피드 유저
	private String feedContent; //피드 내용
	private String feedImg; //피드이미지
	private String feedImgs; //피드 추가 이미지
	private int feedGoodCnt; //좋아요
	private String feedLoc; //피드 위치
	private String feedDate; //작성 일자
	private String feedUpdate; //수정 날짜
	private String feedLock; //공개 여부


	public FeedVO() {
		super();
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

	public String getFeedUpdate() {
		return feedUpdate;
	}

	public void setFeedUpdate(String feedUpdate) {
		this.feedUpdate = feedUpdate;
	}

	public String getFeedLock() {
		return feedLock;
	}

	public void setFeedLock(String feedLock) {
		this.feedLock = feedLock;
	}




	public FeedVO(int feedNo, String userId, String feedContent, String feedImg, String feedImgs,
			int feedGoodCnt, String feedLoc, String feedDate, String feedUpdate, String feedLock) {
		super();
		this.feedNo = feedNo;
		this.userId = userId;
		this.feedContent = feedContent;
		this.feedImg = feedImg;
		this.feedImgs = feedImgs;
		this.feedGoodCnt = feedGoodCnt;
		this.feedLoc = feedLoc;
		this.feedDate = feedDate;
		this.feedUpdate = feedUpdate;
		this.feedLock = feedLock;
	}
 
	@Override
	public String toString() {
		return "FeedVO [feedNo=" + feedNo + ", userId=" + userId + ", feedContent=" + feedContent
				+ ", feedImg=" + feedImg + ", feedImgs=" + feedImgs + ", feedGoodCnt=" + feedGoodCnt + ", feedLoc="
				+ feedLoc + ", feedDate=" + feedDate + ", feedUpdate=" + feedUpdate + ", feedLock=" + feedLock + "]";
	}

}
