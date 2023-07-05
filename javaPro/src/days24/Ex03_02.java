package days24;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 2:32:29
 * @subject 
 * @content 
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// LinkedList 컬렉션 클래스
		//  implements List  순서 유지 O, 중복 허용 O, Deque X, Cloneable 복제가능한, java.io.Serializable 직렬화
		LinkedList  list = new LinkedList();
		list.add("김수민");
		list.add("진예림");
		list.add("김동현");
		System.out.println(   list  );
		list.addFirst("박민종");
		System.out.println(   list  );
		list.add(2, "박현주");
		System.out.println(   list  );
		
		// 요소(element) == 노드(node)
		System.out.println(  list.size() );
		
		// 1.  김동현    검색 후   탁인혁으로 수정
		list.contains("김동현");
		list.indexOf("김동현");
		list.lastIndexOf("김동현");
		// list.offer( );		list.peek();		list.push();
		int index = -1;
		if(  ( index = list.indexOf("김동현")) != -1 ) {
			// list.add(index, list); // 삽입
			list.set(index, "탁인혁");
		}		
		System.out.println(   list  );
		
		// 2. 탁인혁 삭제..
		// list.remove(); // first element( node )
		// list.removeLast();
		// list.remove("탁인혁");
		// System.out.println(   list  );
		
		// 반복자를 사용해서 모든 요소(노드) 출력.
		// 3:04 수업 시작
		// Iterator  ir = list.iterator();
		
		Iterator  ir = list.descendingIterator();
		while (ir.hasNext()) {
			String name = (String) ir.next();
			System.out.println( name );
		}

		/*
		 * 1. 순차적으로 추가/삭제하는 경우 :    ArrayList 가 LinkedList 보다 빠르다. 
		 * 2. 중간에     추가/삭제하는 경우 :    LinkedList가 ArrayList 보다 빠르다. 
		 *                                                     ArrayList + 멀티 스레드 => Vector
		 * */

	} // main

} // class








