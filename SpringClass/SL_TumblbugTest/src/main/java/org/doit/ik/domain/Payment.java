package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	
	// 필드 
	private String pay_cd;  // 요금제코드
	private String pay_name;  // 요금제이름
	private String pay_fee;  //  수수료
	
	
}
