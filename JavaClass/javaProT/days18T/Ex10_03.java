package days18;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오후 4:41:01
 * @subject
 * @content
 *
 */
public class Ex10_03 {

	public static void main(String[] args) {
		
		int a = 0, b = 0;
		
		InputStream   source  = System.in;
		Scanner scanner = new Scanner( source );
		  
		// 다중 catch 블럭을 사용할 수 있어요.. 
		// ( 주의 사항 )  부모 예외 클래스를 밑에 코딩한다. 
		try {
			System.out.print("> a, b 두 정 수 입력 ? ");
			a = scanner.nextInt();   // a     InputMismatchException
			b = scanner.nextInt();
			double c =  a / b;
			System.out.printf("%d / %d  = %.2f\n", a, b, c);
		} catch (ArithmeticException | InputMismatchException e) {
			// JDK 1.7 부터 
			// 여러 catch 블럭을    |  연산자를 사용해서 하나의 catch블럭으로 처리할 수 있다. 
			// [ 멀티 catch 블럭  ]       !=     다중 catch 블럭
			
			System.out.println( " 1 : "+  e.toString() );  // 모든 예외 정보를 출력
			System.out.println("2 : ");
			e.printStackTrace() ; // 예외 메시지 정보 출력.
			
		   System.out.println("3 : " +  e.getMessage()  ); // 예외 메시지 정보
			
			
		} catch (Exception e) {  // 다형성
			System.out.println("모든 예외의 부모 Exception 클래스 이기에 제일 밑에 catch 블럭을 위치시킨다.");
		}
	 
		System.out.println("= 정상적 종료 =");
	} // main

} // class











