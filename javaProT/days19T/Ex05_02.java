package days19;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오후 2:04:15
 * @subject    Object 클래스의  메서드 
 * @content 
 */
public class Ex05_02 {

	public static void main(String[] args) {
		// 5.  Object.clone()  복제      오버라이딩~ 
		Point  p1 = new Point(10, 20);
		// p1을 복제해서 p2 생성
		// 복제(clone) 의미 ? 같은 값을 가지는 새로운 인스턴스 생성... 
		// Point p2 = new Point( p1.x, p1.y );  // 복제하는 코딩.
		
		/*
		// Object -> Point 클래스로 다운캐스팅..
		// [4] 단계
		try {
			// [3] 단계
			Point p2 = (Point) p1.clone();
		} catch (CloneNotSupportedException e) { 
			e.printStackTrace();
		}
		*/
		
		Point p2 = p1.clone();
		
		// Object 클래스의 메서드 
		// wait() 3개 - 스레드 
		// notify() - 스레드 
		// notifyAll() - 스레드 
		
	} // main

} // class










