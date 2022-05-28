package com.ssafy.happyhouse.dto;

public class InterestDto {
	private int interestid;
	private int houseinfo_no;
	private String userid;
	
	
	public InterestDto(int interestid, int housedeal_no, String userid) {
		super();
		this.interestid = interestid;
		this.houseinfo_no = housedeal_no;
		this.userid = userid;
	}
	
	public InterestDto() {
		super();
	}
	public int getInterestid() {
		return interestid;
	}
	public void setInterestid(int interestid) {
		this.interestid = interestid;
	}
	public int getHouseinfo_no() {
		return houseinfo_no;
	}
	public void setHouseinfo_no(int housedeal_no) {
		this.houseinfo_no = housedeal_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "InterestDto [interestid=" + interestid + ", houseinfo_no=" + houseinfo_no + ", userid=" + userid + "]";
	}
	
	
}
