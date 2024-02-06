package days05;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 5:13:44
 * @subject   1~10 까지의 합 = 55 출력 ( for 문 )
 * @content 
 *
 */
public class Ex07_02 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.printf( "%d+",  i); 
			sum += i;// sum = sum + i;
		} // for
		System.out.printf("=%d\n", sum );

	} // main

} // class












