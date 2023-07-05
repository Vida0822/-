package days16;

/**
 * @author ♈ kenik
 * @date 2023. 2. 16. - 오전 5:46:00
 * @subject  박진용(졸업식)
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:40  제출~
		// 10:03 수업 시작~~ 
		String n = "keNik";   
		String m= "kKnie";   
		
		// 1)  대문자로 변환   KENIK               KKNIE
		// 2) 정렬                  EIKKN               EIKKN
		// 3) 두 문자열이 같냐 ? 
		
		// System.out.println(  n.toUpperCase() );
		
		// 1) n, m  모두 대문자로 변환..
		//   'a' -32    ->   'A'
		/*
		for (int i = 0; i < n.length() ; i++) {
			char one =  n.charAt(i);
			if( 'a' <= one  && one <= 'z' ) {
			    System.out.println(   (char)(one - 32)  );
			}else {
				System.out.println( one );
			}
		}
		*/

	} // main

} // class





/*
 * 1조_연봉1조 : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일) 
 * 2조_귀염2(이)조 : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일) 
 * 3조_자바를 잡아 : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
