package days17;

/**
 * @author ♈ kenik
 * @date 2023. 2. 17. - 오후 3:11:01
 * @subject    업캐스팅( UpCastring) / 다운캐스팅( DownCasting) 설명
 * @content
 *                             A  부모클래스
 *                             B   자식클래스
 *                             C   손자클래스
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		// 왜 ? 질문
		// A obj =  new A();
		// B obj =  new B();
		// C obj =  new C();
		// 답 : 다형성..
		
		/*
		A obj = new A();
		obj.disp();
		*/
		
		/* (질문)
		Regular 객체를 생성해서 basePay는 출력이 되지만 
		Employee 클래스에는 basePay라는 변수가 없는데
		basePay라는 값은 어디에 저장이 되는건가요 ?
		
		실제 객체( Regular)의 dispEmpInfo() 메서드가 호출이 되어져서 그렇습니다. 
		
		*/
		
		// 클래스 간의 형변환 (A,B)
		// 1. 조건 :  상속 관계
		// 2. 업캐스팅 =  자동으로 형변환이 된다.
		
		// A - B - C 상속 계층구조
		A  obj =  new C();  // 업캐스팅
		
		// 다운캐스팅 - 자동되지 않아요.  강제형변환 - cast 연산자
		C  c1 = (C) obj;
		obj.disp();

	}  // main

} //  class

abstract class A{
	abstract void disp() ;
	//{
	//	System.out.println("A");
	//}
}

class B extends A{
	// 부모의 추상 메서드를 오버라이딩(재정의)해서 추상메서드를 구현하면 객체는 생성할 수 있다.
	@Override
	void disp() {
		System.out.println("B - 재정의");
	}
}

class C extends B{
	@Override
	void disp() {
		System.out.println("C - 재정의");
	}
}




