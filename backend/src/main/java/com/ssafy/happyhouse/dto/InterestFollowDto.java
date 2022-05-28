package com.ssafy.happyhouse.dto;

public class InterestFollowDto {

	private int houseinfo_no;
	private String userid;
	private String followid;
	public InterestFollowDto(int houseinfo_no, String userid, String followid) {
		super();
		this.houseinfo_no = houseinfo_no;
		this.userid = userid;
		this.followid = followid;
	}
	public InterestFollowDto() {
		super();
	}
	public int getHouseinfo_no() {
		return houseinfo_no;
	}
	public void setHouseinfo_no(int houseinfo_no) {
		this.houseinfo_no = houseinfo_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFollowid() {
		return followid;
	}
	public void setFollowid(String followid) {
		this.followid = followid;
	}
	@Override
	public String toString() {
		return "InterestFollowDto [houseinfo_no=" + houseinfo_no + ", userid=" + userid + ", followid=" + followid
				+ "]";
	}
	
	
}
