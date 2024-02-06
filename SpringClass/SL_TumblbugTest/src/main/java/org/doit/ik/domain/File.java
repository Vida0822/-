package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {
	// 필드 
	private String af_cd; // 첨부파일_코드
	private String af_ex_name; // 기존파일이름
	private String af_sys_name; // 시스템파일이름
	private String af_path; // 파일경로
	private String af_type; // 파일분류
	private String af_rep; // 대표파일
	private String m_cd; // 회원코드
	private String cra_cd; // 입금계좌코드
	private String tb_cd; // 세금계산서_코드
	private String cpst_cd; // 커뮤니티_게시글_코드
	private String pro_cd; // 프로젝트코드
	private String review_cd; // 후기_코드
	

	
} // File
