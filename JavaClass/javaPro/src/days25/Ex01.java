package days25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 3. 2. - 오전 9:06:40
 * @subject 
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		
		// <E> == (E)lement == 요소
		/*
		ArrayList list = new ArrayList();
		list.add("tiger");
		list.add("cat");
		list.add("Dog");
		list.add("lion");
		*/
		// System.out.println(list);
		// System.out.println(list.toString());
		String [] animals = {"tiger", "cat", "Dog", "lion"};
		List list = Arrays.asList(animals); // ArrayList
		System.out.println(list);
		// 대소문자 구분 X + 내림차순 정렬
		// 클래스 선언 + 객체 생성 -> 익명 클래스
		// DescendingComparator c = new DescendingComparator();
		// list.sort(c);
		/*
		list.sort(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				return -1*s1.toUpperCase().compareTo(s2.toUpperCase());
			}
		});
		*/
		// list.sort((s1, s2) -> -1*((String) s1).toUpperCase().compareTo(((String) s2).toUpperCase()));
		list.sort(String.CASE_INSENSITIVE_ORDER);
		// 반복자 출력
		Iterator ir = list.iterator();
		while (ir.hasNext()) {
			String animal = (String) ir.next();
			System.out.println(animal);
		}
		
	}//main

}//class

class DescendingComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = null;
		if (o1 instanceof String ) {
			s1 = (String) o1;
		}
		String s2 = (String)o2;
		return -1*s1.toUpperCase().compareTo(s2.toUpperCase());
	}
	
}
