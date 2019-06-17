package me.foodi.domain;

public class FollowInfoVO {
	
	private String loginId;
	private String userId;
	private String userNick;
	private String userEmail;
	private String userImg;
	private String userLock;
	private String isFollow;
	
	
	
	public FollowInfoVO() {
		super();
	}

	public FollowInfoVO(String loginId, String userId, String userNick, String userEmail, String userImg,
			String userLock, String isFollow) {
		super();
		this.loginId = loginId;
		this.userId = userId;
		this.userNick = userNick;
		this.userEmail = userEmail;
		this.userImg = userImg;
		this.userLock = userLock;
		this.isFollow = isFollow;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public String getIsFollow() {
		return isFollow;
	}
	public void setIsFollow(String isFollow) {
		this.isFollow = isFollow;
	}
	@Override
	public String toString() {
		return "FollowerInfoVO [loginId=" + loginId + ", userId=" + userId + ", userNick=" + userNick + ", userEmail="
				+ userEmail + ", userImg=" + userImg + ", userLock=" + userLock + ", isFollow=" + isFollow + "]";
	}
	
}
