package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.FollowDto;
import com.ssafy.happyhouse.dto.MemberDto;

@Mapper
public interface FollowMapper {
	int follow(FollowDto followDto);
	int check(FollowDto followDto);
	int unfollow(FollowDto followDto);
	
	List<MemberDto> follower(String to_userid);
	List<MemberDto> following(String from_userid);
	
	int followerCount(String userid);
	int followingCount(String userid);
}
