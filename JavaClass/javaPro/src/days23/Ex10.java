package days23;

import java.util.ArrayList;

/**
 * @author dlsgu
 * @date 2023. 2. 27. 오후 12:49:33
 * @subject ArrayList 컬렉션 클래스
 * @content
 * 			1. 가장 많이 사용되는 컬렉션 클래스
 * 			2. List 인터페이스를 구현한 클래스
 * 				List 특징 : 순서 유지 O, 중복 허용 O
 * 			
 */
public class Ex10 {

	public static void main(String[] args) {
		// <E>
		// E == Elemant == 요소
		// 제네릭(generic) 배우기 전
		// ArrayList list = new ArrayList(10);
		// <? extends E> 의미 몰라요
		ArrayList list = new ArrayList(4);
		// 데이터 추가
		// 1. 기능 : 지정된 요소를 이 리스트(목록)의 끝에 추가하는 메서드
		// 2. 매개변수 : 추가할 모든 타입의 요소
		// 3. 리턴값(리턴자료형) : boolean	요소 추가 성공 true, 실패 false
		// 1. 기능 : 지정된 요소를 이 리스트(목록)의 지정된 위치에 삽입하는 메서드(기존에 있던 요소는 하나씩 뒤로 밀림)
		// 2. 매개변수 : (int 위치값, 추가할 모든 타입의 요소)
		// 3. 리턴값(리턴자료형) : X
		list.add("김수민");
		list.add("김예지");
		list.add("하지예");
		System.out.println(list); // [김수민, 김예지, 하지예]
		
		list.add(1, "박민종"); // IndexOutOfBoundsException 예외 발생 가능
		System.out.println(list); // [김수민, 박민종, 김예지, 하지예]
		
		// ArrayList에 있는 요소(Element)의 갯수
		int count = list.size();
		System.out.println("요소의 수 : " + count);
		
		// [김수민][박민종][김예지][하지예][][][][][][]
		// [김수민][박민종][김예지][하지예] 최소화
		list.trimToSize();
		
		// 배열 단점 : 배열의 크기가 자동으로 증가되지 않는다
		// ArrayList를 사용하면 크기가 자동으로 증가된다 (장점)
		list.add("하동호");
		System.out.println(list); // [김수민, 박민종, 김예지, 하지예, 하동호]
		
		// 목록 안에 "김예지"가 있는지 확인한 후에 삭제
		// 1) 목록 안에 "김예지" 유무 확인
		// 1. 기능 : 지정된 요소가 이 리스트에 포함되는지 확인
		// 2. 매개변수 : 확인할 모든 타입의 요소
		// 3. 리턴값(리턴자료형) : boolean	요소 포함 true, 불포함 false
		System.out.println(list.contains("김예지")); // 	true		false
		System.out.println(list.indexOf("김예지")); // 		2 index		-1
		System.out.println(list.lastIndexOf("김예지")); // 	2 index		-1
		// 2) 목록에서 제거
		// list.remove(index); // 1. 기능 : index 위치의 요소를 삭제(제거) 2. 매개변수 : 삭제할 인덱스값 3. 리턴값 : 삭제된 요소
		// list.remove("김예지"); // 1. 기능 : 첫번쨰 object 요소를 삭제(제거) 2. 매개변수 : 삭제할 요소 3. 리턴값 : boolean 삭제할 요소가 있으면 true, 없으면 false
		// System.out.println(list.remove(2));
		// System.out.println(list.remove("김예지"));
		/*
		if (list.contains("김예지")) {
			list.remove("김예지");
		}
		*/
		/*
		int index = list.indexOf("김예지");
		if (index != -1) {
			list.remove(index);
		}
		System.out.println(list);
		*/
		
		// [김수민, 박민종, 김예지, 하지예, 하동호]
		// [문제] "박민종"을 찾아서 목록 안에 있으면 이민종으로 변경(수정)해서 목록 출력
		// 1. 검색
		int index = list.indexOf("박민종");
		// 2. 변경(요소)
		if (index != -1) {
			System.out.println("변경 전 이름 : " + list.set(index, "이민종"));
		}
		System.out.println(list);
		
		list.clear(); // 모든 요소를 제거
		System.out.println(list.size());
		
	}//main

}//class
