package days20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 22. - 오후 3:07:09
 * @subject    java.util 패키지  - [ Arrays 클래스 ]
 * @content          유틸리티 -   자바에서 자주 사용되는 유용한 클래스를 가지고 있는 패키지.
 */
public class Ex09 {

	public static void main(String[] args) {
		//  int [] -> Integer [] 배열 변환.. 
		// int [] m = { 3,5,2,4,1 };
		Integer [] m = { 3,5,2,4,1 };		
		// Integer [] temp = new Integer[ m.length];
		
		Arrays.sort( m );  // 오름차순 정렬 ( [asc] ending )
		System.out.println( Arrays.toString( m )  );  // "[1, 2, 3, 4, 5]"
		// 내림차순 정렬해서 출력.
		
		/*
		Arrays.sort(  m ,   new Comparator<Integer>() { 
			@Override
			public int compare(Integer o1, Integer o2) { 
				return o2 - o1;
			}
		}  );
		*/
		//                               람다식
		// Arrays.sort(  m ,   ( o1,  o2)  -> o2 - o1  );		
		// Arrays.sort(  m ,   ( o1,  o2)  -> o2.compareTo(o1)  );
		Arrays.sort(  m ,   Collections.reverseOrder()  );
		
		System.out.println( Arrays.toString( m )  ); 
		
		/*
		String temp =  Arrays.toString( m ).replaceAll("\\[|\\]", "");
		System.out.println(temp); //  "1, 2, 3, 4, 5"
		StringBuffer sb = new StringBuffer(temp);
		sb.reverse();
		System.out.println(sb );
		*/		
		/*
		int [] temp = new int[m.length];
		
		for (int i = 0; i < m.length; i++) {
			temp[4-i] = m[i];
		}
		m = temp;
		System.out.println(  Arrays.toString( m ) );
		*/
		
		
		/*
		// [하동호]
		 * 람다와 스트림
		Integer[] m1 = ((IntStream) Arrays.stream(m)).boxed().toArray(Integer[]::new);
	      Arrays.sort(m1,Collections.reverseOrder());
	    // [김수민]  
	      Integer [] m2 = Arrays.stream(m).boxed().toArray(Integer[]::new);
	      Arrays.sort(m2, Collections.reverseOrder());
	      System.out.println(Arrays.toString(m2));  
	    // [윤재민]
	    Integer [] m = { 3, 5, 2, 4, 1 };
	                           T m
         Arrays.sort(m, Collections.reverseOrder());   
	   */
		
	 
		
		
		

	} // main

} // class
