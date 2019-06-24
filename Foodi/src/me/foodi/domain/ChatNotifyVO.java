package me.foodi.domain;

import java.io.Serializable;

public class ChatNotifyVO implements Serializable {
	
	private String resId;
	private String readless;
	private String userImg;
	
	public ChatNotifyVO() {
		// TODO Auto-generated constructor stub
	}

	public ChatNotifyVO(String resId, String readless) {
		super();
		this.resId = resId;
		this.readless = readless;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public String getReadless() {
		return readless;
	}

	public void setReadless(String readless) {
		this.readless = readless;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	@Override
	public String toString() {
		return "ChatNotifyVO [resId=" + resId + ", readless=" + readless + ", userImg=" + userImg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((readless == null) ? 0 : readless.hashCode());
		result = prime * result + ((resId == null) ? 0 : resId.hashCode());
		result = prime * result + ((userImg == null) ? 0 : userImg.hashCode());
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
		ChatNotifyVO other = (ChatNotifyVO) obj;
		if (readless == null) {
			if (other.readless != null)
				return false;
		} else if (!readless.equals(other.readless))
			return false;
		if (resId == null) {
			if (other.resId != null)
				return false;
		} else if (!resId.equals(other.resId))
			return false;
		if (userImg == null) {
			if (other.userImg != null)
				return false;
		} else if (!userImg.equals(other.userImg))
			return false;
		return true;
	}

}
