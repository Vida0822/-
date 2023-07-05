package days28;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오후 2:22:53
 * @subject 직렬화(Serialization) / 역직렬화
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		/*
		 * 1. 직렬화 : 객체를 데이터 스트림으로 만드는 것
		 * 				객체	->	스트림
		 * 	역직렬화			<=
		 * 
		 * 2. 객체를 직렬화해서 읽기/쓰기 할 수 있는 바이트 스트림
		 * 	1) Object + [InputStream] 바이트 스트림
		 * 		객체
		 * 	2) Object [OutputStream]
		 * 
		 * 3. 직렬화가 가능한 클래스 - Serializable 인터페이스를 구현만 하면 된다
		 * 
		 * */
		
		UserInfo u1 = new UserInfo("김동현", "1234", 25);
		UserInfo u2 = new UserInfo("탁인혁", "4321", 27);
		
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		list.add(u1);
		list.add(u2);

		String fileName = ".\\src\\days28\\UserInfo.ser";
		
		try (
				// 보조 스트림
				FileOutputStream out = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(out);
			) {
			
			oos.writeObject(u1);
			oos.writeObject(u2);
			oos.writeObject(list);
			
			oos.flush(); //
			
			System.out.println("u1, u2 객체를 직렬화해서 파일로 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//main

}//class

// 사용자의 정보를 저장하는 클래스 선언
// 직렬화 가능한 클래스의 버전 관리
class UserInfo implements Serializable {
	private static final long serialVersionUID = 5954528819822985319L;
	String name;
	// transient String password; // 직렬화 대상에서 제외시킨다
	String password; // 직렬화 대상에서 제외시킨다
	int age;
	
	public UserInfo() {
		this("UnKnown", "1111", 0);
	}

	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
	// Object obj = new Object(); // (기억) Object 객체 obj는 직렬화 할 수 없다
	// Object obj = new String("admin"); // (기억) String 객체 obj는 직렬화 할 수 있다
}
