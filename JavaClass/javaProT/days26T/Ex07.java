package days26;

import java.util.ArrayList;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 2:29:08
 * @subject  
 * @content
 *
 */
public class Ex07 {

	public static void main(String[] args) {
		/* [ 제네릭( Generics ) ]
		 *  1. JDK 1.5 추가 
		 *     JDK 1.8 추가 - 람다식.
		 *  2. 제네릭이란 ?  다양한 타입의 객체를 다루는 메서드 , 컬렉션 클래스 에서....
		 *                           컴파일 시의  타입(자료형) 체크를 해주는 기능.    
		 *  3. 제네릭의 장점
		 *      1) 타입의 안정성을 제공
		 *      2) 타입 체크와 형변환을 생략할 수 있다.( 코드가 간결해진다.)       
		 *                     
		 * */  

		/*
		ArrayList list = new ArrayList();
		list.add("홍길동") ;  // String
		list.add(20);           // int
		list.add( true );     // boolean
		list.add( 'A');           // char
		

        String name = 	 (String) list.get(0);  // "홍길동"
	    System.out.println(  name );
	    
	    int age = (int) list.get(1);
	    System.out.println( age );
	    */
		
		ArrayList<Integer>  list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		// list.add("Hong");     1) 장점 : 타입의 안정성 제공
		
		
		int age = list.get(0);  //  2) 장점 : 형변환 X
		System.out.println( age);
		
	} // main

} // class










