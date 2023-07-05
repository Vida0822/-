package days25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author dlsgu
 * @date 2023. 3. 2. - 오후 12:41:25
 * @subject 
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		// int [] a = {1,2,3,4,5};
		// int [] b = {4,5,6,7,8};
		
		ArrayList a = new ArrayList();
		a.add(1); a.add(2); a.add(3); a.add(4); a.add(5);
		
		ArrayList b = new ArrayList();
		b.add(4); b.add(5); b.add(6); b.add(7); b.add(8);
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		// 1) a u b 합집합 -> {1,2,3,4,5,6,7,8}
		HashSet hap = new HashSet();
		hap.addAll(a);
		hap.addAll(b);
		System.out.println("a u b : " + hap);
		
		/*
		int [] c = new int[a.length+b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.out.println(Arrays.toString(c));
		// [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
		for (int i = 0, idx = a.length; i < b.length; i++) {
			// c 배열 중복체크 b[i]
		}
		*/
		// 2) a - b 차집합 -> {1,2,3}
		// 3) a n b 교집합 -> {4,5}
		HashSet cha = new HashSet();
		HashSet kyo = new HashSet();
		Iterator ir = a.iterator();
		while (ir.hasNext()) {
			int aValue = (int) ir.next();
			if (!b.contains(aValue)) cha.add(aValue);
			else kyo.add(aValue);
		}
		System.out.println("a - b : " + cha);
		System.out.println("a n b : " + kyo);

	}//main

}//class
