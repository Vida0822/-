package days16;

public class Point2D {	 
	// 필드
	public int x;
	public int y; 
	
	// 생성자 상속되지 않는다. 
	public Point2D() {
		System.out.println("> Point2D 디폴트 생성자 호출됨...");
	}
	public Point2D(int a) { 
		this.x = a;
		this.y = a;
		System.out.println("> Point2D 1 생성자 호출됨...");
	}	
	public Point2D(int x, int b) {
		this(); 
		this.x = x;
		y = b;
		System.out.println("> Point2D 2 생성자 호출됨...");
	}
	// 메서드
	public void dispPoint2D() {
		System.out.printf("x=%d, y=%d\n", this.x, this.y);
	}
 
	public Point2D offsetPoint(int i) {
		x += i;
		y += i;
		return this;
	}
	 
	public void offsetPoint( Point2D p ) {   // MyPoint p = p1  객체 복사
		x += p.x;  //  p2.x  = p2.x +  p1.x
		y += p.y;  // p1.y
	}

	public int getX() {
		return x;   
	}
 
	public Point2D plus(Point2D p) {
		int xValue =  x + p.x;
		int yValue =  y + p.y;
		
		Point2D newp = new Point2D();
		newp.x = xValue;
		newp.y = yValue;
		
		return newp;
	}
	
	public Point2D test(Point2D p) {
		System.out.println("test() 호출됨.");
		return p;
	}

}
