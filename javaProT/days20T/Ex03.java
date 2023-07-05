package days20;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 22. - 오전 11:32:09
 * @subject 
 * @content    [문자열 관련 클래스들]
 *                         String  불변
 *                        1) StringBuffer  - 멀티 스레드 안전하지 않다.
 *                        2) StringBuilder  - 멀티 스레드 안전하다. ( == 즉, 동기화 처리가 되어져 있다. )
 *                         
 *                         StringTokenizer 
 */
public class Ex03 {

	public static void main(String[] args) {
		// (Hello) 문자열 삽입, 수정, 삭제, 추가 등등 문자열을 자주 변경해야된다면 String클래스를 사용하지 않는다.
		// StringBuffer, StringBuilder를 사용한다. 
		// ( 시험) 어떤 경우에 String 클래스 대신에 문자열을 StringBuffer, StringBuilder를 사용합니까? 
		String str1 = "안녕하세요. 홍길동입니다. ";
		// 1 위치의 문자를 '뇽' 수정
		
		
		
		StringBuffer sb = new StringBuffer(str1);		
		System.out.println( sb.toString() );		
		int offset =   sb.indexOf("안녕") + "안녕".length()  ;
		sb.insert(offset, "(Hello)");		
		System.out.println( sb );
		
		int start , end;
		start = sb.indexOf("홍길동");
		end = start + "홍길동".length();
		sb.replace(start, end, "김동현");
		// sb.replace(start, end, "");
		System.out.println(  sb );
		
		sb.delete(start, end);
		System.out.println(  sb );
		
		// 10                  00001010
		// sb.reverse();
		//System.out.println(sb  );
		
		sb.setCharAt(1, '뇽');
		System.out.println(sb  );
		
	} // main

} // class














