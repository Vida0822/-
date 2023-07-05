package days24;

import java.util.Stack;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 3:08:20
 * @subject   스택(Stack)과 큐(Queue) 
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		/*
		 * 1. 스택(Stack) : LIFO 구조 ( 마지막 저장된 데이터를 가장 먼저 꺼내는 구조 )
		 *           		---------------
		 *  ->                        C     B    A   |
		 *           		---------------
		 *                        Last In First Out
		 *                        
		 *                        empty()
		 *                        peek()
		 *                        pop()
		 *                        push()
		 *                        
		 *                        search()
		 *                        
		 *  2. 큐(Queue) :  FIFO 구조 ( 처음에 저장된 데이터를 가장 먼저 꺼내는 구조 ) 
		 *                 -------------------
		 *        ->                  C       B       A            ->          
		 *                 -------------------                      
		 *                          First In First Out
		 *                          
		 *             add()
		 *             offer()
		 *             remove()
		 *             poll()
		 *             element()
		 *             peek()             
		 * */ 
		
		// 부모클래스 Vector <- List 인터페이스 <- Collection 인터페이스
		Stack  s = new Stack();
		s.push("박진용");
		s.push("진예림");
		s.push("김예지");
		System.out.println(   s  );
		
		// X s.get(0)
		/*
		String name =  (String) s.pop();
		System.out.println( name );
		name =  (String) s.pop();
		System.out.println( name );
		name =  (String) s.pop();
		System.out.println( name );
		*/
		
		// s.empty()     Stack
		// s.isEmpty()  Vector
		/*
		String name ;
		while( !s.empty() ) {
			name =  (String) s.pop();
			System.out.println( name );
		}
		*/
		
		//  peek() 와 pop() 메서드 차이점
		//     읽어              제거
		String name =  (String) s.peek();
		System.out.println( name );
		name =  (String) s.peek();
		System.out.println( name );
		name =  (String) s.peek();
		System.out.println( name );
		
		System.out.println(   s.size() );
		
		// search() 메서드  1 부터 시작~ 
		System.out.println( s.search("진예림") );
		

		// 편의 점 =   우유 
		// 날짜.. 
	} // main

} // class









