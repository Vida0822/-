package days17;

import java.io.IOException;

/**
 * @author ♈ kenik
 * @date 2023. 2. 17. - 오전 10:51:42
 * @subject   오버라이딩( 재정의 함수 )  조건 
 * @content
 *
 */
public class Ex02 {

	public static void main(String[] args) {
		// 질문) void draw() 코딩이 왜 에러 발생했을까요 ?
		//         ㄴ 같은 접근지정자가 없어서 그런가요 ?  80점  X
		/*
		 * 1.  메서드명 동일
		 * 2. 매개변수 타입+갯수  동일
		 * 3. 리턴자료형 동일
		 * 4. 접근지정자는 부모 보다 같거나 범위가 큰 접근지정자를 사용할 수 있다.
		 *     public    -> public 
		 *     default -> default, protected, public  
		 *  5. 예외는 부모의 예외보다 많을 수 없다. ?   
		 *  6. 인스턴스메서드 <-> static 메서드 변경 X
		 * */

	}

}

// 도형클래스 
class Shape{ 
	public String color = "black";   
    public void draw() throws IOException{
		System.out.printf("[color=%s]\n", color);
	}
}

class Point{ 
	int x;
	int y; 
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(){
		this(0,0);  
	} 
	String getXY() {
		return String.format("(%d, %d)", this.x, this.y);
	}
}

class Circle extends Shape{   
	// 필드	
	Point center ;  
	int r;   
	Circle(){
		this(  new Point(0, 0)  ,0);
	}	 
	Circle( Point center , int r){
		this.center = center;
		this.r = r;
	} 
	
	@Override
	 // public void draw() throws IOException, SQLException{
	public void draw() throws IOException{
		System.out.printf("[color=%s, center=(%d, %d)]\n", color, this.center.x, this.center.y);
	}
	
}






