package days25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오후 3:06:14
 * @subject 
 * @content 
 */
public class Ex06_03 {

	public static void main(String[] args) {
		int [] score = { 80, 95, 50, 85, 45, 65, 10, 100 };
		// [범위 검색]
		// 75 점보다 큰 점수를 얻어와서 출력... 
		// 50점 보다 작은 점수를 얻어와서 출력..
		// 50~75 점 범위
		
		/*
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for (int i : score)   	ts.add(i); 
		
		System.out.println( ts );
		*/
		
		// int [] -> ArrayList -> TreeSet 변환.
		// stream() X
		// boxed()  X
		// collect()  X
		// Collectors.toList() X
		ArrayList<Integer> list = 
				(ArrayList<Integer>) Arrays.stream(score).boxed().collect(Collectors.toList());
		// System.out.println( list );
		TreeSet<Integer> ts = new TreeSet<Integer>(list);
		System.out.println( ts );
		// [10, 45, [ 50 ], 65, 80, 85, 95, 100]
		SortedSet<Integer> ss = ts.headSet(50);
		System.out.println( ss );  // [10, 45]
		
		System.out.println( ts.tailSet(75) ); // [80, 85, 95, 100]
		 
       
         

	} // main

} // class
