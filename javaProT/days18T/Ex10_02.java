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
public class Ex10_02 {

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
		} catch (ArithmeticException e) { 
			   System.out.println("산술적 예외 발생 + 처리");
		} catch (InputMismatchException e) {
			  System.out.println("입력 실수 예외 발생");
		} catch (Exception e) {  // 다형성
			System.out.println("모든 예외의 부모 Exception 클래스 이기에 제일 밑에 catch 블럭을 위치시킨다.");
		}
	 
		System.out.println("= 정상적 종료 =");
	} // main

} // class











