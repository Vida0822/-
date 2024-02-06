package days19;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오후 2:45:02
 * @subject    문자열을 다루는 클래스 
 * @content
 *     1) String 클래스                ****
 *     2) StringBuffer 클래스
 *     3) StringBuilder 클래스
 *     4) StringTokenizer 클래스               
 *     
 *     java.util 패키지 안의 클래스 
 *     
 *     날짜/시간 클래스 
 *     
 *     컬렉션 프레임워크
 *  
 */
public class Ex07 {

	public static void main(String[] args) {
		// String 클래스는 "변경 불가능한 클래스"이다. (암기)
		// String name = "홍길동";  // 이 코딩의 의미는 ?    3:02 수업 시작~~
		/*
		 *  힙                                                 스택
		 *   [홍길동]                                      ["홍길동" 상대주소]
		 *  주소                                             name
		 *  "홍길동"주소값  
		 * 
		 * */
		
		/*
		// [질문]  String 클래스  객체 생성하려면   new String();
		String name = new String("홍길동");		
		System.out.println(   name.toString()  );  // "홍길동"
		System.out.println(   name  );  // "홍길동"
		*/
		
		// [String 클래스의 메서드 정리]
		String msg = "hello world~";
		System.out.println(  msg.length()  );  //1.  문자열 길이
		System.out.println( msg.charAt( 0) ); // 2. 문자열 에서 위치의 한 문자 얻어오는 메서드
		System.out.println( msg.toUpperCase() ); // 3. 대문자로 변환하는 메서드 
		//                                                                        4.  toLowerCase()
		// 5. 패턴 비교하는 메서드  msg.matches(regex)
		// 6.문자열-> char[] 로 변환하는 메서드 
		char [] arr =  msg.toCharArray();		
		// 7. 문자열 앞 뒤의 공백을 제거하는 메서드  - msg.trim();
		// 8. 문자열 속에서 내가 원하는 beginIndex, endIndex 위치의 문자열을 반환하는 메서드 
		System.out.println( msg.substring(2, 5) );
		// 9. 문자열을 결합(연결)한 문자열을 반환하는 메서드 - concat() 
		// "aaa" + "bbb";
		System.out.println( "aaa".concat("bbb") );  // "aaabbb"
		// 10. 두 문자열이 비교하는 메서드  
		msg.equals("XXX"); // 대소문자 구분해서 비교..
		msg.equalsIgnoreCase("xxx"); // 대소문자 구분 하지 않고 비교 
		
		System.out.println(  "AbC".equals("abc") );  // false
		System.out.println(  "AbC".equalsIgnoreCase("abc") );  // true
		// 11. 
		
		
		
		
		/*
		int [] m = new int[5];
		System.out.println( m.length );
		*/

	} // main

} // class







