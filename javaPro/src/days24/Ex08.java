package days24;

import java.util.HashSet;
import java.util.Iterator;

import days15.Person;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 4:38:56
 * @subject    List -> [ ArrayList ], Vector, LinkedList, Stack, PriorityQueue,   (Queue, Deque 인터페이스)
 * @content    Set -> 특징   중복허용X, 순서 유지 X
 *                                 가장 대표적인 컬렉션 클래스 : HashSet
 */
public class Ex08 {

	public static void main(String[] args) {
		// HashSet<int>  hs = new HashSet<int>();
		HashSet<Integer>   hs = new HashSet<Integer>();
		hs.add(9);
		hs.add(1);
		hs.add(15);
		hs.add(20);
		System.out.println( hs.add(1) );  // false
		hs.add(1);
		hs.add(1);
		
		System.out.println( hs.size()  );  // 4
		
		// hs.add("홍길동");
		Iterator<Integer> ir =  hs.iterator();
		while (ir.hasNext()) {
			int i = ir.next();
			System.out.println( i );
		}
		
		hs.remove(20);
		
		System.out.println(  hs );
		
		
		
		

	} // main

} // class

