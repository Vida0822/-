package org.doit.ik.domain;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewInfo {
	
	// 필드 (링크 걸어야할 애들은 객체로: 코드 사용위함, 그냥 출력만 할 애들은 기본 자료형으로) 
	private DetailCategory detailCategory ; 
	private String pro_long ; 
	private ArrayList<File> imageFiles ; 
	private int paySum;
	private int ach_rate ; 
	private int left_days ; 
	private int pro_sup ; 
	private int pro_price ; 
	private Date pro_start ; 
	private Date pro_end  ; 
	private Date pay_date  ;
	
	
}
