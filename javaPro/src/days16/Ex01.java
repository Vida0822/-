package days16;

public class Ex01 {

	public static void main(String[] args) {

		/*
		두 문자열 n, m 이 알파벳과 알파벳갯수가 똑같은지 비교하는 코딩 
		결과는 같을 경우 true/ 다를 경우 false 로 출력.
		조건) 대소문자는 구분하지 않는다. 
		 */

		String n = "keNik";   
		String m = "kKnie";
		
		// [풀이 로직]
		// 1) 소문자 -> 대문자로 변환		KENIK	KKNIE
		// 2) 정렬 -> 오름차순				EIKKN	EIKKN
		// 3) 두 문자열이 같은지 확인
		
		// 1) n, m 모두 대문자로 변환
		// 'a' - 32 -> 'A'
		/*
		for (int i = 0; i < n.length(); i++) {
			char one = n.charAt(i);
			if ('a' <= one && one <= 'z') {
				System.out.println((char)(one-32));
			} else {
				System.out.println(one);
			}
		}
		*/
		// System.out.println(n.toUpperCase());
		
	}//main
	
}//class
