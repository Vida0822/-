package days20;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 22. - 오후 2:43:14
 * @subject      오토박싱 & 오토 언박싱( auto boxing && auto unboxing (
 * @content      오토 == 자동으로 형변환된다. 
 */
public class Ex08 {

	public static void main(String[] args) {
		
		int x = 100;
		// 클래스     기본형        형변환 X
		// 기본형 -> 자동 -> 래퍼클래스  객체로 형변환.               오토박싱(boxing)
		Integer y = x;   // jdk 1.5 이전에는 오류 나는 코딩. 
		int z =  y;
		
		System.out.println( z   );  // 100
		// 3:01 수업 시작~ 
		// 
		int n = 10;
		test( n );

	} // main

	// int -> Integer -> Object
	private static void test(  Object i ) {
		 System.out.println(  i  );
		 
		 /*
		 System.out.printf("이름은 :  ")
		                     .printf("%s", "홍길동")
		                     .printf("나이는 : %d", 20);
		 */
	}

} // class




