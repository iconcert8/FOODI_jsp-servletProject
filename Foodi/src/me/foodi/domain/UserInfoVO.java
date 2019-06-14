package me.foodi.domain;

public class UserInfoVO {
	
	private String userId;
	private String userPass;
	private String userNick;
	private String userEamil;
	private String userImg;
	private String userLock;
	
	public UserInfoVO() {
		// TODO Auto-generated constructor stub
	}

	public UserInfoVO(String userId, String userPass, String userNick, String userEamil, String userImg,
			String userLock) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userNick = userNick;
		this.userEamil = userEamil;
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

	@Override
	public String toString() {
		return "UserInfoVO [userId=" + userId + ", userPass=" + userPass + ", userNick=" + userNick + ", userEamil="
				+ userEamil + ", userImg=" + userImg + ", userLock=" + userLock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userEamil == null) ? 0 : userEamil.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userImg == null) ? 0 : userImg.hashCode());
		result = prime * result + ((userLock == null) ? 0 : userLock.hashCode());
		result = prime * result + ((userNick == null) ? 0 : userNick.hashCode());
		result = prime * result + ((userPass == null) ? 0 : userPass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoVO other = (UserInfoVO) obj;
		if (userEamil == null) {
			if (other.userEamil != null)
				return false;
		} else if (!userEamil.equals(other.userEamil))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userImg == null) {
			if (other.userImg != null)
				return false;
		} else if (!userImg.equals(other.userImg))
			return false;
		if (userLock == null) {
			if (other.userLock != null)
				return false;
		} else if (!userLock.equals(other.userLock))
			return false;
		if (userNick == null) {
			if (other.userNick != null)
				return false;
		} else if (!userNick.equals(other.userNick))
			return false;
		if (userPass == null) {
			if (other.userPass != null)
				return false;
		} else if (!userPass.equals(other.userPass))
			return false;
		return true;
	}

}
