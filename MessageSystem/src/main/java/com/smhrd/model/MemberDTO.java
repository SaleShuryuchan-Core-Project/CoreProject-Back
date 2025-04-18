package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getter, setter 연결하기 위한 Annotation
@AllArgsConstructor   // 생성자 메소드를 연결하기 위한 Annotation
@NoArgsConstructor    // 기본 생성자 메소드를 연결하기 위한 Annotation 
public class MemberDTO {
	
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	// getter setter 메소드
	
	// 기본 생성자 메소드 => MemberDTO();
	// 생성자 메소드 => MemberDTO(String email, String pw, ...)
	
	// => 해당하는 기능을 직접 생성하지 않고 lombok 라이브러리를 통하여 제작ㅃ

}
