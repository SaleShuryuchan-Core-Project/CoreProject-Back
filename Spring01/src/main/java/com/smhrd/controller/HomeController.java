package com.smhrd.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// FC가 실행해야하는 Controller 찾도록 도와주는 Annoataion!
@Controller  // POJO라고 할 수 있다!
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// Spring의 Controller는 반드시 요청과 메소드가 연결되어야 한다!
	// => 1요청 정의 ---- 메소드 생성
	
	@RequestMapping("/test")
	public String test() {
		
		return "home";
	}
	
}
