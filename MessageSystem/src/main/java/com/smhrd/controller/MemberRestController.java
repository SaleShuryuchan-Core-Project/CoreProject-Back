package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.db.MemberMapper;
import com.smhrd.model.MemberDTO;
import com.smhrd.model.MyUser;

@RestController
@CrossOrigin
public class MemberRestController {

	// RestController : 비동기 방식을 처리하기 위한 전용 Controller
	// 페이지 이동은 X, 데이터의 결과를 리턴O

	@Autowired
	MemberMapper mapper;

	// React Spring 연결 mapping-----------------------------------------------
	// http://localhost:8083/controller/login
//	@GetMapping("/login")
//	public int login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		System.out.println(id);
//		
//		int result = 0;
//		if(로그인성공 조건) {
//			result=1;
//		}
//		return result;
//	}

	@PostMapping("/login")
	public int login(@RequestBody MyUser user) {
		System.out.println(user);
		return 0;
	}

	// React Spring 연결 mapping-----------------------------------------------

	// 비동기 통신을 위한 요청값 받기
	// controller/checkEmail?checkEmail=?
	@GetMapping("/checkEmail")
	@ResponseBody
	public int checkEmail(@RequestParam("checkEmail") String email) {

		MemberDTO dto = mapper.checkEmail(email);

		if (dto == null) {
			// 보내준 email이 사용 가능할떄 (DB에 저장된 email 없는 경우)
			return 0;
		} else {
			// 보내준 email이 사용 불가능할떄 (DB에 저장된 email 있는 경우)
			return 1;
		}
	}
}
