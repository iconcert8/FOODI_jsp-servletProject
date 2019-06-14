package me.foodi.domain;

public class SearchVO {
	
	private int searchNo;
	private String searchKeyword;
	private String searchDate;
	private String userId;
	
	
	
	public SearchVO() {
		super();
	}
	public SearchVO(int searchNo, String searchKeyword, String searchDate, String userId) {
		super();
		this.searchNo = searchNo;
		this.searchKeyword = searchKeyword;
		this.searchDate = searchDate;
		this.userId = userId;
	}
	public int getSearchNo() {
		return searchNo;
	}
	public void setSearchNo(int searchNo) {
		this.searchNo = searchNo;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "SearchVO [searchNo=" + searchNo + ", searchKeyword=" + searchKeyword + ", searchDate=" + searchDate
				+ ", userId=" + userId + "]";
	}
	
	
}
