package days24;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 3:27:44
 * @subject 
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// 큐( Queue ) - FIFO 구조
		// 인터페이스
		Queue q = new LinkedList() ;
		// LinkedList q = new LinkedList() ;
		// []-[]-[]-[]
		// 큐
		q.offer("박진용");
		q.offer("진예림");
		q.offer("김예지");
		q.offer("김수민");		
		System.out.println(   q   );
		
		// q.get(0)  X
		/*
		// String name =  (String) q.poll(); // 큐에서 삭제하고 가져오는 메서드 
		String name =  (String) q.peek(); // 큐에서 삭제하지 않고 가져오는 메서드 
		System.out.println( name );
		*/
		
		while (  ! q.isEmpty()  ) {
			 // String name =  (String) q.poll();
			String name = (String) q.remove();
			 System.out.println( name );
		}
		
	 
		

	} // main

} // class










