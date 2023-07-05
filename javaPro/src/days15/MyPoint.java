package days15;

public class MyPoint {	
	// 필드
	public int x;
	public int y;
	// MyPoint this;
	
	// 디폴트 생성자 
	public MyPoint() {
		System.out.println("> MyPoint 디폴트 생성자 호출됨...");
	}
	public MyPoint(int a) {
		// 필드 초기화
		this.x = a;
		this.y = a;
		System.out.println("> MyPoint 1 생성자 호출됨...");
	}	
	public MyPoint(int x, int b) {
		this(); // 디폴트 생성자.
		// 필드 초기화
		//  The assignment to variable x has no effect
		this.x = x;
		y = b;
		System.out.println("> MyPoint 2 생성자 호출됨...");
	}
	// 메서드
	public void dispMyPoint() {
		System.out.printf("x=%d, y=%d\n", this.x, this.y);
	}

	// 기본형 매개변수 만큼 x,y 좌표값을 이동.
	public MyPoint offsetPoint(int i) {
		x += i;
		y += i;
		return this;
	}
	
	// 참조형( MyPoint클래스 ) 매개변수
	// p2.offsetPoint(  p1  );
	// 질문) 위의 코딩에서 offsetPoint() 메서드를 호출한 객체 누구인가? p1, [p2]
	//          매개변수 :  p1
	public void offsetPoint( MyPoint p ) {   // MyPoint p = p1  객체 복사
		x += p.x;  //  p2.x  = p2.x +  p1.x
		y += p.y;  // p1.y
	}

	public int getX() {
		return x;  // int 기본형 반환타입으로 사용한 예제
	}

	// 두 좌표의 x, y 합을 구해서 새로운 좌표를 생성해서 반환하는 메서드 
	// 리턴자료형: MyPoint 타입
	// p2.plus( p1 );
	public MyPoint plus(MyPoint p) {
		int xValue =  x + p.x;
		int yValue =  y + p.y;
		
		MyPoint newp = new MyPoint();
		newp.x = xValue;
		newp.y = yValue;
		
		return newp;
	}
	
	public MyPoint test(MyPoint p) {
		System.out.println("test() 호출됨.");
		return p;
	}

}
