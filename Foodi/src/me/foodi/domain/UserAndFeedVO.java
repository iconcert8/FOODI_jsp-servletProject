package me.foodi.domain;

public class UserAndFeedVO {
	//user
	private String userId;
	private String userPass;
	private String userNick;
	private String userEamil;
	private String userImg;
	private String userLock;
	//feed
	private int feedNo; 
	private String feedContent; 
	private String feedImg;
	private String feedImgs;
	private int feedGoodCnt; 
	private String feedLoc; 
	private String feedDate;
	private String feedUpdate; 
	private String feedLock; 
	private String isGood;
	private String isQook;
	
	public UserAndFeedVO() {
		super();
	}

	public UserAndFeedVO(String userId, String userPass, String userNick, String userEamil, String userImg,
			String userLock, int feedNo, String feedContent, String feedImg, String feedImgs, int feedGoodCnt,
			String feedLoc, String feedDate, String feedUpdate, String feedLock, String isGood, String isQook) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userNick = userNick;
		this.userEamil = userEamil;
		this.userImg = userImg;
		this.userLock = userLock;
		this.feedNo = feedNo;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserEamil() {
		return userEamil;
	}

	public void setUserEamil(String userEamil) {
		this.userEamil = userEamil;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserLock() {
		return userLock;
	}

	public void setUserLock(String userLock) {
		this.userLock = userLock;
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
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
		return "UserAndFeedVO [userId=" + userId + ", userPass=" + userPass + ", userNick=" + userNick + ", userEamil="
				+ userEamil + ", userImg=" + userImg + ", userLock=" + userLock + ", feedNo=" + feedNo
				+ ", feedContent=" + feedContent + ", feedImg=" + feedImg + ", feedImgs=" + feedImgs + ", feedGoodCnt="
				+ feedGoodCnt + ", feedLoc=" + feedLoc + ", feedDate=" + feedDate + ", feedUpdate=" + feedUpdate
				+ ", feedLock=" + feedLock + ", isGood=" + isGood + ", isQook=" + isQook + "]";
	}

	
	
}
