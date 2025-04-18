package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 6개의 필드를 다 사용할 수 있는 생성자 메소드
@NoArgsConstructor // 필드를 사용하지 않고 사용하는 생성자 메소드
public class BoardDTO {
	
	private int num;
	private String title;
	private String writer;
	private String filename;
	private String content;
	private String b_date;
}
