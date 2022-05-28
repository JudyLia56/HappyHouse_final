package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.FollowDto;
import com.ssafy.happyhouse.dto.FollowResDto;
import com.ssafy.happyhouse.service.FollowService;

@CrossOrigin("*")
@RestController
@RequestMapping("/friend")
public class FollowController {
	
	@Autowired
	FollowService followService;
	
	@PostMapping(value="/")
	public ResponseEntity<FollowResDto> follow(@RequestBody FollowDto followDto){
		FollowResDto followResDto = followService.follow(followDto);
		System.out.println(followDto);
		if(followResDto.getResult()==1) {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/")
	public ResponseEntity<FollowResDto> unfollow(@RequestBody FollowDto followDto){
		FollowResDto followResDto = followService.unfollow(followDto);
		if(followResDto.getResult()==1) {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/follower/{userid}")
	public ResponseEntity<FollowResDto> follower(@PathVariable String userid){
		FollowResDto followResDto = followService.follower(userid);
		if(followResDto.getResult()==1) {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/following/{userid}")
	public ResponseEntity<FollowResDto> following(@PathVariable String userid){
		FollowResDto followResDto = followService.following(userid);
		if(followResDto.getResult()==1) {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/count/{userid}")
	public ResponseEntity<FollowResDto> count(@PathVariable String userid){
		FollowResDto followResDto = followService.count(userid);
		
		if(followResDto.getResult()==1) {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.OK);
		}else {
			return new ResponseEntity<FollowResDto>(followResDto,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
