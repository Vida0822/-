package days14;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오후 4:48:31
 * @subject 
 * @content 
 */
public class Ex09 {
	
	// [ 멤버 변수 == 필드 ]
	// "인스턴스 변수" 선언 형식
	// [접근지정자] [ 기타제어자]   자료형  필드명;
	public  String name = null;
	public int age = 0;
	public boolean gender = false;
	
	// "클래스 변수"
	// static 기타제어자가 붙어있는 필드
	public static double PI = 3.141592;

	
	// 멤버 함수 == 메서드 
	public static void main(String[] args) {
		/*
		 *  [ 변수 종류]  - 선언되는 위치를 기준으로 변수 구분
		 *  1. 지역변수 - 해당 영역(지역)에서만 사용되는 변수/ 변수 선언문을 실행할때 /   해당 영역 빠져나올때
		 *  
		 *   필드( field )
		 *  2. 인스턴스 변수 -                                                 / 인스턴스가 생성될 때 / 인스턴스 소멸될 때
		 *      -  초기화 하지 않아도 그 자료형의 기본값으로 초기화 되어져 있다. 
		 *  3. 클래스 변수                                                        / 해당 클래스가 메모리에 올라갈때 / 프로그램 종료할때
		 *                                                                              ( 프로그램 시작할 때 )
		 * */

		int age;  // 지역변수
	} // main

} // class







