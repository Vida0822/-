package days24;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 3:46:17
 * @subject    Deque == [D]ouble [E]nded [Que]ue
 * @content   양쪽 끝에서 추가/추출이 가능한   큐 구조 
 */
public class Ex04_03 {

	public static void main(String[] args) {
		/*
		 *   큐(Queue)구조 == FIFO 구조
		 *       -------------------------
		 *   ->                                   C   B    A     ->
		 *   <-                                                       <-
		 *      -------------------------
		 *   
		 * */ 
		 Deque  dq   = new LinkedList();
		 
		 dq.offerFirst("홍길동");
		 dq.offerLast("홍길동");
		 
		 dq.pollFirst();
		 dq.pollLast();
		 

	}

}
