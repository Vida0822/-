package days16;

/**
 * @author dlsgu
 * @date 2023. 2. 16. 오후 2:42:35
 * @subject
 * @content
 */
public class Ex07 {

	public static void main(String[] args) {
		/*
		 * [클래스들 간의 2가지 관계]
		 * 1. has-a 관계
		 * 	자동차 가져야한다 엔진(1)
		 * 	 Car			  Engine
		 * 2. is-a 관계 (상속)
		 * */
		// NullPointerException
		
		Engine h_engine = new Engine();
		Engine k_engine = new Engine();
		Engine s_engine = new Engine();
		
		// 의존성 주입 (DI) [시험문제]
		// 1. 생성자를 통해서 주입
		// 2. setter를 통해서 주입
		Car myCar = new Car(k_engine);
		myCar.speedUp(10);
		
		// 10년동안 주행 후 엔진의 성능적인 문제 발생 -> s_engine으로 엔진 교체
		myCar.setEngine(s_engine);
		
		// 클래스명.static필드.Member 클래스의 count 필드 = 1
		Car.member.count = 1;
		
		// has-a 관계
		// Car		static Member	member 필드
		// System	static PrintStream out 필드
		// 클래스명
		System.out.println("test");
		
		System.out.println("=end=");

	}//main

}//class
