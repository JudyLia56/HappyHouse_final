package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.FollowDto;
import com.ssafy.happyhouse.dto.FollowResDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.mapper.FollowMapper;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowMapper followMapper;

	@Override
	public FollowResDto follow(FollowDto followDto) {
		FollowResDto followResDto = new FollowResDto();
		if(followMapper.follow(followDto)==1) {
			followResDto.setResult(2);
		}else {
			if (followMapper.follow(followDto) == 1) {
				followResDto.setFollowDto(followDto);
				followResDto.setResult(1);
			} else {
				followResDto.setResult(0);
			}
		}

		return followResDto;
	}

	@Override
	public FollowResDto unfollow(FollowDto followDto) {
		FollowResDto followResDto = new FollowResDto();
		if (followMapper.unfollow(followDto) == 1) {
			followResDto.setFollowDto(followDto);
			followResDto.setResult(1);
		} else {
			followResDto.setResult(0);
		}

		return followResDto;
	}

	@Override
	public FollowResDto follower(String to_userid) {
		FollowResDto followResDto = new FollowResDto();

		List<MemberDto> followerList = followMapper.follower(to_userid);
		followResDto.setFollowList(followerList);
		followResDto.setResult(1);
		return followResDto;
	}

	@Override
	public FollowResDto following(String from_userid) {
		FollowResDto followResDto = new FollowResDto();

		List<MemberDto> followingList = followMapper.following(from_userid);
		followResDto.setFollowList(followingList);
		followResDto.setResult(1);
		return followResDto;
	}

	@Override
	public FollowResDto count(String userid) {
		FollowResDto followResDto = new FollowResDto();
		try {
			followResDto.setFollowerCount(followMapper.followerCount(userid));
			followResDto.setFollowingCount(followMapper.followingCount(userid));
			followResDto.setResult(1);
		}catch(Exception e) {
			e.printStackTrace();
			followResDto.setResult(0);
		}
		return followResDto;
	}

}
