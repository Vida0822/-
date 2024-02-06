package days19;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오전 11:04:28
 * @subject 
 * @content 
 */
public class Ex03_03 {

	public static void main(String[] args) {
	 
			method1(); 

	} // main
	
	private static void method1()   {
		try {
			method2();
		} catch (Exception e) { 
			e.printStackTrace();
		}  // 메서드2를 호출
		System.out.println("> method1() 호출됨..");
	}
	
	// 메서드 선언 + throws 예외1, 예외2...
	private static void method2() throws Exception{
		System.out.println("> method2() 호출됨..");
		
		throw new Exception();  // "checked 예외"
	}

} // class





