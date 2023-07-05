package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemSet {
	
	// 필드 
	private String item_set_cd ; 
	private int item_cnt ; 
	private String gift_cd ; 
	private String item_cd ;
	
	private String item_name ; // 아이템 테이블에 있는 칼럼 (조인해서 얻어올 예정) 
	

		
} // Item 
