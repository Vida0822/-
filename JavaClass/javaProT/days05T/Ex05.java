package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 2:33:56
 * @subject   swich 문 : 분기문
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		/*
		 key    : 변수, 수식,     ( 정수,문자열 )
		 value :  변수X, 리터럴
		 switch (key) {
			case value: 
				break;
	       case value: 
				break;
			 case value: 
				break;
				:
			[
			  default:
				break;
			]
		}
		*/
		
		// 예)  정수를 입력받아서 홀수/짝수   라고 출력..
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 정수 입력 ? ");
		n =  scanner.nextInt();  // 3
		
		String result = "";
		// key : 변수, 수식 
		switch (   n % 2   ) {
			case 0:	
				result = "짝수";
				break; // 제어문 switch문을 빠져나간다. 
			default:    //  == case 1:
				result = "홀수";
				break;
		} // switch
		
		System.out.printf("n=%d 은/는   %s이다.\n", n, result );

	} // main 

} // class 








