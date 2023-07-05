package project.service;

import file.model.File;
import member.model.Member;

public class ViewCreator {
	
	// 필드 
	private Member member ; /* 창작자(회원)이름 */ 
	private File creatorPhoto ;  /* 창작자(회원)사진 */ 
	private int lastSession ; /* 접속시간 */ 
	String pro_ct_intro ;  /* 창작자 소개  */
	
	// 팔로우, 창작자 문의도 회원코드만 필요하니까(조회중인 사용자, 창작자) ! 이정도로 충분할 듯 
	
	
	// 생성자 
	public ViewCreator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViewCreator(Member member, File creatorPhoto,  int lastSession, String pro_ct_intro) {
		super();
		this.member = member;
		this.creatorPhoto = creatorPhoto; 
		this.lastSession = lastSession;
		this.pro_ct_intro = pro_ct_intro;
	}

	// getter, setter 
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getLastSession() {
		return lastSession;
	}

	public void setLastSession(int lastSession) {
		this.lastSession = lastSession;
	}

	public String getPro_ct_intro() {
		return pro_ct_intro;
	}

	public void setPro_ct_intro(String pro_ct_intro) {
		this.pro_ct_intro = pro_ct_intro;
	}

	public File getCreatorPhoto() {
		return creatorPhoto;
	}

	public void setCreatorPhoto(File creatorPhoto) {
		this.creatorPhoto = creatorPhoto;
	} 
	
	
	
	
	
}
