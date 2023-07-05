package days10;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 8. - 오전 10:11:36
 * @subject 
 * @content 
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String rrn ;
		// rrn = getRRN( scanner );
		rrn = "830412-1700001";
		
		//  [ 문자열 다루는 메서드 ]
		
		int year = Integer.parseInt( rrn.substring(0, 2)  );
		int month = Integer.parseInt( rrn.substring(2, 4)  );
		int day = Integer.parseInt( rrn.substring(4, 6)  );
		int gender = Integer.parseInt( rrn.substring( 7, 8)  );
		
		System.out.printf ("년도:%d, 월:%d, 일:%d,  성별 : %d\n", 
				year, month, day, gender);
		
		
		
		
		

	} // main

	public static String getRRN(Scanner scanner) {
		String regex = "\\d{6}-\\d{7}";
		String rrn;
		int  count = 0;
		do {
			if( count != 0) {
				System.out.printf("[%d] 번 입력 실패\n 다시 ", count);
			}
			System.out.print("> 주민등록번호 14자리 입력( 예:  000000-000000) ? ");
			rrn = scanner.next();
			count++;
		} while (  !rrn.matches(regex));
		// [과제] 입력 잘못 5번만 허용한다. ( 코딩 추가 )
		
		return rrn;
	}

	 

} // class











