package com.ssafy.happyhouse.dto;

import java.util.List;

public class InterestResDto {
	private int res;
	private InterestDto interestDto;
	private List<HouseInfoDto> interestlist;
	
	
	public InterestResDto() {
		super();
	}
	public InterestResDto(int res, InterestDto interestDto, List<HouseInfoDto> interestlist) {
		super();
		this.res = res;
		this.interestDto = interestDto;
		this.interestlist = interestlist;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public InterestDto getInterestdto() {
		return interestDto;
	}
	public void setInterestDto(InterestDto likedto) {
		this.interestDto = likedto;
	}
	public List<HouseInfoDto> getInterestlist() {
		return interestlist;
	}
	public void setInterestlist(List<HouseInfoDto> interestlist) {
		this.interestlist = interestlist;
	}
	@Override
	public String toString() {
		return "InterestResDto [res=" + res + ", interestDto=" + interestDto + ", interestlist=" + interestlist + "]";
	}
	
}
