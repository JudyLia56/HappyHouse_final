package com.ssafy.happyhouse.dto;

public class MemberResDto {
	private int result;
	private MemberDto memberDto;
	
	@Override
	public String toString() {
		return "MemberResDto [result=" + result + ", memberDto=" + memberDto + "]";
	}
	public MemberResDto() {
		super();
	}
	public MemberResDto(int result, MemberDto memberDto) {
		super();
		this.result = result;
		this.memberDto = memberDto;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public MemberDto getMemberDto() {
		return memberDto;
	}
	public void setMemberDto(MemberDto memberDto) {
		this.memberDto = memberDto;
	}
	
}
