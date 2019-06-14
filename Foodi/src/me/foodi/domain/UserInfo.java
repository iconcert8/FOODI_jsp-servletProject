package me.foodi.domain;

public class UserInfo {
	private String userId;
	private String userPass;
	private String userNick;
	private String userEmail;
	private String userImg;
	private String userLock;
	
	public UserInfo(){}

	public UserInfo(String userId, String userPass, String userNick, String userEmail, String userImg,
			String userLock) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userNick = userNick;
		this.userEmail = userEmail;
		this.userImg = userImg;
		this.userLock = userLock;
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

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userPass=" + userPass + ", userNick=" + userNick + ", userEmail="
				+ userEmail + ", userImg=" + userImg + ", userLock=" + userLock + "]";
	}
	
	
	
}
