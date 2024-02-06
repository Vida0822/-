package org.doit.ik.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pay {
	
	// 필드 
	private String sp_cd; /* 후원_코드 */
	private Date sp_date; /* 후원일 */
	private int sp_total; /* 총결제예정금액 */
	private int sp_add; /* 추가후원금 */
	private Date sp_gift_dlv; /* 선물전달완료일 */
	private String sp_status;  /* 결제상태 */
	private String m_cd; /* 회원코드 */
	private String pro_cd;  /* 프로젝트코드 */
	private String addr_cd; /* 배송지코드 */
	private String tkt_cd; /* 응원권_코드 */
	private String pm_cd;  /* 결제수단코드 */
	private String gift_cd; /* 선물코드 */

}
