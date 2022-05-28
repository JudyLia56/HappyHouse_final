package com.ssafy.happyhouse.controller;

import javax.servlet.http.HttpSession;

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

import com.ssafy.happyhouse.dto.InterestDto;
import com.ssafy.happyhouse.dto.InterestFollowDto;
import com.ssafy.happyhouse.dto.InterestResDto;
import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.InterestService;

@CrossOrigin("*")
@RestController
@RequestMapping("/interest")
public class InterestController {
	@Autowired
	InterestService interestService;
	
	@GetMapping("/user")
	public ResponseEntity<InterestResDto> InterestList(String userid){
		InterestResDto interestResDto = interestService.InterestList(userid);
		if(interestResDto.getRes()==1) {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/regist")
	public ResponseEntity<InterestResDto> registInterest(@RequestBody InterestDto interestDto, String userid){
		interestDto.setUserid(userid);
		InterestResDto interestResDto = interestService.registInterest(interestDto);
		if(interestResDto.getRes()==1) {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{houseinfo_no}")
	public ResponseEntity<InterestResDto> deleteInterest(@PathVariable int houseinfo_no, String userid){
		InterestDto interestDto = new InterestDto();
		interestDto.setUserid(userid);
		interestDto.setHouseinfo_no(houseinfo_no);
		InterestResDto interestResDto = interestService.deleteInterest(interestDto);
		if(interestResDto.getRes()==1) {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/friend/{followid}")
	public ResponseEntity<InterestResDto> friendInterest(@PathVariable String followid, String userid){
		InterestFollowDto interestFollowDto = new InterestFollowDto();
		interestFollowDto.setFollowid(followid);
		interestFollowDto.setUserid(userid);
		InterestResDto interestResDto = interestService.friendInterest(interestFollowDto);
		
		if(interestResDto.getRes()==1) {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<InterestResDto>(interestResDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
