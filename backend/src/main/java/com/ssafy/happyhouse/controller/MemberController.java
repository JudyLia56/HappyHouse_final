package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.dto.MemberResDto;
import com.ssafy.happyhouse.service.JwtServiceImpl;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class MemberController {
	
	
	@Autowired
	private JwtServiceImpl jwtService;
	@Autowired
	private MemberService memberService;
	
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	
	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getUserid(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(request.getHeader("access-token"));
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				MemberDto memberDto = memberService.userInfo(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	
//	@ApiOperation(value = "로그인", notes = "로그인 결과 메세지를 반환한다.", response = Map.class)
//	@PostMapping("/login")
//	public ResponseEntity<MemberResDto> login(@RequestBody MemberDto memberDto, HttpSession session, HttpServletRequest request) throws Exception {
//		MemberResDto memberResDto = memberService.login(memberDto);
//		System.out.println("result  " + memberResDto);
//		if (memberResDto.getResult() == 1) {
//			session.setAttribute("loginUser", memberResDto.getMemberDto());
//			return new ResponseEntity<MemberResDto>(memberResDto, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<MemberResDto>(memberResDto, HttpStatus.NOT_FOUND);
//		}
//	}
	
	@ApiOperation(value = "로그아웃", notes = "로그아웃 결과 메세지를 반환한다.", response = Map.class)
	@GetMapping(value = "/logout")
	public ResponseEntity<MemberResDto> logout(HttpSession session) {
		session.invalidate();
		MemberResDto memberResDto = new MemberResDto();
		memberResDto.setResult(1);
		return new ResponseEntity<MemberResDto>(memberResDto, HttpStatus.OK);
	}
	
//	@ApiOperation(value = "회원정보", notes = "회원 정보를 반환한다.", response = Map.class)
//	@GetMapping("/info/{userid}")
//	public ResponseEntity<MemberDto> getInfo(
//			@PathVariable("userid") @ApiParam(value = "회원의 아이디.", required = true) String userid,
//			HttpServletRequest request) throws Exception {
//		logger.debug("listMember - 호출");
//		return new ResponseEntity<MemberDto>(memberService.userInfo(userid), HttpStatus.OK);
//	}
	
	@ApiOperation(value = "모든 회원의 정보를 반환한다.", response = List.class)
	@GetMapping("/list")
	public ResponseEntity<List<MemberDto>> retrieveMember() throws Exception {
		logger.debug("listMember - 호출");
		return new ResponseEntity<List<MemberDto>>(memberService.listMember(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 회원 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/register")
	public ResponseEntity<String> registerMember(@RequestBody MemberDto memberDto) throws Exception {
		logger.debug("registerMember - 호출" + memberDto);
		if (memberService.registerMember(memberDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원번호에 해당하는 회원의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/update")
	public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto) throws Exception {
		logger.debug("updateMember - 호출");
		logger.debug("" + memberDto);

		if (memberService.updateMember(memberDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원번호에 해당하는 회원의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteMember(@RequestBody MemberDto memberDto) throws Exception {
		logger.debug("deleteMember - 호출");
		String userid = memberDto.getUserid();
		if (memberService.deleteMember(userid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "아이디 중복체크를 한다.", response = String.class)
	@GetMapping(value = "/idcheck/{userid}")
	public ResponseEntity<MemberResDto> userIdCheck(@PathVariable String userid) throws Exception {
		MemberResDto memberResDto = memberService.memberIdCheck(userid);
		
		System.out.println("userIdCheck " + memberResDto);
		//3일경우 중복아님, 2일경우 중복
		if (memberResDto.getResult() == 3 || memberResDto.getResult() == 2) {
			return new ResponseEntity<MemberResDto>(memberResDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<MemberResDto>(memberResDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "모든 회원의 정보를 반환한다.", response = List.class)
	@GetMapping("/list/{keyword}")
	public ResponseEntity<List<MemberDto>> memberSearch(@PathVariable String keyword) throws Exception {
		logger.debug("memberSearch - 호출");
		return new ResponseEntity<List<MemberDto>>(memberService.memberSearch(keyword), HttpStatus.OK);
	}
}