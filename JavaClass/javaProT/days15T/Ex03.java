package days15;

import java.util.Date;
import java.util.Scanner;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 15. - 오후 12:04:41
 * @subject    생성자 설명 
 * @content 
 */
public class Ex03 {

	public static void main(String[] args) {
		
		/*
		 * [ 생성자 설명 ]
		 * 1.  일종의 메서드이다. 
		 * 2. 리턴자료형이 없는 메서드 , 리턴값 X
		 * 3. 메서드 이름 == 클래스 이름
		 * 4. 매개변수가 없는 생성자를 "디폴트 생성자( default constructor )"라고 한다.
		 * 5. 생성자 역할 : 객체 생성할 때            필드 초기화   
		 *                        new MyPoint()   + p1.x = 10; p1.y = 20;
		 * 6. 접근지정자 사용 가능         
		 * 7. 호출 시기 :   객체 생성될 때 자동으로 호출된다. 
		 *                      인위적으로 호출 X   
		 * 8. 오버로딩(overload) 가능        
		 * 9. 클래스에 선언된 생성자가 하나도 없는 경우에는 
		 *    컴파일러가 자동으로 디폴트 생성자를 추가해준다.
		 * 10. 생성자는 상속되지 않는다.    
		 * 
		 *  ( 한 가지 주의할 점 ) 
		 * */
		
		/*
		 * MyPoint p1 = new MyPoint(); // 디폴트 생성자 호출된다. 
		 * // 필드 초기화 
		 * p1.x = 10; 
		 * p1.y = 20;
		 */
		
		// MyPoint p1 = new MyPoint(100);
		
		// The constructor MyPoint(int, int) is undefined
		MyPoint p1 = new MyPoint( 100, 200  );
		
		
		// 좌표 출력
		p1.dispMyPoint();
		
		
		// The constructor Sample() is undefined
		// Sample s = new Sample();  // 디폴트 생성자 호출
		
		// 올해 년도 : 2023
		/*  Date 클래스의 필드를 초기화*/
		Date d = new Date( 2024-1900, 10-1, 25 );
		// System.out.println( d.getYear() + 1900 );
		System.out.println(  d.toLocaleString()  );  // 2023. 2. 15. 오후 12:41:21
		
		
		
		
	} // main

} // class

class Sample{
	// 필드
	String name;	
	
	// 
	// Sample(){}
	
	// 생성자 1
	Sample( String n){
		name = n;
	}	
} // class










