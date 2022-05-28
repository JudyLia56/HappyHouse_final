package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.InterestDto;
import com.ssafy.happyhouse.dto.InterestFollowDto;
import com.ssafy.happyhouse.dto.InterestResDto;
import com.ssafy.happyhouse.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService{

	@Autowired
	InterestMapper interestMapper;
	
	@Override
	public InterestResDto InterestList(String userid) {
		InterestResDto interestResDto = new InterestResDto();
		try {
			interestResDto.setInterestlist(interestMapper.InterestList(userid));
			interestResDto.setRes(1);
			
		} catch (Exception e) {
			e.printStackTrace();
			interestResDto.setRes(0);
		}
		
		return interestResDto;
	}

	@Override
	public InterestResDto registInterest(InterestDto interestDto) {
		InterestResDto interestResDto = new InterestResDto();
		if(interestMapper.registInterest(interestDto)==1) {
			interestResDto.setInterestDto(interestDto);
			interestResDto.setRes(1);
		}else {
			interestResDto.setRes(0);
		}
		return interestResDto;
	}

	@Override
	public InterestResDto deleteInterest(InterestDto interestDto) {
		InterestResDto interestResDto = new InterestResDto();
		if(interestMapper.deleteInterest(interestDto)==1) {
			interestResDto.setInterestDto(interestDto);
			interestResDto.setRes(1);
		}else {
			interestResDto.setRes(0);
		}
		return interestResDto;
	}

	@Override
	public InterestResDto friendInterest(InterestFollowDto interestFollowDto) {
		InterestResDto interestResDto = new InterestResDto();
		try {
			interestResDto.setInterestlist(interestMapper.InterestList(interestFollowDto.getFollowid()));
			interestResDto.setRes(1);
			
		} catch (Exception e) {
			e.printStackTrace();
			interestResDto.setRes(0);
		}
		
		return interestResDto;
	}

}
