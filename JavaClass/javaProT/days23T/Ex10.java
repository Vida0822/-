package days23;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오후 12:49:29
 * @subject  ArrayList 컬렉션 클래스 
 * @content
 *                      1. 가장 많이 사용되는 컬렉션 클래스
 *                      2. List 인터페이스를 구현한 클래스
 *                          List 특징 : 순서유지 O, 중복 허용 O
 */
public class Ex10 {

	public static void main(String[] args) {
		// <E>
		// E == Element == 요소
		// 제네릭( generics) X
		// ArrayList list = new ArrayList(10);
		//  <? extends E> 의미 몰라요..
		ArrayList list = new ArrayList(4);  // 초기 용량 4로 설정
		
		// 데이터 추가
		// 1. 기능 :  지정된 요소를 이 리스트(목록)의 끝에 추가하는 메서드
		// 2. 매개변수 :  추가할 모든 타입의 요소
		// 3. 리턴값(리턴자료형) : boolean   요소추가 성공 true, 실패 false   boolean
		System.out.println(  list.add("김수민") );
		System.out.println(  list.add("김예지") );
		System.out.println(  list.add("하지예") );		
		System.out.println( list );  // [김수민, 김예지, 하지예]		
		list.add(1 , "박민종");  // IndexOutOfBoundsException
		System.out.println( list );  // [김수민, 박민종, 김예지, 하지예]
		
		// ArrayList에 있는 요소(Element)의 갯수
		int count =  list.size();
		System.out.println( "요소의 수 : "  +  count );
		
		// [김수민][박민종][김예지][하지예][][][][][][]
		// [김수민][박민종][김예지][하지예]  최소화
		list.trimToSize();
		
		// 배열 단점 : 배열의 크기가 자동으로 증가되지 않았다.
		// ArrayList를 사용하면 크기가 자동으로 증가된다. ( 장점 )
		list.add("하동호");
		System.out.println( list );  // [김수민, 박민종, 김예지, 하지예, 하동호]
		
		// 목록 안에 "김예지"씨가  있는지 확인한 후에 삭제..
		// 1) 목록 안에 "김예지" 유무 확인
		//System.out.println(  list.contains("김예지") );         // true             false
		//System.out.println(  list.indexOf("김예지")  );       // 2   index         -1
		//System.out.println(  list.lastIndexOf("김예지") );   // 2  index          -1
		
		// 2) 목록 에서 제거.
		// [김수민, 박민종, 김예지, 하지예, 김예지, 하동호]
		// list.remove(index)  ;  // 1. 기능 : index 위치의 요소를 삭제(제거)  2. 매개변수 : 삭제할 인덱스값
		// 목록이 삭제할 요소를 포함하고 있으면 true,                    false
		//  삭제가 성공하면 true                                 실패하면    false
		// list.remove("김예지");
		/*
		if (   list.contains("김예지")   ) {
			list.remove("김예지");
		}
		*/
		/* 
		int index =  list.indexOf("김예지");
		if (index != -1) {
			list.remove(index);
		}		
		System.out.println(  list );
		*/ 
		// 3:15 수업 시작~
		// [김수민, 박민종, 김예지, 하지예, 하동호]
		// [문제] 박민종 씨를 찾아서 목록 안에 있으면 이민종으로 변경(수정)해서 목록 출력.
		// 1. 검색
		int index = list.indexOf("박민종");
		// 2. 변경( 요소 )
		if (    index != -1) {
		     System.out.println( "변경 전 이름 : " + 	 list.set(index, "이민종")  );	
		}
		// 1. 기능,  2. 매개변수, 3. 리턴값(리턴자료형)
		
		
		list.clear(); // 모든 요소를 제거		
		System.out.println(  list.size() );  // 0
		
		
		
		
		

	} // main

} // class












