package org.doit.ik.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
 
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate ; 

    
   public MemberVO getMember(String id) throws ClassNotFoundException, SQLException
   {
      String sql = " SELECT * "
                     + " FROM MEMBER "
                     + " WHERE id = ? ";
       
      return this.jdbcTemplate.queryForObject(
    		  sql 
    		  , new Object[] {id}
    		  , new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
   } // getMember 
   
   // 회원 가입 메서드 
   public int insert(MemberVO member) throws ClassNotFoundException, SQLException
   {
      String sql = "INSERT INTO MEMBER"
            + "( ID, PWD, NAME, GENDER, BIRTH, IS_LUNAR, CPHONE, EMAIL, HABIT, REGDATE) "
            + " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
       
      return this.jdbcTemplate.update(
    		  sql
    		  ,member.getId(),member.getPwd(), member.getName()
    		  ,member.getGender(), member.getBirth(), member.getIs_lunar()
    		  ,member.getCphone(), member.getEmail(), member.getHabit()
    		); 
   }  // insert
}