package days19;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오전 9:43:02
 * @subject 
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		 // 10:05 수업 시작~ 
		 //[ 예외 발생시키기]
		 //   - 개발자가 고의로 예외를 발생시킬 수 있다.
		 //   왜 ? 국어점 수 입력 받아서 성적 처리 ... 
		 //             111                예외발생 X -> 강제로 예외 발생시켜서 -> 예외 처리.
		 //   - throw 문 사용
		
		  //   형식 : throw  new 발생시킬예외객체();
		  
		
		 //1. throw new RuntimeException();
		//컴파일러가 예외처리를 확인하지 않는  RuntimeException 클래스들을  "unchecked 예외"
		
		// Unhandled exception type Exception
		// 2. throw new Exception();
		//컴파일러가 예외처리를 확인하는 Exception 클래스들을  "checked 예외"
		
	} // main

} // class
 




