/**
 * 
 */
package days11;

/**
 * @author kenik
 * @date  2023. 2. 9. - 오후 2:15:14
 * @subject 
 * @content 
 *
 */
public class Ex03_03 {
 
	public static void main(String[] args) {
		// [정보처리기사 실기]      - 시험( 5분 ) 
		int money = 125760;
		int unit = 50000;
		boolean sw = false; // 스위치 변수 
		int count = 0; // 수량(갯수)
		while( unit >= 1) {
			count = money / unit;  // 갯수
			System.out.printf("%d원 : %d 개\n", unit, count);
			money %= unit;			
			unit /= (   !sw ? 5 :2 );  // i /= 1       i=i / 1 
			sw = !sw; 
		}
		/*
		/5 10000
		/2   5000
		/5   1000
		/2     500
		/5     100
		/2      50
		/5       10
		/2        5
		/5        1
		 */
		
	}  // end of main

} // end of class










