package org.doit.ik.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	private String pro_cd; // insert 
	private String pro_long;
	private String pro_short;
	private String pro_sm; // insert 
	private String pro_adult; //default 
	private String pro_status;// default 
	private String pro_addr;
	private String pro_tag;
	private String pro_ct_intro; 
	private String pro_ct_area;
	private String pay_cd;
	private String dtl_ctg_code; //insert 
	private String m_cd;  
	private int pro_price ; /* 목표금액 */
	private Date pro_start ;   /* 시작일 */
	private Date pro_end ; /* 종료일 */
	private int pro_sup ; 
	
	
}// Project
