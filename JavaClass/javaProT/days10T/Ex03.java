package days10;

/**
 * @author kenik
 * @date  2023. 2. 8. - 오전 10:31:21
 * @subject 
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// 1/2+2/3+3/4+ ... +8/9+9/10= ???
		// for/while 반복문/조건반복문 - (반복 규칙)
		
		//  분자/부모 ==      i / (i+1)
		double sum = 0;
		for (int i = 1; i <=9; i++) {
			System.out.printf("%d/%d+", i, i+1);
			sum +=   (double)i/(i+1);
		}
		System.out.printf("\b=%f\n", sum);
		
		

	} // main

} // class






