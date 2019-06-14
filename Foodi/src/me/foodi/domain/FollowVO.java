package me.foodi.domain;

public class FollowVO {

	private String reqUserId;
	private String resUserId;
	private String followDate;
	
	
	public FollowVO() {
		super();
	}


	public String getReqUserId() {
		return reqUserId;
	}


	public void setReqUserId(String reqUserId) {
		this.reqUserId = reqUserId;
	}


	public String getResUserId() {
		return resUserId;
	}


	public void setResUserId(String resUserId) {
		this.resUserId = resUserId;
	}


	public String getFollowDate() {
		return followDate;
	}


	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}


	@Override
	public String toString() {
		return "FollowVO [reqUserId=" + reqUserId + ", resUserId=" + resUserId + ", followDate=" + followDate + "]";
	}
	
	
}
