package days15;

/**
 * @author dlsgu
 * @date 2023. 2. 15. 오후 2:50:03
 * @subject ***[this 키워드] 설명***
 * @content
 */
public class Ex05 {

	public static void main(String[] args) {
		
		new MyApp();
		
		// [this 키워드]
		/*
		 * 1. 정의
		 * 	객체(클래스) 자기 자신의 주소값을 가지는 참조변수
		 * 	변수를 개발자가 선언한 적 없음
		 * 2. this 3가지 용도
		 * 	1) 멤버를 가리킬 때의 this - this.필드, this.메서드
		 * 	2) 생성자에서 또 다른 생성자를 호출할 때의 this
		 * 	   생성자 역할 : 필드 초기화 -> 왜 또 다른 생성자를 호출?
		 * 	3) 단독으로 사용될 때의 this - 리턴값, 매개변수 MyApp.java
		 * */
		
		/*
		// Ctrl + 마우스 올려서 클릭
		MyPoint p1 = new MyPoint(1,2);

		p1.offsetPoint(10);
		p1.dispMyPoint(); // 출력
		*/
		
		/*
		p1
		.offsetPoint(10)
		.dispMyPoint(); // 출력
		
		// Heap										Stack
		// [x][y][m1참][m2참][m3참][this 0x100]		[0x100]p1 참조변수, 지역변수, 객체
		// 인스턴스
		// 0x100
		
		Person p = new Person();
		
		// Method Area
		// [m1][m2][m3]
		*/

	}//main

}//class
