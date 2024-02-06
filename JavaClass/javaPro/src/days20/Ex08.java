package days20;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오후 2:43:26
 * @subject 오토박싱 & 오토언박싱 (auto boxing && auto unboxing)
 * @content 오토 == 자동으로 형변환된다
 */
public class Ex08 {

	public static void main(String[] args) {
		
		int x = 100;
		// JDK1.5 이전에는 오류나는 코딩
		// 클래스 <-> 기본형	형번환 X
		
		Integer y = x; // 기본형 -> 자동 -> 래퍼클래스 객체로 형변환	오토박싱(auto boxing)
		
		int z = y; // 래퍼클래스 객체 -> 자동 -> 기본형으로 형변환	오토언박싱(auto unboxing)
		
		System.out.println(y);
		
		int n = 10;
		test(n);

	}//main
	
	// int -> Integer -> Number -> Object
	private static void test(Object i) {
		System.out.println(i);
		
		System.out.printf("이름은 : ").printf("%s", "홍길동 ").printf("나이는 : %d", 20);
	}

}//class
