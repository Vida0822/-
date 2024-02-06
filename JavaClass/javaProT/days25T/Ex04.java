package days25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오후 12:17:59
 * @subject 
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		// Set : 중복 허용 X, 순서 유지 X
		Set<Student>  sSet = new LinkedHashSet<>();
		sSet.add( new Student("200101", "김동현", "26"));
		sSet.add( new Student("200102", "김수민", "24"));
		sSet.add( new Student("200103", "진예림", "25"));
		sSet.add( new Student("200104", "심성환", "27"));
		// 학번 같은 학생은 같은 객체로 인식해서 Set에 추가 되지 않도록 하자.
		// hashCode() 메서드 + equals() 메서드를 학번이 같은 해쉬코드
		//                                                             , 학번이 같으면 같다 equals() 오버라이딩.		
		sSet.add( new Student("200101", "김동현", "26"));
		
		System.out.println( sSet.size() );  // 4.
		
		// 학생 정보 출력.
		// 약속)   iterator() 반복자를 사용할 때 .  코딩할지 말고 복사해서 붙이고
		// Ctrl + Shift + O
		Iterator<Student> ir =  sSet.iterator();
		while (ir.hasNext()) {
			Student s = ir.next();
			System.out.printf("학번:%s, 이름:%s, 나이:%s\n", s.no, s.name, s.age);
		}

	} // main

} // class

class Student{
	String no;      // 학번  -  학생을 구분할 수 있는 고유한 필드
	String name; // 학생명
	String age;    // 나이
	
	public Student(String no, String name, String age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() { 
		return this.no.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ( obj   instanceof Student) {
			Student s = (Student)obj;
			return this.no.equals(s.no);
		}		
		return false;
	}
	
	
	
}














