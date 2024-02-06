package days12;

import java.util.Arrays;

/**
 * @author ♈ kenik
 * @date 2023. 2. 9. - 오후 10:35:17
 * @subject
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9시 35분 제출해 주세요~
		// 16진법 : 0 1 2 3 4 5 6 7 8 9 10(a)~ 15(f)
		int n = 123;   // 7B
        int 몫, 나머지;  // share, rest
		
		// String b = "0101"; -> 1010
        char [] hex = new char[4]; // [0][0][7][B]
        
        // char 배열 hex의 모든 요소의 값을  '0'  초기화
        /*
        for (int i = 0; i < hex.length; i++) {
			hex[i] = '0';
		}
		*/
        Arrays.fill(hex, '0');
        
        int index = hex.length-1;  // 3
		while( n != 0) {
			몫 = n/16;
			나머지 = n%16; 
			// 10(A) 11(B)  12(C)  ~ 15(F)          'F'
			
			// 나머지 =  나머지 >=10? 나머지 + 55 : 나머지;
			char value =  (char)( 나머지 += 나머지 >=10 ? 55 : 48 ) ; 
			
			hex[index--] = value;
			
			/*
			if ( 나머지 >= 10) {
				switch (나머지) {
				case 10:
					b += 'A';
					break;
				case 11:
					b +='B';
					break;

				default:
					break;
				}
			} else {
				b += 나머지;
			}
			*/
			
		
			n =  몫;
		} // 
		 
	   System.out.println( "0x"+ Arrays.toString( hex ) );
		
		

	} // end of main

} // end of class



/*
 * 1조_연봉1조 : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아 : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
