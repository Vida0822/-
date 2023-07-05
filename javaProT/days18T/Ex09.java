package days18;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오후 4:10:58
 * @subject   [ 예외처리( Exception Handling ) ]
 * @content
 *
 */
public class Ex09 {

	public static void main(String[] args) {
		// 4:23 수업 시작~
		/*
		 * 1. 프로그램 오류 ? 프로그램 오작동 또는 비정상 종료되는 원인
		 * 2. 오류 발생 시점                        1) + 2) = 빌드오류
		 *      1) 컴파일 오류 
		 *      2) 실행 오류  == 런타임  오류
		 *             (1)  에러( error )          :  메모리 부족, 스택 오버플로워 에러, 복구할 수 없는 심각한 오류
		 *                    Error 클래스 
		 *                           ㄴ 자식클래스
		 *             (2)  예외( exception ) : 수습될 수 있는 비교적 덜 심각한 실행 오류
		 *                   Exception 클래스
		 *                         ㄴ 자식 클래스
		 *      3) 논리적 오류( 가장 어려운 오류 )
		 *           int a = Integer.MAX_VALUE;
		 *           long b = a + 100;
		 *           syso  b;                 -21.........
		 *                              
		 *  3. 예외 클래스의 계층 구조
		 *                    													 Object
		 *                      
		 *                                                                    Throwable
		 *                                                                    
		 *                                           Exception                                               Error
		 *                                           
		 *                RuntimeException              IOException                           OutOfMemoryError
		 *                      ㄴ ArithmeticException
		 *                      ㄴ  NullPointException                                                          
		 *                      ㄴ   IndexOutOfBoundsException                                                         
		 *                      ㄴ   ClassCastException    
		 *                      ㄴ          
		 *    4. 예외 처리 방법
		 *         1) try~catch문 
		 *         2) throws 문
		 *         
		 *          - 예외 처리 정의 ? 프로그램 실행 시 발생할 수 있는 예기치 못한 예외의 발생에 대비한 코드를 작성하는 것.
		 *          -          "      목적 ? 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하기 위해..
		 *          
		 *    5. 코딩 후 실행 ( Ctrl + F11 )을 하면 예외가 발생 -> 예외처리 X -> 출력 +  비정상적으로 종료.
		 *                                                                                 -> 예외처리 ( try~ catch 문 ) O
		 *                                                                                 JVM의 "예외처리기"가 발생한 예외( uncaught exception)을 받아서
		 *                                                                                 try~catch문에 예외객체를 전달해 준다.                                                                             
		 * */

	} // main

} // class
