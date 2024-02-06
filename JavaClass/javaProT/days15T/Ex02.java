package days15;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 15. - 오전 11:06:56
 * @subject 
 * @content  
 *      기본형 매개변수와 참조형(객체) 매개변수
 *		기본형 반환타입과 참조형 반환타입
 */
public class Ex02 {

	public static void main(String[] args) {
		// 1. 좌표를 관리하는 클래스 선언 : MyPoint
		MyPoint p1 = new MyPoint();
		p1.dispMyPoint(); // 0,0
		
		MyPoint p2 = new MyPoint();
		p2.x = 10;
		p2.y = 20;
		p2.dispMyPoint();  // 10, 20
		
		// The method offset(int) is undefined for the type MyPoint
		p1.offsetPoint(5);
		p1.dispMyPoint();  // 5,5
		
		p2.offsetPoint(  p1  );
		p2.dispMyPoint(); // p2  15, 25
		
		// MyPoint 객체의 x 좌표값만 얻어와서 출력.
		int x = p1.getX();
		System.out.println("p1의 x : " + x );
		
		// 참조형 매개변수
		// 참조형 리턴타입
		MyPoint p3 =  p2.plus( p1 );
		p3.dispMyPoint();
		
		
		p2
		    .plus(p1)
		    .dispMyPoint() ;
		
		// p1.offsetPoint(x).offsetPoint(20);  사용할 수 없는 코딩.
		// 이유? offsetPoint() 메서드의 리턴타입이 MyPoint 타입이 아니기 때문에... 
		
		//MyPoint p100 =  p2.test(p1);
		// p100.test( p1 );  
		
		// p2.test(p1).dispMyPoint();

	} // main

} // class







