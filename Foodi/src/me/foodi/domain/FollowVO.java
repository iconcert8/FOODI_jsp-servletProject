package me.foodi.domain;

public class FollowVO {
	private String reqId;
	private String resId;
	private String followDate;
	
	
	public FollowVO() {
		super();
	}
	public FollowVO(String reqId, String resId, String followDate) {
		super();
		this.reqId = reqId;
		this.resId = resId;
		this.followDate = followDate;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	@Override
	public String toString() {
		return "FollowVO [reqId=" + reqId + ", resId=" + resId + ", followDate=" + followDate + "]";
	}
	
	
}
