package com.ssafy.happyhouse.dto;

public class FollowDto {
	private String from_userid;
	private String to_userid;
	
	public FollowDto(String from_userid, String to_userid) {
		super();
		this.from_userid = from_userid;
		this.to_userid = to_userid;
	}
	public FollowDto() {
		super();
	}
	public String getFrom_userid() {
		return from_userid;
	}
	public void setFrom_userid(String from_userid) {
		this.from_userid = from_userid;
	}
	public String getTo_userid() {
		return to_userid;
	}
	public void setTo_userid(String to_userid) {
		this.to_userid = to_userid;
	}
	@Override
	public String toString() {
		return "FollowDto [from_userid=" + from_userid + ", to_userid=" + to_userid + "]";
	}
	
	
}
