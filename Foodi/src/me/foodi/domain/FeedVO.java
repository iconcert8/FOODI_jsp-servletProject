package me.foodi.domain;
  
public class FeedVO {
	private int feedNo; //�뵾�뱶 踰덊샇
	private String userId; //�뵾�뱶 �쑀��
	private String feedContent; //�뵾�뱶 �궡�슜
	private String feedImg; //�뵾�뱶�씠誘몄�
	private String feedImgs; //�뵾�뱶 異붽� �씠誘몄�
	private int feedGoodCnt; //醫뗭븘�슂
	private String feedLoc; //�뵾�뱶 �쐞移�
	private String feedDate; //�옉�꽦 �씪�옄
	private String feedUpdate; //�닔�젙 �궇吏�
	private String feedLock; //怨듦컻 �뿬遺�
	private String isGood;
	private String isQook;


	public FeedVO() {
		super();
	}


	
	public FeedVO(int feedNo, String userId, String feedContent, String feedImg, String feedImgs, int feedGoodCnt,
			String feedLoc, String feedDate, String feedUpdate, String feedLock, String isGood, String isQook) {
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
		this.isGood = isGood;
		this.isQook = isQook;
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

	public String getIsGood() {
		return isGood;
	}

	public void setIsGood(String isGood) {
		this.isGood = isGood;
	}

	public String getIsQook() {
		return isQook;
	}

	public void setIsQook(String isQook) {
		this.isQook = isQook;
	}

	@Override
	public String toString() {
		return "FeedVO [feedNo=" + feedNo + ", userId=" + userId + ", feedContent=" + feedContent + ", feedImg="
				+ feedImg + ", feedImgs=" + feedImgs + ", feedGoodCnt=" + feedGoodCnt + ", feedLoc=" + feedLoc
				+ ", feedDate=" + feedDate + ", feedUpdate=" + feedUpdate + ", feedLock=" + feedLock + ", isGood="
				+ isGood + ", isQook=" + isQook + "]";
	}
}
