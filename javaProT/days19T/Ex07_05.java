package days19;

import java.util.Arrays;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오후 5:10:26
 * @subject 
 * @content 
 */
public class Ex07_05 {

	public static void main(String[] args) {
		String url = "www.naver.com";		
		// url 반드시  http://       문자열로  시작을 해야 된다라고..
		
		String prefix = "http://";  // 접두사
		System.out.println( url.startsWith(prefix) );  // boolean
		
		
		String dir = "c:\\temp\\test";
		String suffix = "\\";  // 접미사 
		System.out.println( dir.endsWith(suffix)  );  // boolean
		
		String b = "abc";  // 65
		String a = "aCc";   // 97
		
		System.out.println(  a.compareTo(b) ); //   0   양수, 음수    -32
		
		// 두 문자열 같냐 ? 
		System.out.println(  a.equals(b) );  // false
		System.out.println(  a.equalsIgnoreCase(b) );  // truc
		

	   // "aaa" + "bbb" + "ccc"
		// "aaa".concat("bbb").concat("ccc")
		
		// 1조원 중에 김지은 있냐? 
		 String team01 = "이태규    ,     김지은 , 설경인,윤재민,   홍성철, 김동현, 박상범 "; 
		 System.out.println( team01.contains("김지은") );  // true/false
		 
		// -1  indexOf()/ lastIndexOf()
		 
		 // 문자열 -> byte[] 변환해서 반환하는 메서드  :  getBytes();
		 byte [] m =  "안녕하세요. 홍길동입니다.".getBytes();
		 System.out.println(  Arrays.toString( m ));
		 // byte[] -> 문자열 변환
		 System.out.println( new String( m ) );
		 // 
		  
		 
		 
		
	}

}
