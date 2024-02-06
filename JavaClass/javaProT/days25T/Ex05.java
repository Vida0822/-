package days25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오후 12:41:14
 * @subject 
 * @content 
 */
public class Ex05 {

	public static void main(String[] args) {
		// int [] a = {1,2,3,4,5};
		// int [] b = {4,5,6,7,8};		
		// 1) a U b  합집합  1,2,3,4,5,6,7,8
	    ArrayList  a = new ArrayList();
	    a.add(1);a.add(2);a.add(3);a.add(4);a.add(5);
	    
	    ArrayList  b = new ArrayList();
	    b.add(4);b.add(5);b.add(6);b.add(7);b.add(8);
	    
	    System.out.println(a);
	    System.out.println(b);
	    // a - b 차집합
	    
	    HashSet cha = new HashSet();
	    HashSet kyo = new HashSet();
	    Iterator ir = a.iterator(); // [1, 2, 3, 4, 5]
	    while (ir.hasNext()) {
			int  aValue = (int ) ir.next();
			if ( !b.contains(aValue ))  cha.add(aValue);
			else                                    kyo.add(aValue);                
		}
	    System.out.println( "a - b : " +  cha );
	    System.out.println( "a ∩ b : " + kyo ); 
	    /* 합집합 코딩. */
	    HashSet   c = new HashSet();
	    c.addAll(a);
	    c.addAll(b);
	    System.out.println("a U b : " + c );
	     
 
		/*
		int [] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.out.println( Arrays.toString(c ) );
		// [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
		//                      ↑
	   for (int i = 0, idx = a.length; i < b.length; i++) {
		     // c 배열 중복체크    b[i]    X 
	   }
	  */
		
		
	    
		// 2) a - b  차집합  1,2,3
		// 3) a ∩ b 교집합  4,5		

	} // main 

} // class 



