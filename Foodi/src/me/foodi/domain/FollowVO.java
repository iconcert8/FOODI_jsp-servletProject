package me.foodi.domain;

public class FollowVO {

	private String requestUserId;
	private String responseUserId;
	private String followDate;
	
	
	public FollowVO() {
		super();
	}
	
	public FollowVO(String requestUserId, String responseUserId, String followDate) {
		super();
		this.requestUserId = requestUserId;
		this.responseUserId = responseUserId;
		this.followDate = followDate;
	}
	
	public String getRequestUserId() {
		return requestUserId;
	}
	public void setRequestUserId(String requestUserId) {
		this.requestUserId = requestUserId;
	}
	public String getResponseUserId() {
		return responseUserId;
	}
	public void setResponseUserId(String responseUserId) {
		this.responseUserId = responseUserId;
	}
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	
	@Override
	public String toString() {
		return "FollowVO [requestUserId=" + requestUserId + ", responseUserId=" + responseUserId + ", followDate="
				+ followDate + "]";
	}
	
	
}
