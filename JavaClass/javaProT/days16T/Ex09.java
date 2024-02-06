package days16;

/**
 * @author ♈ kenik
 * @date 2023. 2. 16. - 오후 4:21:20
 * @subject
 * @content
 *
 */
public class Ex09 extends Object{

	public static void main(String[] args) {
		
		// Shape s = new Shape();
		// s.           9개의 메서드 보이더라.        왜? 나의 메서드
		// 사실 :  모든 클래스의 최상위 수퍼클래스는  java.lang.Object 클래스이다.
		// Object 가 가지고 있는 메서드들 공부 먼저 해야 겟네요.. 
		
		Point center = new Point(50, 50);
		int radius = 10;
		Circle c = new Circle( center, radius ) ;
		
		c.color = "red";
		// Shape 부모클래스로 부터 상속받은 draw() 메서드는 color 색만 출력(그리고 있다).
		// Shape 부모클래스로 부터 상속받은 draw() 메서드를 수정해서 사용하고 싶다. 
		//                                                                                  재정의
		// 원의 원점 출력 + 색깔 출력
		// 오버라이딩( override ) == 재정의함수
		// 오버로딩( overload )     == 중복함수
		c.draw();  
		// [color=red] 
		// [color=red, center=(50, 50)]
		
		System.out.println( "-".repeat(30) );  // ------------------------------
		
		Point [] p = {
				new Point(1,1),
				new Point(20,40),
				new Point(10,5)
		};
		Triangle t = new Triangle(p);
		t.draw();

	} // main

} // class

// 도형 클래스 
// 자바는 컴파일러가 자동으로 Object 상속받도록 처리..
//class Shape extends Object{
class Shape{
	// 필드
	String color = "black"; // 명시적 초기화
	// 생성자
	// 메서드
	void draw() {
		System.out.printf("[color=%s]\n", color);
	}
}

class Point{
	// 필드
	int x;
	int y;
	// 생성자
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(){
		this(0,0);  // 또 다른 생성자를 호출하는 this
	}
	// 메서드
	String getXY() {
		return String.format("(%d, %d)", this.x, this.y);
	}
	
}

// 도형 : 원, 삼각형, 사각형, 마름모 등등 
/*
class Circle{
	// 필드	
	int x;// 원점
	int y;	
	int r;   // radius// 반지름
	
	// 생성자
	Circle(){
		this(0,0,0);
	}
	Circle(int x, int y, int r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
}
*/
class Circle extends Shape{   // is-a 관계
	// 필드	
	Point center ; // 원점             // has-a 관계
	int r;   // radius// 반지름
	
	// 생성자
	Circle(){
		this(  new Point(0, 0)  ,0);
	}
	
	// 원점을 생성자를 통해서 의존성 주입( DI )
	Circle( Point center , int r){
		this.center = center;
		this.r = r;
	}

	// @Override  재정의함수             Annotation ( 애노테이션 )
	@Override
	void draw() {
		System.out.printf("[color=%s, center=(%d, %d)]\n", color, this.center.x, this.center.y);
	}
	
}

// 삼각형 클래스 
// 한 평면상에 있고 일직선상에는 없는 3개의 점 A, B, C를 2개씩 쌍으로 하여 선분을 연결하여 이루어지는 도형.
class Triangle extends Shape{
	// 필드
	// 꼭짓점 3개
	Point [] p = new Point[3]; // 배열
	
	Triangle(  Point [] p  ) {
		this.p = p;
	}

	// 삼각형을 그려주는 함수를 부모로 부터 물려받아서 재정의 함수. == 오버라이딩( override )
	@Override
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s]\n"
				,  p[0].getXY(),  p[1].getXY(),  p[2].getXY());
	}
	
}

// 상속관계 (   is-a 관계 )
// 삼각형은 도형이다.
// 원은 도형이다.




