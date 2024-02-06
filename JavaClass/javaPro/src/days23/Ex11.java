package days23;

import java.util.ArrayList;

/**
 * @author dlsgu
 * @date 2023. 2. 27. 오후 3:33:37
 * @subject
 * @content
 */
public class Ex11 {

	public static void main(String[] args) {
		ArrayList team01 = new ArrayList();
		team01.add("이태규");
		team01.add("김지은");
		team01.add("설경인");
		team01.add("윤재민");
		team01.add("홍성철");
		team01.add("김동현");
		team01.add("박상범");
		
		System.out.println(team01);
		
		ArrayList team02 = new ArrayList();
		team02.add("하동호");
		team02.add("박진용");
		team02.add("이혜진");
		team02.add("김수민");
		team02.add("신희민");
		team02.add("진예림");
		team02.add("박현주");
		
		System.out.println(team02);
		
		// 식별자 명명규칙
		//				 = new ArrayList(Collection c)
		// Employee emp = new SalesMan(); // 업캐스팅
		//									매개변수 다형성
		// ArrayList class5 = new ArrayList(team01);
		
		ArrayList class5 = new ArrayList();
		class5.addAll(team01);
		class5.addAll(team02);
		
		System.out.println(class5); // 1조 + 2조
		
		// class5라는 ArrayList에서 2조원 모두 삭제(제거)
		// class5.removeAll(team02);
		// System.out.println(class5);
		
		// ArrayList의 get() 메서드
		// 1. 기능 : 특정 위치의 요소를 불러오는 함수
		// 2. 매개변수 : int index(위치값)
		// 3. 리턴값(리턴자료형) : Object 특정 위치의 요소
		System.out.println(class5.get(0));
		System.out.println(class5.get(1));
		System.out.println(class5.get(2));
		System.out.println(class5.get(class5.size() -1));

	}//main

}//class
