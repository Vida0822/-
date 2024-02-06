package days16;

/**
 * @author dlsgu
 * @date 2023. 2. 16. 오후 3:39:25
 * @subject
 * @content
 */
public class Ex08 {

	public static void main(String[] args) {
		/*
		 * [클래스들 간의 관계]
		 * 1. has-a
		 * 2. is-a 관계 (상속 관계)
		 * 
		 * 
		 * [상속(inheritance)]
		 * 1. 상속 : 기존 클래스를 재사용하여 새로운 클래스를 작성(선언)하는 것
		 * 2. 장점 : 코드 재사용, 코딩의 양이 적다 -> 생산성 향상, 유지보수 용이
		 * 3. 상속 선언 형식
		 * 	- extends(연장하다, 확장하다, 넓히다) 키워드 사용
		 * 													[Super 키워드] - 부모 클래스를 나타낸다
		 * 									Sub 클래스		 Super 클래스
		 * 									자식 클래스	 	 부모 클래스
		 * 									파생 클래스		 기초 클래스
		 * 									하위 클래스		 상위 클래스
		 * 	[점근지정자] [기타제어자] class 클래스명 extends 기존 클래스 {
		 * 
		 * 	}
		 * 
		 * 4. 예시
		 * 	좌표 관리하는 클래스 선언 -> 사용
		 * 	기존 클래스					클래스 선언
		 * 	Point2D 클래스		->		Point3D 클래스
		 * 	x, y						x,y,z
		 * */
		
		Point3D p1 = new Point3D();
		

	}//main

}//class
