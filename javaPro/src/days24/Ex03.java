package days24;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 1:50:25
 * @subject            ArrayList 컬렉션 클래스
 * @content            Vector 컬렉션 클래스
 *                              [ LinkedList 컬렉션 클래스  ]
 */
public class Ex03 {

	public static void main(String[] args) {
		/*
		 * 1. 배열
		 *       (장점) 읽기 성능이 가장 빠르다.
		 *       (단점) 배열크기 X,
		 *                 삽입, 삭제 무지 속도 느리다.
		 *                 
		 *         메모리상에  동일한 자료형을 연속적으로 놓이게 한 것.
		 *                   
		 * 2. 링크드리스트
		 *       (특징)  비연속적
		 *       
		 *    단방향             환형 링크드리스트
		 *    (더블)양방향   환형  링크드리스트
		 *    
		 *       환형 링크드리스트 
		 * */
		
		Node node1 = new Node();
		node1.value = 10;
		Node node2 = new Node();
		node2.value = 20;
		Node node3 = new Node();
		node3.value = 30;
		Node node4 = new Node();
		node4.value = 40;
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		// [문제] 노드 2와 노드 3 사이에 노드 5를 삽입하는 코딩. 
		Node node5 = new Node();
		node5.value = 50;
		node2.next = node5;
		node5.next = node3;
		// node1 - node2 - node5 - node3 - node4
		
		// [문제] 노드 3을 삭제..
		node5.next = node4;
		
		
		// node1 - node2 - node5 - node4
		//  [문제] 가장 마지막 노드( 노드 4) 를 삭제
		node5.next = null;
		
		// node1 - node2 - node5 - node5
		Node node6 = new Node();
		node6.value  = 60;
		node5.next = node6;
		node6.next = null; 
		
		
		Node node7 = new Node();
		node7.value = 70;
		node7.next =  node1;
		
		Node node = node7;
		
		while( node != null) {
			System.out.println(  node.value );
			node = node.next;
		}

	} // main

} // class



class Node{
	int value; // 값
	Node next  = null; // 다음 노드의 주소값 
	// Node prev  = null; // 이전 노드의 주소값
}



