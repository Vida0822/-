package days15;

import days14.Car;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 15. - 오후 5:00:20
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:30 제출~
		// JVM - Runtime Data Area
		/*
		 * 1. Method Area  - 클래스,인터페이스 정보 저장 영역,   클래스(static) 변수 , 메서드 등록
		 *      ㄴ Runtime Constant Pool
		 *      
		 *      dispCarInfo () 메서드 등록
		 *      [name]
		 *      
		 * 2. Heap Area  - 인스턴스
		 *                           인스턴변수
		 *                           동적 할당 영역 - new 연산자에 의해 생성된 클래스, 배열
		 *                           new int[10]
		 *                           new Car()
		 *                           
		 *                           [speed][wheelCount][dispCarInfo() 주소참조]
		 * 3. Stack Area - 메서드 안에 선언된 변수(데이타) 저장되는 영역
		 *                          지역변수, 메서드의 파라미터(매개변수), 메서드의 리턴값 등등
		 * 4. PC register
		 * 5. Native Method Stack - 자바가 아닌 다른 언어로 작성된 코드(  메서드 X )  c 언어
		 * 
		 * */
		
		// Car myCar;
		// myCar = new Car();
		
		
		// 11:05 수업 시작~
		
	} // main

} // class




/*
 * 1조_연봉1조 : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일) 
 * 2조_귀염2(이)조 : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일) 
 * 3조_자바를 잡아 : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */

//(JVM) 특징, 구조, 메모리, 동작 방식 
// https://blog.naver.com/crazem/222993824695