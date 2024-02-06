package days19;

/**
 * @author dlsgu
 * @date 2023. 2. 21. 오전 11:04:59
 * @subject
 * @content
 */
public class Ex03_03 {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			e.printStackTrace();
		} //메서드1 호출

	}//main
	
	private static void method1() throws Exception {
		method2(); // 메서드2 호출
		System.out.println("> method1() 호출됨");
	}
	
	// 메서드 선언 + throws 예외1, 예외2
	private static void method2() throws Exception {
		System.out.println("> method2() 호출됨");
		
		throw new Exception(); // "checked 예외" 
	}

}//class
