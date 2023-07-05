package days24;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 3:52:31
 * @subject    열거자(Enumeration)  인터페이스 
 * @content    반복자(Iterator)           인터페이스 
 *                       (차이점)
 *                       컬렉션의 요소에 접근해서 가져오는 객체
 *                       4:05 수업 시작~ 
 *                       
 *                       ListIterator : Iterator에 양방향 조회기능 추가된 반복자.( List 구현한 클래스 에만 사용 가능 )
 */
public class Ex06 {

	public static void main(String[] args) {
		Vector  v = new Vector();
		v.add("박진용");
		v.add("진예림");
		v.add("김예지");
		v.add("이혜진");
		
		// [양방향 반복자]
		ListIterator  ir = v.listIterator();
		
		while (ir.hasNext()) {
			String name = (String) ir.next();
			System.out.println(name );
		}
		System.out.println("> 순 방향으로 진행 완료!!!!");
		
		while (ir.hasPrevious()) {
			String name = (String) ir.previous();
			System.out.println(name );
		}
		System.out.println("> 역 방향으로 진행 완료!!!!");
		/*

		// [차이점] 다른 곳에서 김예지- 수정. 삭제...
		// 1) 열거자( 구 버전 )
		Enumeration  en =  v.elements();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			System.out.println( name );
		}
		
		System.out.println( "-".repeat(40 ));
		
		// 2) 반복자( 신 버전)  예외처리를 통해서 변경된 새로운 요소값을 읽어오도록 처리할 수 있다. 
		Iterator ir = v.iterator();
		while (ir.hasNext()) {
			String name = (String) ir.next();
			System.out.println( name );
			
		}
		*/
		
	} // main

} // class










