package days05;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 4:50:33
 * @subject  while 조건 반복문      5:02 수업 시작~ 
 * @content 1~10까지의 합 출력 : for/while 설명
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		//
		/*
		while (en.hasMoreElements()) {
			type type = (type) en.nextElement();
			
		}
		*/
		/*
		while (it.hasNext()) {
			type type = (type) it.next();
			
		}
		*/
		 
	   // 조건이 참일 동안 반복
	   // 임의의 숫자(1~3)를 10번 출력하세요.
	  int i = 1;
	  while ( i <= 10 ) {   // 1 <= 10   거짓
			 System.out.println( (int)( Math.random() * 3 ) + 1 );
			 i++;  // 11
		} // while
		 

	} // main

} // class













