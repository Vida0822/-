package days20;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오전 11:32:46
 * @subject
 * @content [문자열 관련 클래스들]
 * 			String 불변
 * 			1) StringBuffer - (멀티) 스레드에 안전하지 않다
 * 			2) StringBuilder - (멀티) 스레드에 안전하다 (== 동기화 처리가 되어져있다)
 * 			
 * 			StringTokenizer
 */
public class Ex03 {

	public static void main(String[] args) {
		// (Hello) 문자열 삽입, 수정, 삭제, 추가 등등 문자열을 자주 변경해야된다면 String 클래스를 사용하지 않는다
		// StringBuffer, StringBuilder를 사용한다
		//  ㄴ String 클래스 대신 문자열 StringBuffer, StringBuilder를 사용하는 이유
		String str1 = "안녕하세요. 홍길동입니다.";
		// 1 위치의 문제를 '뇽'으로 수정
		
		StringBuffer sb = new StringBuffer(str1);
		
		System.out.println(sb.toString());
		int offset = sb.indexOf("안녕") + "안녕".length();
		sb.insert(offset, "(Hello)");
		System.out.println(sb);
		
		int start, end;
		start = sb.indexOf("홍길동");
		end = start + "홍길동".length();
		sb.replace(start, end, "김동현");
		System.out.println(sb);

		// sb.replace(start, end, "");
		sb.delete(start, end);
		System.out.println(sb);
		
		// sb.reverse();
		// System.out.println(sb);
		
		sb.setCharAt(1, '뇽');
		System.out.println(sb);
		
	}//main

}//class
