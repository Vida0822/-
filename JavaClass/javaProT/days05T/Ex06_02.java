package days05;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 3:50:20
 * @subject 
 * @content 
 *
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		// 랜덤한(임의의) 값을 발생해 주는 메서드
		// 0.0 <= double Math.random()  < 1.0
		
		// 로또번호 1~45  임의의 수가 발생하는 코딩을 하세요.
		// 국어점수 0~100                 "
	 
		System.out.println( (int)(Math.random()*3)+1   );
		System.out.println( (int)(Math.random()*3)+1   );
		System.out.println( (int)(Math.random()*3)+1   );
		System.out.println( (int)(Math.random()*3)+1   );
		System.out.println( (int)(Math.random()*3)+1   );
 
		
		// 1,2,3  임의의 값이 발생하도록... 
		// 1 <= (int)(Math.random()*3)+1  < 4

	} // main

} // class












