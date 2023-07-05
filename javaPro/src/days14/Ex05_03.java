package days14;

public class Ex05_03 {

	public static void main(String[] args) {
		// Ex05_02.java     plus(   m   )    Call By Reference
		//                             plus(   객체  ) Call By Reference
		Point p1 = new Point();
		p1.x = 100;
		
		plus( p1 );  //Call By Reference
		
		System.out.println( p1.x );  // 300

	} // main

	//                                      매개변수  클래스 참조타입
	private static void plus(Point p1) {
		 p1.x += 200;
	}

} // class

class  Point{
	int x ;  // 클래스 안의 필드는 초기화하지 않아도 자료형의 기본값으로 초기화 되어져 있다. 
}

