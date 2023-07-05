package days15;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 15. - 오후 4:24:49
 * @subject     객체 복사(copy)와 객체 복제(clone)
 * @content                                            ㄴ 얉은 복제/깊은 복제  ?
 */
public class Ex07 {

	public static void main(String[] args) {
		
		MyPoint  p1 = new MyPoint(10, 20);
		// 객체 복사
		MyPoint p2 = p1;		
		test(   p1  );
		
		// 원래 객체는 유지시키고  테스트 / ~ 
		// p1 객체 복제( clone )
		MyPoint p3 = new MyPoint( p1.x,  p1.y );

	} // main
	
	public static void test( MyPoint p) {  // 객체 복사..
		
	}

} // class
