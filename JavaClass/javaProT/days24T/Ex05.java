package days24;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 3:39:53
 * @subject 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// PriorityQueue 컬렉션 클래스
		// Priority(우선권) + 큐 == 저장한 순서에 상관없이 우선 순위가 높은 것 부터 꺼내오는 구조
		//  큐 구조 == FIFO 구조
		Queue q = new PriorityQueue();
		// int 는 우선 순위가 높은 값은 작은값.....
		q.offer(3);
		q.offer(5);
		q.offer(2);
		q.offer(4);
		q.offer(1);
		
		while ( !q.isEmpty()) {
			int n = (int) q.poll();
			System.out.println( n );
		}
		

	} // main

} //class
