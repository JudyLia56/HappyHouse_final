package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.dto.MemberResDto;

public interface MemberService {
//	MemberResDto login(MemberDto memberDto) throws Exception;
//	MemberDto userInfo(String userid) throws Exception;
	
	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
	boolean registerMember(MemberDto memberDto) throws Exception;
	List<MemberDto> listMember() throws Exception;
	boolean updateMember(MemberDto memberDto) throws Exception;
	boolean deleteMember(String userId) throws Exception;
	MemberResDto memberIdCheck(String userid)throws Exception;
	List<MemberDto> memberSearch(String keyword);
}
