package days07;

import java.io.Serializable;
import java.util.Date;

public class MemberInfo implements Serializable { 
	// implements Serializable  -> 3) 직렬화가 가능   == > 자바빈(Bean)
// 객체를 클래스 자체 통째로 Stream 으로 만들어서 네트워크에 보내고, 파일로 저장하고.. 등등 의 작업을 할 수 있도록 한게 serializable ! 
						
	
	private static final long serialVersionUID = 1L; // +) serial Number 

	/*
	 * * 자바빈 규약 1) 필드는 private 필드로 선언해야한다 2) getter, setter 선언 3) 직렬화가 가능한 클래스 선언
	 */
	
	// 1) private 필드 
	private String id ; 
	private String passwd ; 
	private String name ;
	private Date registerDate; 
	private String email;
	
	
	// 2) getter, setter 
	// id 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// password
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// registerDate
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	//email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	
	
}
