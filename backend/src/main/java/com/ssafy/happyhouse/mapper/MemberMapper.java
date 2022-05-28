package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.MemberDto;

@Mapper
public interface MemberMapper {
//	MemberDto login(String userid) throws Exception;
//	MemberDto userInfo(String userid) throws Exception;
	
	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto userInfo(String userid) throws SQLException;
	
	int registerMember(MemberDto memberDto) throws Exception;
	List<MemberDto> listMember() throws Exception;
	int updateMember(MemberDto memberDto) throws Exception;
	int deleteMember(String userId) throws Exception;
	int memberIdCheck(String userid);
	List<MemberDto> memberSearch(String keyword);
}
