package days19;

/**
 * @author dlsgu
 * @date 2023. 2. 21. 오전 9:43:37
 * @subject
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		
		// [예외 발생시키기]
		// 개발자가 고의로 예외를 발생시킬 수 있다
		// throw문 사용
		// 형식 : throw new 발생시킬예외객체();
		
		// 1. throw new RuntimeException();
		// 컴파일러가 예외처리를 확인하지 않는 RuntimeExceprion 클래스들을 "unchecked 예외"
		
		// Unhandled exception type Exception
		// 2. throw new Exception();
		// 컴파일러가 예외처리를 확인하는 Exception 클래스들을 "checked 예외"
		
		/*
		IA obj1 = new X();
		IA obj2 = new IA() {

			@Override
			public void disp() {				
			}
			
		}
		*/
	}//main

}//class

/*
interface IA {
	void disp();
}

class X implements IA {
	@Override
	public void disp() {
		System.out.println("TEST");
	}
}
*/

/*
1. 참조변수에는 객체를 생성해야 그 주소값을 담을 수 있다

참조변수
int [] m = new int[10];
Person p = new Person();

2. 추상클래스 및 인터페이스는 객체를 생성할 수 없다

A obj = new A(); -> 불가능
  객체
  
추상클래스
abstract class A {
	int a;
	int b;
	abstract void disp();
}
인터페이스 (일종의 추상클래스)
interface B {
	final int c;
	void test();
}

3. 추상클래스 타입 객체에는 자손클래스에서 구현해 생성한 인스턴스만 가능하다

A obj = new B(); // 변수, 지역변수, 참조변수, [객체명]
int [] m; // 변수, 지역변수, 참조변수, [배열명]
abstract class A {}
class B extends A {}
*/