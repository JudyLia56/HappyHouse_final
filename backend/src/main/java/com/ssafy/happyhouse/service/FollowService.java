package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.FollowDto;
import com.ssafy.happyhouse.dto.FollowResDto;

public interface FollowService {
	FollowResDto follow(FollowDto followDto);
	FollowResDto unfollow(FollowDto followDto);
	
	FollowResDto follower(String to_userid);
	FollowResDto following(String from_userid);
	
	FollowResDto count(String userid);
	
}
