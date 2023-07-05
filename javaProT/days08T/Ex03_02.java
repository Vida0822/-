package days08;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 2:44:07
 * @subject
 * @content
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// 3:10 수업시작~ 
		drawLine(); //  함수 호출부
		System.out.println(" 부서명  : 사원명 ");
		drawLine(30);
		System.out.println(" 영업부  : 이태규 ");
		System.out.println(" 총무부  : 신희민 ");
		System.out.println(" 생산부  : 박현주 ");
		System.out.println(" 기획부  : 김예지 ");
		System.out.println(" 기획부  : 하동호 ");
		drawLine(15, '$');
		
		/*
			System.out.println(100);
			System.out.println('A');
			System.out.println("hong");
			System.out.println(3.14);
			System.out.println(true);
		*/
	} // main
	
	// 반드시 함수(메서드) 선언할 때는 클래스 안에 다른 함수 밖에..
	// 1) 기능 : 라인(선) 긋는 함수        drawLine
	// 2) 매개변수 : X
	// 3) 리턴값    :  X  ->  리턴자료형  void
	public  static void  drawLine()   // 함수 선언부
	{  
		System.out.println("------------"); // line 선 긋는 코딩 ( 50줄 코딩 )   
	} 

	// 1) 기능 : 라인(선) 긋는 함수        drawLine
	// 2) 매개변수 :  int n   - X n개
	// 3) 리턴값    :  X  ->  리턴자료형  void
	
	// 매개변수의 타입 또는 갯수가 다른 동일한 함수를  중복선언할 수 있다. 
	// 중복함수(  Overloading )  오버로딩
	// Duplicate method drawLine() in type Ex03_02
	public  static void  drawLine(int n)   // 함수 선언부
	{  
		for (int i = 1; i <= n ; i++) {
			System.out.print("-");
		}
		System.out.println(); // line 선 긋는 코딩 ( 50줄 코딩 )   
	} 
	
	// 내가 원하는 스타일로 원하는 길이 만큰 선을 그을 수 있는 함수
	public  static void  drawLine(int n, char style)   // 함수 선언부
	{  
		for (int i = 1; i <= n ; i++) {
			System.out.print(  style  );
		}
		System.out.println(); // line 선 긋는 코딩 ( 50줄 코딩 )   
	} 
} // class













