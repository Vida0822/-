package days17;

/**
 * @author ♈ kenik
 * @date 2023. 2. 17. - 오후 2:16:11
 * @subject
 * @content
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		

	}

}

//subclass(자식클래스)를 가질 수 없는 마지막(최종) 클래스
final class P{
	
	// final 메서드 앞에 붙이면 자식 클래스에서 
	// 오버라이딩(재정의)을 할 수 없다.
	final void draw() {
		System.out.println("P.draw() 호출됨.");
	}
	
}

// The type C cannot subclass the final class P
// 
//class C extends P{
	 
	// Cannot override the final method from P
	/*
	@Override
	void draw() {
		System.out.println("C.draw() 오버라이딩(재정의) 호출됨.");
	}
	*/
	
//}








