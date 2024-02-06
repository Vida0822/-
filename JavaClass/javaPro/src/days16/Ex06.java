package days16;

public class Ex06 {

	// 인스턴스 변수
	private int age; // = 0
	private int [] m; // = null
	private String name; // = null
	
	// 클래스 변수
	private static double rate; // = 0.0
	
	public static void main(String[] args) {
		/*
		 * [변수 초기화]
		 * 1. 정의 : 변수를 선언하고 처음으로 값을 할당하는 것
		 * 
		 * 2. 지역변수는 반드시 초기화 해야지만 사용할 수 있다
		 *    인스턴스 변수, 클래스 변수는 초기화 하지 않으면 각 자료형의 기본값으로 초기화된다
		 *    boolean			: false
		 *    char				: '\u0000'
		 *    byte,short,int	: 0
		 *    long				: 0L
		 *    float				: 0.0f
		 *    double			: 0.0 또는 0.0d
		 *    참조형			: null (배열, 클래스...)
		 *    
		 * 3. 필드(멤버변수)를 초기화하는 방법 [시험문제]
		 * 	(1) 명시적 초기화
		 * 	(2) 생성자 초기화
		 * 	(3) 초기화 블럭
		 * 		ㄱ. 인스턴스 초기화 블럭 - 인스턴스 변수를 초기화하는 데 사용
		 * 		ㄴ. 클래스 초기화 블럭 - 클래스 변수를 초기화하는 데 사용
		 * 								 객체 생성과 상관없이 프로그램 시작할 때 한 번 static {} 실행됨
		 * 4. 초기화 순서
		 * 	(먼저) 명시적 초기화 > 클래스 초기화 블럭 > 인스턴스 초기화 블럭 > 생성자 초기화 (나중)
		 * 							   1번만 실행	 객체가 쇙성될 때마다 실행
		 * 
		 * */
		
		Member p1 = new Member();
		System.out.println(p1.name); // 익명 -> 무명
		System.out.println(p1.count); // 0
		
		Member p2 = new Member();

	}//main

}//class

// The type Person is already defined -> Ex02에 Person 이미 선언됨
class Member {
	// [필드]
	// 1. 인스턴스 변수
	String name = "익명"; // 명시적 초기화
	int age = 20; // 명시적 초기화
	
	int count; // 명시적 초기화 X
	int serialNo; // 명시적 초기화 X
	
	// 2. 클래스 변수
	static double rate = 0.05; // 명시적 초기화
	
	// 클래스 초기화 블럭
	static {
		// 일괄적으로 static 변수를 초기화 할 때 사용
		System.out.println("클래스 초기화 블럭 호출됨");
	}
	
	// 생성자를 오버로딩(중복선언) 했을 때 중복되는 초기화 코딩이 있다면
	// 그 중복코딩을 인스턴스 초기화 블럭으로 따로 선언한다
	{
		count++;
		serialNo = count;
		System.out.println("인스턴스 초기화 블럭 호출됨");
	}
	
	// 생성자 초기화
	public Member () {
		// count++;
		// serialNo = count;
		name = "무명"; // 명시적초기화(익명), 생성자(무명)
		System.out.println("디폴트 생성자 호출됨");
	}
	
	public Member (String name) {
		// count++;
		// serialNo = count;
		this.name = name;
	}
	
}