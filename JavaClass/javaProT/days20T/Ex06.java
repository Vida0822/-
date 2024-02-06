package days20;

// 클래스의 static 멤버를 사용할 때는    클래스명.static멤버
// 클래스명을 생략하고 싶으면 
// import static 패키지명.클래스명.*;
import static java.lang.Math.*;
import static java.lang.System.*;
		
/**
 * @author ♈ k§nik
 * @date 2023. 2. 22. - 오후 2:11:01
 * @subject 
 * @content 
 */
public class Ex06 {

	public static void main(String[] args) {
		// 어제  클래스(OOP) 기본 개념 설명 ~
		// Object
		// String, StringBuffer, StringBuilder, StringTokenizer
		// [Math 클래스  ]
		//   -  모든 멤버들이 static 이다.
		//   -  수학 관련된 메서드 
		//   -   필드  2개
		out.println( PI );
		out.println( E );
		
		//  - 메서드 
		out.println(  random()  ); // 랜덤갓
		out.println(  max(2,4)  ); // 최대값
		out.println(  min(2,4)  ); // 최소값
		out.println(  pow(2,3)  ); // 누승           double
		out.println(  abs(-10)  ); // 절대값
		out.println(  sqrt(4) ); // double 2.0
		
		// 반올림, 올림(절상), 버림(절삭) *** 
		//                                                       소수점 첫 번째 자리에서 올림(절상)
		out.println(    ceil( 45.179 )   );  // 천장  == 올림   double
		out.println(    ceil( 45.779 )   );  // 천장  == 올림
		out.println(    ceil( 45.579 )   );  // 천장  == 올림
		
		out.println(    floor( 45.179 )   );  // 바닥  == 내림(절삭)  double
		out.println(    floor( 45.779 )   );  // 바닥  == 내림
		out.println(    floor( 45.579 )   );  // 바닥  == 내림

		out.println(    round( 45.179 )   );  // 반올림         int
		out.println(    round( 45.779 )   );  // 반올림         int
		out.println(    round( 45.579 )   );  // 반올림        int
		

		// [ StrictMath 클래스 ]
		// Math 클래스는 최대한 성능을 얻기 위해 JVM이 설치된 OS의 메서드를 호출해서 처리한다. 
		// OS 에 따라서 반올림 처리 방법이 다르다. -> OS 결과가 다르게 처리되기도 한다. 
		// 이런 단점을 없애기 위해 성능은 포기하는 대신 항상 같은 결과가 나오도록 만든 Math 클래스가
		//  StrictMath 클래스이다. 
	} // main

} // class







