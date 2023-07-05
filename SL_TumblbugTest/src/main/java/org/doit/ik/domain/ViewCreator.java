package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewCreator {
	
	// 필드 
	private Member member ; /* 창작자(회원)이름 */ 
	private File creatorPhoto ;  /* 창작자(회원)사진 */ 
	private int lastSession ; /* 접속시간 */ 
	String pro_ct_intro ;  /* 창작자 소개  */
	
	
	
}
