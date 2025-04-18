package com.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smhrd.db.MemberMapper;
import com.smhrd.model.MemberDTO;

@Controller // POJO : 순수자바로만 만들어지는 파일
public class MemberController {
	
	// 자동적으로 스스로 의존 객체를 찾아주는 Annotation
	@Autowired
	MemberMapper mapper;
	
	// Controller가 작업해야하는 사항들을 정의!
	
	@RequestMapping("/")
	public String main() {
		
		return "Main";
	}
	
	@GetMapping("/goMain")
	   public String goMain() {
	      return "Main";
	   }
	
	// 새로운 요청을 연결! => 회원가입
	// 요청의 방식 => Get, Post
	@PostMapping("/join")  // 내가 실행하고자 하는 요청
	public String join(Model model, MemberDTO dto) {
		
		// 회원가입을 위한 정보를 DB로 넘겨주는 기능 호출!
		mapper.join(dto);
		
		// 회원가입에 대한 정보를 가지고 JoinSuccess.jsp 이동!
		// Model 객체를 사용하여 해당 정보 전달!
		model.addAttribute("email", dto.getEmail());
		
		return "JoinSuccess"; // 수행사항이 씉나면 보여질 Web화면
	}
	
	// @Annotation 사용해서 Post 방식의 요청을 받는 구조 만들기
	// 요청이름 : "/login"
	// 기본 메소드 구조 생성 => 메소드의 이름 login()
	// 리턴 타입 => String 타입 "Main"으로 지정
	@PostMapping("/login")  // 내가 실행하고자 하는 요청
	public String login(MemberDTO dto, HttpSession session) {
		
		// DB에 로그인을 위한 email, pw 전달
		// ==> 해당 내용이 테이블에 존재하고 있는지 확인필요
		MemberDTO info = mapper.login(dto);
		
		// Main 페이지로 이동시 로그인에 대한 정보를 공유할 수 있도록 제공!
		// => session 영역에 로그인 정보 저장!
		session.setAttribute("info", info);
		
		return "Main"; // 수행사항이 씉나면 보여질 Web화면
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 로그아웃 진행시 가지고 있는 회원의 정보를 모두 다 제거 => session 영역
		session.removeAttribute("info");
		//session.invalidate();
		
		return "Main";
	}
	
	// 정보수정 페이지로 이동을 위한 요청-응답
	@GetMapping("/update")
	public String update() {
		
		return "UpdateMember";
	}
	
	// 실제 대이터를 수정하기 위한 요청-응답
	@PostMapping("/updateMember")
	public String updateMember(MemberDTO dto, HttpSession session) {
		
		mapper.updateMember(dto);
		session.setAttribute("info", dto);
		
		return "Main";
	}
	
	@GetMapping("/showMember")
	public String showMember(Model model) {
		// DB에 저장된 모든 회원의 정보를 가지고 ShowMember 페이지로 이동
		ArrayList<MemberDTO> list = mapper.showMember();
		
		// 페이지 이동시 model에 전체 회원 정보를 담아서 넘겨주기!
		model.addAttribute("list", list);
		
		return "ShowMember";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("email") String email) {
		// @RequestParam은 QuertString 문법으로 요청되는 데이터를 꺼내오는 Annotation
		// 꺼내온 이후에는 보관할 수 있는 변수를 함께 지정해야 한다!
		
		mapper.delete(email);
		
		return "redirect:showMember";
	}
	
//	// 비동기 통신을 위한 요청값 받기
//	// controller/checkEmail?checkEmail=?
//	@GetMapping("/checkEmail")
//	public @ResponseBody int checkEmail(@RequestParam("checkEmail") String email) {
//		
//		MemberDTO dto = mapper.checkEmail(email);
//		
//		if(dto == null) {
//			// 보내준 email이 사용 가능할떄 (DB에 저장된 email 없는 경우)
//			return 0;
//		}else {
//			// 보내준 email이 사용 불가능할떄 (DB에 저장된 email 있는 경우)
//			return 1;
//		}
//	}
	
}
