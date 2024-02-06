package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 12:47:24
 * @subject 
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		double pi = 3.141592;
		// 소수점 3자리 부터 잘라내기.( == 소수점 2자리 까지 출력 ) 
		// System.out.printf("%.2f\n", pi);  // 출력할 때 X  반올림
		
		pi = (int)(pi*100)/100d;    // 3.0   왜 ? 
		System.out.println( pi );       // pi = 3.14   절삭
		// 
		
		/*
		pi = pi*100;
		System.out.println( pi );  // 314.1592
		pi =  (int) pi;
		System.out.println( pi );  // 314.0
		pi = pi/100;
		System.out.println( pi );  // 3.14
		*/
	} // main

} // class








