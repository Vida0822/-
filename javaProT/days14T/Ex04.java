package days14;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오후 12:03:52
 * @subject 
 * @content 
 */
public class Ex04 {   // 시작 개체(객체)

	public static void main(String[] args) {
		
		// 지역변수는 선언할 때 앞에 접근지정자 사용하지 않는다. 
		// public int age;  
		
		Tv  t1 = new Tv();
		t1.power();  // 
		
		t1.channel = 11;  // MBC
		t1.channelUp();  // 12
		System.out.println(  t1.channel );
		
		t1.power();
		
		/*
		 * [클래스 선언 형식]
		 * [접]       [기]  class 클래스명 [extends 슈퍼클래스][implements 인터페이스...]{
		 *   modifiers
		 *   
		 *   }
		 * 
		 *   [ 클래스 앞에 붙이는 접근 지정자 설명 ] - 시험( 암기 ) 
		 *   1) public                            :  패키지 내부/외부 어디서든  [상속]과 참조 가능.
		 *   2) default ( == package) :  패키지 내부에서만 상속과 참조 가능. 
		 *      설명)  public  days14.Car
		 *                X         days14.Tv
		 *                
		 *                독립적인 클래스로 선언할 때는 사용할 수 없는 접근지정자 이다. 
		 *                중첩 클래스를 선언할 때 사용할 수 있다.  ( 내부 클래스  4가지 ..종류)
		 *                왜 ? 클래스 안에 클래스 를 선언하는가 ? X 
		 *   3) private           비활성 - 같은 파일 내에서만 상속, 참조 가능
		 *   4) protected      비활성 -  default( 패키지 내부에서만 상속 참조 가능 )
		 *                                              + 패키지 외부에서는 상속만 가능.
		 *   
		 *   [ 멤버(필드,메서드) 앞에 붙이는 접근 지정자 설명 ] 
		 *    1) public 
		 *   2)default 
		 *   3) private           
		 *   4) protected       
		 * */
		
		// 클래스의 접근지정자가 package 였기때문에 같은 패키지 내에서는 상속/참조 가능하기 때문에
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.age = 20;		
		p1.run();
		
		p1.name = "홍성철";
		p1.run();
		
		/*
		 * Modifiers =  접근지정자 ( public , package, private, protected ) +  기타제어자 ( abstract, final, static )
		 * [클래스 선언할 때 접근지정자 종류 설명]
		 * [클래스 선언할 때 기타제어자 종류 설명]
		 * 1) abstract  - 추상클래스 
		 * 2) final        - 최종(마지막) 클래스    : 상속  
		 * 3) static ( 비활성화 ) - 중첩클래스 선언할 때만 사용 가능, 정적(static)클래스 
		 * */
				

	} // main

} // class

// 클래스 선언
// The public type Tv must be defined in its own file
// 하나의 자바파일(???.java) 안에 여러 개의 클래스를 선언할 수 있다.
// 컴파일을 하면 각각의  Ex04.class, Tv.class 클래스 파일이 생성된다. 
// 반드시   Ex04.java ==   public 접근지정자 Ex04 선언할 수 있다. 
class Tv{
	
	// 중첩 클래스 
	protected class Volumn{
		
	}
	
	// 멤버 ( 클래스 구성 요소 )
	// [필드 선언 형식]
	public String color;
	public boolean power;
	public int channel;
	// 메서드
	public void power() {
		power = !power;
	}
	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}
}



