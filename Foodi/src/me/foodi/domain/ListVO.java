package me.foodi.domain;

import java.util.List;

public class ListVO {
	private List<FeedVO> list;
	public ListVO(){}
	public List<FeedVO> getList() {
		return list;
	} 
	public void setList(List<FeedVO> list) {
		this.list = list;
	}   
	public ListVO(List<FeedVO> list) {
		super();
		this.list = list;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + "]";
	}
	
	
}
