package days20;

import java.util.Objects;
import java.util.Random;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오후 3:52:51
 * @subject java.util 패키지 안에 자주 사용되는 유용한 클래스
 * @content 1) Arrays 클래스
 * 			2) Random 클래스
 * 				Math.random()
 * 			3) Objects 클래스
 * 					ㄴ 모두가 static 메서드이다
 * 					ㄴ 객체를 비교할 때나 null 체크할 때 유용하다
 */
public class Ex11 {

	public static void main(String[] args) {

		Random rnd = new Random();
		// Random rnd = mew Ramdom(long seed);
		// -21억~ rnd.nextInt() ~21억 임의의 정수
		// rnd.nextInt(45) // 0 <= 정수 < 45
		// rnd.nextInt(2)
		// rnd.nextBoolean()
		
		// [Object 클래스]
		Point p1 = null;
		test(p1);

	}//main

	private static void test(Point p) {
		/*
		// p가 null인지 여부 체크
		// 1) if(p != null) {
		// 2) if(Objects.isNull(p)) { // null -> true
		// 3) if (Objects.nonNull(p)) { // !null -> true
				
		}
		*/
		
		Point p2 = new Point(1,2);
		// if(p != null && p.equals(p2)) {
		if (Objects.equals(p, p2)) {
			// 같은 좌표다 출력하는 코딩
		}
		
	}

}//class

class Point implements Cloneable {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	protected Point clone() {
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return (Point)obj;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point)obj;
			if (this.x == p.x && this.y == p.y) return true;
		}
		return false;
	}
	
}
