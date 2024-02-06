package days20;

// 클래스의 static 멤버를 사용할 때는 클래스명.static멤버
// 클래스명을 생략하고 싶으면
// import static 패키지명.클래스명.*;
import static java.lang.Math.*; // Math. 생략 가능
import static java.lang.System.*; // System 생략 가능

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오후 2:11:43
 * @subject
 * @content
 */
public class Ex06 {

	public static void main(String[] args) {
		// 어제 클래스(OOP) 기본 개념 설명
		// Object
		// String, StringBuffer, StringBuilder, StringTokenizer
		// [Math 클래스]
		// - 모든 멤버들이 static 이다
		// - 수학 관련된 메서드
		// - 필드 2개
		System.out.println(Math.PI);
		out.println(E);
		
		// - 메서드
		System.out.println(Math.random()); // 랜덤값(0<= <1)
		System.out.println(Math.max(2,4)); // 최대값
		System.out.println(Math.min(2,4)); // 최소값
		out.println(pow(2,3)); // 거듭제곱 double
		out.println(abs(-10)); // 절대값
		out.println(sqrt(4)); // 루트 double
		
		// 반올림, 올림(절상), 버림(절삭)
		// 소수점 첫번째 자리에서
		System.out.println(Math.ceil(45.179)); // 천장 == 올림 double
		out.println(ceil(45.779)); // 천장 == 올림
		out.println(ceil(45.579)); // 천장 == 올림
		
		System.out.println(Math.floor(45.179)); // 바닥 == 버림 double
		out.println(floor(45.779)); // 바닥 == 버림
		out.println(floor(45.579)); // 바닥 == 버림
		
		System.out.println(Math.round(45.179)); // 반올림 int
		out.println(round(45.779)); // 반올림
		out.println(round(45.579)); // 반올림
		
		// [StrictMath 클래스]
		// Math 클래스는 최대한 성능을 얻기 위해 JVM이 설치된 OS의 메서드를 호출해서 처리한다
		// OS에 따라서 반올림 처리 방법이 다르다 -> OS 결과가 다르게 처리되기도 한다
		// 이런 단점을 없애기 위해 성능은 포기하는 대신 항상 같은 결과가 나오도록 만든 Math 클래스가
		// StrictMath 클래스이다
		

	}//main

}//class
