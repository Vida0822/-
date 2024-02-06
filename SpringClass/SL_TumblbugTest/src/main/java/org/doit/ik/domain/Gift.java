package org.doit.ik.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gift {
	// 필드 
	private String gift_cd ; /* 선물코드 */
	private String gift_desc ;  /* 선물_설명 */
	private int gift_amount ;  /* 선물_수량 */
	private Date gift_dlv ;  /* 선물_예상_전달일 */
	private String gift_status ;  /* 선물_배송여부 */
	private int gift_min ;  /* 최소_후원금액 */
	private String pro_cd ; /* 프로젝트코드 */
	
	

	
	
	
	
	
}
