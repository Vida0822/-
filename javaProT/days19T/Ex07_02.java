package days19;

public class Ex07_02 {

	public static void main(String[] args) {
		// 
		String msg = "안녕하세요. Kenik 입니다.";
		// [문제] msg 문자열 속에서 한글은 제거하고 알파벳만을 얻어와서   name 변수에 저장해서 출력하세요.
		//11. 문자열 변경 메서드 : replace()
		// System.out.println( msg.replace("안녕", "XXX") );
		// System.out.println( msg.replace('안', 'X') );
		// msg.replace(  new StringBuffer(), new StringBuilder());
		String name =  msg.replaceAll( "[가-힣]|\\.|\\s" , "");
		System.out.println( name );
		// 4:03 수업 시작~ 
		/*
		String name = "";
		for (int i = 0; i < msg.length(); i++) {
			char one =  msg.charAt(i);
			// if( (  'A' <= one && one <='Z' )  || (  'a' <= one && one <='z' )  )
			if(  Character.isUpperCase(one)    ||  Character.isLowerCase(one)  )
			{
			     //  System.out.println(one);
			     name += one;
			}
		}
		System.out.println( name );
		*/
		
		
		

	}

}
