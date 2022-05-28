package com.ssafy.happyhouse.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.dto.MemberResDto;
import com.ssafy.happyhouse.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private MemberMapper memberMapper;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return memberMapper.login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return memberMapper.userInfo(userid);
	}
	
//	@Override
//	public MemberResDto login(MemberDto memberDto) throws Exception{
//		MemberResDto memberResDto = new MemberResDto();
//		try {
//			MemberDto memberdto = memberMapper.login(memberDto.getUserid());
//			
//			if (memberdto != null && memberdto.getUserpwd().equals(memberDto.getUserpwd())) {
//				memberResDto.setMemberDto(memberdto);
//				memberResDto.setResult(SUCCESS);
//			} else {
//				memberResDto.setResult(FAIL);
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//			memberResDto.setResult(FAIL);
//		}
//		return memberResDto;
//	}
	
	@Override
	public MemberResDto memberIdCheck(String userid) throws Exception{
		MemberResDto memberResDto = new MemberResDto();
		try {
			if (memberMapper.memberIdCheck(userid) == 1) {
				memberResDto.setResult(2);
			} else {
				memberResDto.setResult(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
			memberResDto.setResult(FAIL);
		}
		return memberResDto;
	}
	
//	@Override
//	public MemberDto userInfo(String userid) throws Exception {
//		return memberMapper.userInfo(userid);
//	}

	@Override
	public boolean registerMember(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).registerMember(memberDto)==1;
	}
	
	@Override
	public List<MemberDto> listMember() throws Exception {
		return sqlSession.getMapper(MemberMapper.class).listMember();
	}

	@Override
	public boolean updateMember(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).updateMember(memberDto) == 1;
	}

	@Override
	public boolean deleteMember(String userId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).deleteMember(userId) == 1;
	}

	@Override
	public List<MemberDto> memberSearch(String keyword) {
		
		return sqlSession.getMapper(MemberMapper.class).memberSearch(keyword);
	}

}
