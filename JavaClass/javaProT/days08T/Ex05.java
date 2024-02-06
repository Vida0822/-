package days08;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 4:51:39
 * @subject   재귀 호출 함수( recursive  call ) 
 * @content
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		// 재귀 [호출] 함수 ? 함수 안에서 자기 자신을 다시 호출하는 함수를 "재귀 [호출] 함수 "
		disp();  // 함수 호출 부분
		
		// 재귀 함수 사용하는 이유 ?   내일 ~

	} // main
	
	// 예외처리 설명할 때   예외(exception), erorr(에러) 차이점.
	// ~                        [Exception]
	// StackOverflow[Error]
	// 1. 기능 2. 매개변수 3. 리턴값  3가 이해
	public static void disp() {  // 함수 선언 부분
		System.out.println("disp() 메서드 호출됨...");
		
		
		disp();  // 함수 호출 부분
	}

} // class
