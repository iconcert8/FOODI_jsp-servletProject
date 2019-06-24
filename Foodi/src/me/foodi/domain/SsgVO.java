package me.foodi.domain;

public class SsgVO {
	private String tagName;
	private String userId;
	public SsgVO(){}
	public SsgVO(String tagName, String userId) {
		super();
		this.tagName = tagName;
		this.userId = userId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "SsgVO [tagName=" + tagName + ", userId=" + userId + "]";
	}
	
	
}
