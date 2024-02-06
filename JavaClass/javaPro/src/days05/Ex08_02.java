package days05;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 5:14:33
 * @subject 1~10 까지의 합 = 55 출력 ( while 문 )
 * @content 
 *
 */
public class Ex08_02 {

	public static void main(String[] args) {
		int i = 1 , sum  = 0;
		while (  i <= 10 ) {  // 1 <=10 참
			System.out.printf( "%d+",  i );
			sum  += i;
			i++;
		} // while
		System.out.printf("=%d", sum );

	} // main

} // class













