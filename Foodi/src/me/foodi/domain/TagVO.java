package me.foodi.domain;

public class TagVO {
	private int feedNo; //피드번호
	private String tagName; // 태그이름
	
	public TagVO() {
		super();
	}

	public TagVO(int feedNo, String tagName) {
		super();
		this.feedNo = feedNo;
		this.tagName = tagName;
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "TagVO [feedNo=" + feedNo + ", tagName=" + tagName + "]";
	}
	
	
}
