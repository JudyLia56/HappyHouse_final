package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.InterestDto;

@Mapper
public interface InterestMapper {
	List<HouseInfoDto> InterestList(String userid);
	int registInterest(InterestDto likeDto);
	int deleteInterest(InterestDto likeDto);
}
