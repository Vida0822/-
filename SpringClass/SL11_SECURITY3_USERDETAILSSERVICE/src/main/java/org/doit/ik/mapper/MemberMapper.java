package org.doit.ik.mapper;

import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;
 
public interface MemberMapper {
    
	// 회원정보 얻어오는 메서드 
   public MemberVO getMember(String id) throws ClassNotFoundException, SQLException;
   
   // 회원 가입 메서드 
   public int insert(MemberVO member) throws ClassNotFoundException, SQLException;
   
   // 회원정보 + 권한정보들 얻어오는 메서드 
   public MemberVO read(String userid) ; // 1번과 다른점 : 권한 정보가 필드로 추가되어있어 그 값을 가지고 있는 member 객체를 얻어오는 거임  
}