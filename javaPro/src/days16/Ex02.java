package days16;

/**
 * @author dlsgu
 * @date 2023. 2. 16. 오전 10:40:04
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// [생성자 this 설명] 왜? 생성자 필드 초기화~ / 또 다른 생성자를 this() this(age) 호출합니까?
		Person p1 = null;
		p1 = new Person("홍길동", 20); // 객체 생성될 때 디폴트 생성자 호출됨
		// p1.name = "홍길동"; // NullPointerException
		// p1.age = 20;
		
		// p1 = new Person(20);
		
		p1.dispPerson();
		
		// 객체 복사
		// Person p2 = p1.plusAge(5); // this == p1 == 0x1
		// p2.dispPerson();
		p1.plusAge(5).dispPerson();
		
		// [리턴값 this 설명]

	}//main

}//class

class Person {
	
	// 필드
	String name;
	int age;
	// 생성자 X
	public Person() { // 컴파일러가 자동적으로 만들어줌 (보이진 않지만)
		this.name = "익명";
		this.age = 0;
		System.out.println("1");
	}
	public Person(String name, int age) {
		// 필드 초기화
		this(age); // 모든 코딩의 제일 위에 선언(코딩)한다 (문법적)
		this.name = name;
		// this.age = age;
		System.out.println("3");
	}
	public Person(int age) {
		this(); // 디폴트 생성자 <- 생성자 this
		this.age = age;
		System.out.println("2");
	}
	// 메서드 X
	// p1.dispPerson()
	// this == p1 == 0x1
	// this.필드 (써도 되고 안써도 된다)
	public void dispPerson() {
		System.out.printf("name=%s, age=%d\n", this.name, age);
	}
	// [참조형 리턴타입]
	public Person plusAge(int n) {
		// this == p1 == 0x1
		this.age += n;
		return this; // 참조형 리턴타입 this 리턴 객체의 자기 자신의 주소값
	}
}

// 홍길동 나(홍길동 == this)는
// 관리자 나(관리자 == this)는