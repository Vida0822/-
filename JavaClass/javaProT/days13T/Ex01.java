package days13;

import java.util.Random;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오전 5:10:07
 * @subject
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:35 제출 ~ 
		String [] names = new String[30];
		int [] tots = new int[30];
		double [] avgs = new double[30];
		int [] ranks = new int[30];
		 
		System.out.println(  getAlphabetName(3) );
		System.out.println(  getAlphabetName(5) );
		System.out.println(  getAlphabetName(10) );

	} // main
	
	public static String getAlphabetName(int length) {
		// 성씨  128 개  44032	~ 55203  임의의 정수 -> char  한글 한 문자
		char [] nameArr = new char[length];
		Random rnd = new Random();
		// 대문자   65~90
		//    91~96 X
		// 소문자   97~122
		int index = 0;
		while( index < length ) {		
			int code =  ( rnd.nextInt('z' - 'A' + 1) + 'A' );
			if(  'A' <= code && code <='Z'  ||  'a' <= code && code <='z' ) {
				nameArr[index++] = (char)code;
			}
		}
		
		// char [] -> String 변환
		String name = new String( nameArr );
		return name;
	}
	
	private static int getTotalScore() {		
		return     (int)( Math.random()*301 ) ;  // 0 <=     < 301
	}

} // class



/*
 * 1조_연봉1조 : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아 : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */

