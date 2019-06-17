package me.foodi.domain;

public class MapVO {
	private String locname;
	private String location;
	public MapVO(){}
	public MapVO(String locname, String location) {
		super();
		this.locname = locname;
		this.location = location;
	}
	public String getLocname() {
		return locname;
	}
	public void setLocname(String locname) {
		this.locname = locname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "MapVO [locname=" + locname + ", location=" + location + "]";
	}
	
	
	
}
