package days14;

// 클래스 선언
public class Car {
	
	// 멤버
	// ㄱ. 속성 == 멤버변수 == 필드( field )                지역변수 X
	String name; // 자동차 이름
	int speed;      // 속도
	int wheelCount; // 바퀴수
	
	// ㄴ. 기능(일) == 멤버함수 == 메서드( method )
	public void dispCarInfo() {
		System.out.printf("> 차명:%s, 속도:%d \n", name, speed );
	}

} // class
