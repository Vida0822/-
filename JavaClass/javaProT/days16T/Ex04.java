package days16;

/**
 * @author ♈ kenik
 * @date 2023. 2. 16. - 오전 11:58:24
 * @subject
 * @content
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// 12:10 수업 시작~~
		/*
		 *  1. 변수
		 *     1) 지역변수
		 *     2) 인스턴스 변수
		 *     3) 클래스(static) 변수
		 *     
		 *  2. 메서드 
		 *     1) 인스턴스 메서드
		 *     2) 클래스(static) 메서드   
		 *     
		 *  3. 클래스를 설계할 때,   필드 중에 모든 인스턴스가 공유해야할 필드가 있다면      static 변수 로 선언한다.   
		 *      클래스 변수는  인스턴스를 생성하지 않아도 클래스명.static변수 로 사용할 수 있다. 
		 *      클래스 메서드는 인스턴스 변수를 사용할 수 없다. 
		 *      메서드 내에서 인스턴스 변수를 사용하지 않는다면, static 을 붙이는 것을 고려한다. 
		 *      
		 * */
		
		// 클래스명.static필드
		// System.out.print();
		
		// 클래스명.static메서드
		// Math.random();

		// System.out.println(  Ex04.sum( 1,2 )   );
		 System.out.println(  sum( 1,2 )   );
		
	   //  sum() 같은 클래스 안에 있는 main() 메서드에서 호출하기 때문에  클래스명 생략
		
		//Ex04 obj = new Ex04();
		//obj.sum(1, 3);
		
	} // main
	
	public static  int sum( int a, int b) {
		return a+b;
	}

} // class
