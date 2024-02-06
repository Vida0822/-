package days10;

import java.util.Arrays;
import java.util.Random;

/**
 * @author kenik
 * @date  2023. 2. 8. - 오전 08:17:06
 * @subject 
 * @content 
 *    결석 :  이태규(졸업식)
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:30 제출
		int [] lotto = new int[6];
		
		fillLotto( lotto );
	    dispLotto( lotto );

	} // main

	private static void fillLotto(int[] lotto) {
		int index = 0 , n ;
		Random rnd = new Random(); 
		
		while( index <= 5 ) {
		     n = rnd.nextInt(45)+1;   // 1<=   <= 45
		     if( isDuplicateLotto(lotto, n, index) ) {
		    	 lotto[index] = n;
		    	 index++;
		     }
		} //
		
	}

	private static void dispLotto(int[] lotto) {
		// Arrays 클래스는 배열을 사용하기 쉽도록 기능이 구현된 클래스 이다.
		//  ㄴ toString()  배열-> 문자열로 반환하는 메서드 
		System.out.println( Arrays.toString(lotto) ); // "[0, 0, 0, 0, 0, 0]"
	}

	public static boolean isDuplicateLotto(  int [] lotto, int n, int index ){
		for(int i=0; i< index ; i++){
			if(   lotto[i] == n  ) return  false;
		}
		return true;
	} 

} // class


/*
1조_연봉1조  			:  [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범             		(화요일)
2조_귀염2(이)조 	: [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주                     	(수요일)
3조_자바를 잡아	: [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁              	(목요일)
 */
