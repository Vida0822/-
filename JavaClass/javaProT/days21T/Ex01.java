package days21;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 23. - 오전 7:17:57
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// 10:00 제출  + 10
		// 10:10 수업 시작~ 
		// 11:04 수업 시작~ ( 2번 풀이 )
		String my_str =  "abcdef123"  ; // "abc1Addfggg4556b";   //
		int n =  	3	  ;  //  6;                                                   //
		// ["abc1Ad", "dfggg4", "556b"]
		// ["abc", "def", "123"]		 
		String [] answer =  solution(my_str, n);		
		System.out.println(  Arrays.toString( answer )    );

	} // main

	public static String[] solution(String my_str, int n) { 
		// 
		//  abc1Ad    dfggg4   556b   3개
		int my_strLength =  my_str.length();  // 문자열의 길이    16
		int size =    (int) Math.ceil( (double) my_strLength / n  );
		String[] answer = new String[size];  
		
		// my_str.substring(0, 6 );      0 포함    6 포함X             i+=n
		// my_str.substring(6, 12);
		// my_str.substring(12); 
		//                                    i / i+n
		// 11:49 + 10 분
		// 12:10 풀이~ 
		int i = 0, idx = 0;
		try {
			for (             ; i < my_strLength ; i+=n, idx++) {
			    answer[idx] =   my_str.substring(i, i+n );
		     } 
		} catch (Exception e) {
			answer[idx] =   my_str.substring(i);
		}
		
		return answer;
	}

} // class






/*
 * 1조_연봉1조          : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
