package org.doit.ik.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {

	private Long bno; // selectKey로 저장
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	
	// 페이징 처리 추상메서드 추가
	// 현재 페이지 번호, 한 페이지에 출력할 게시글 수 -> Criteria 클래스 선언
	
}
