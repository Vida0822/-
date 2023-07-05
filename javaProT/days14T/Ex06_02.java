package days14;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오후 2:31:34
 * @subject 
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// p1~ p5 수 많은 객체를 다룰 때 -> 객체(클래스) 배열을 사용하면 편리하다.
		// 배열 선언 형식
		// 자료형 [] 배열명 = new 자료형[배열의 크기];
		//  클래스 배열( 객체 배열 )
		Person [] p = new Person[5];  // p 는 객체명이 아니고 배열명이다.
		
		/*
		p[0].name = "홍1";   p[0].run();
		p[1].name = "홍2";   p[1].run();
		p[2].name = "홍3";   p[2].run();
		p[3].name = "홍4";   p[3].run();
		p[4].name = "홍5";   p[4].run();
		*/
		for (int i = 0; i < p.length; i++) {
		    p[i] = new Person(); // ( 기억 )  // NullPointerException
			p[i].name = String.format("홍%d", i+1 );
			p[i].run();
		}
		
		

	} // main

} // class

/*
	// 객체명.필드명,   객체명.메서드명()
	//         0x100번지
	Person p = null;  //        [name][age][walk()][run()]                             [0x100번지] p 객체
	p = new Person(); // 인스턴스 == 객체 생성
	
	p.name = "홍1";   // NullPointerException
	p.run();
*/




