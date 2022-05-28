package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.InterestDto;
import com.ssafy.happyhouse.dto.InterestFollowDto;
import com.ssafy.happyhouse.dto.InterestResDto;

public interface InterestService {
	InterestResDto InterestList(String userid);
	InterestResDto registInterest(InterestDto interestDto);
	InterestResDto deleteInterest(InterestDto interestDto);
	InterestResDto friendInterest(InterestFollowDto interestFollowDto);
}
