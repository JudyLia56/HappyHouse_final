package com.ssafy.happyhouse.dto;

import java.util.List;

public class FollowResDto {
	private int result;
	private FollowDto followDto;
	private List<MemberDto> followList;
	private int followerCount;
	private int followingCount;
	public FollowResDto(int result, FollowDto followDto, List<MemberDto> followList, int followerCount,
			int followingCount) {
		super();
		this.result = result;
		this.followDto = followDto;
		this.followList = followList;
		this.followerCount = followerCount;
		this.followingCount = followingCount;
	}
	public FollowResDto() {
		super();
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public FollowDto getFollowDto() {
		return followDto;
	}
	public void setFollowDto(FollowDto followDto) {
		this.followDto = followDto;
	}
	public List<MemberDto> getFollowList() {
		return followList;
	}
	public void setFollowList(List<MemberDto> followList) {
		this.followList = followList;
	}
	public int getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}
	public int getFollowingCount() {
		return followingCount;
	}
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}
	@Override
	public String toString() {
		return "FollowResDto [result=" + result + ", followDto=" + followDto + ", followList=" + followList
				+ ", followerCount=" + followerCount + ", followingCount=" + followingCount + "]";
	}
	
	
}
