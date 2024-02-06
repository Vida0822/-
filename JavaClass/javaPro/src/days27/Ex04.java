package days27;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오전 10:43:01
 * @subject 어노테이션(Annotation)
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		/*
		 * [어노테이션(Annotation)]
		 * - 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것을 "어노테이션"이라고 한다
		 * - 어노테이션 뜻 : 주석, 메모
		 * - 형식 : @어노테이션명
		 * - 자바 주석 처리		//		/* ~ */		/** 소스코드의 주석으로부터 javadoc.exe 툴을 사용해서 html 문서 생성 ~ */
		/* - JDK에 제공하는 표준 어노테이션(주로 컴파일러)
		 * - [표준 어노테이션 종류]
		 * 	1) @Override : 컴파일러에게 오버라이딩한 메서드라는 것을 알려주는 어노테이션
		 * 	2) @SuppressWarnings : 컴파일러의 특정 경고메시지가 나타나지 않게 붙이는 어노테이션
		 * 	3) @Deprecated : 앞으로 사용하지 않는 것을 나타내는 어노테이션
		 * 	4) @FunctionInterface : 함수형 인터페이스라는 것을 알리는 어노테이션 -> 람다식
		 * 	5) @SafeVarargs : 제네릭 타입의 가변인자에 사용하는 어노테이션
		 * 	6) @Native : native메서드에서 참조되는 상수 앞에 붙인다
		 * 				 C언어 메서드
		 * 
		 * [어노테이션을 만들 때 사용되는 어노테이션]
		 * 	7) @Target : 어노테이션이 적용가능한 대상을 지정할 때 사용하는 어노테이션
		 * 	8) @Documented
		 * 	9) @Inherited
		 * 	10) @Retention
		 * 	11) @Repeatable
		 * 
		 * 	** 다른 라이브러리
		 * 
		 * */

		// The value of the local variable scanner is not used
		// Resource leak: 'scanner' is never closed
		@SuppressWarnings({ "unused", "resource" })
		Scanner scanner = new Scanner(System.in);
		
		// The constructor Date(int, int, int) is deprecated
		Date d = new Date(2023-1900, 3-1, 6);
		
		// 스레드 구현 2가지 방법
		// Runnable
		
		/*
	    @SafeVarargs
	    @SuppressWarnings("varargs")
	    public static <T> List<T> asList(T... a) {
	        return new ArrayList<>(a);
	    }
	    */

	}//main

	// 다른 프로그램 == 컴파일러
	@Override
	public String toString() {
		return "[Ex04]";
	}
	
}//class
/*
// 함수형 인터페이스
@FunctionalInterface
interface Runnable {
    public abstract void run();
}
*/