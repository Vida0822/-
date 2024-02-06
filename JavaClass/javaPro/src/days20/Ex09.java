package days20;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오후 3:07:22
 * @subject java.util 패키지
 * @content 	유틸리티 - 자바에서 자주 사용되는 유용한 클래스를 가지고 있는 패키지
 */
public class Ex09 {

	public static void main(String[] args) {
		// int [] -> Integer [] 배열 변환 작업 필요
		// int [] m = {3, 5, 2, 4, 1};
		Integer [] m = {3, 5, 2, 4, 1};
		// Integer [] temp = new Integer[m.length];
		
		Arrays.sort(m); // 오름차순 정렬 ([asc] ascending)
		System.out.println(Arrays.toString(m));
		// 내림차순 정렬해서 출력
		
		/*
		Arrays.sort(m, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		} );
		*/
		
		// Arrays.sort(m, (o2,o1) -> o2 - o1);
		// Arrays.sort(m, (o2,o1) -> o2.compareTo(o1));
		Arrays.sort(m, Collections.reverseOrder());
		
		System.out.println(Arrays.toString(m));
		
		/*
		String temp = Arrays.toString(m).replaceAll("\\[|\\]", "");
		System.out.println(temp);
		StringBuffer sb = new StringBuffer(temp);
		sb.reverse();
		System.out.println(sb);
		*/
		
		/*
		int [] temp = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			temp[4-i] = m[i];
		}
		m = temp;
		System.out.println(Arrays.toString(m));
		*/

	}//main

}//class
