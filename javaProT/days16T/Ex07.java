package days16;

/**
 * @author ♈ kenik
 * @date 2023. 2. 16. - 오후 2:42:20
 * @subject
 * @content
 *
 */
public class Ex07 {

	public static void main(String[] args) {
		/*
		 * [클래스 들간의 2가지 관계]
		 * 1. has-a 관계
		 *     자동차      가져야한다         엔진(1)
		 *     Car                                     Engine
		 * 2. is-a 관계 ( 상속 )
		 * */ 
		// NullPointerException
		
		Engine h_engin = new Engine();
		Engine k_engin = new Engine();
		Engine s_engin = new Engine();
		
		// [ 의존성 주입(DI) ]
		// 1.  생성자 통해서 주입
		// 2. setter 를 통해서 주입.
		Car myCar = new Car( k_engin );
		myCar.speedUp(10);
		
		// 10년 차 탔어요..  엔진 성능적인 문제 - s_engin 장착해서 차 타고 싶어요.. 
		myCar.setEngine(s_engin);
		
		// 클래스명.static필드.Member클래스의 count 필드 = 1;
		Car.member.count = 1;
		
		// has-a 관계
		// Car              static Member        member필드
		//  System     static PrintStream out 필드
		// 클래스명.
	   System.out.println("test");
		

		System.out.println("= end =");
	} // main

} // class
