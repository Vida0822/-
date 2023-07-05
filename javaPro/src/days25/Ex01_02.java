package days25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author dlsgu
 * @date 2023. 3. 2. - 오전 10:27:13
 * @subject 
 * @content 
 *
 */
public class Ex01_02 {

	public static void main(String[] args) {
		
		HashSet lotto = new HashSet(6);
		fillLotto(lotto);
		dispLotto(lotto);

	}//main

	private static void dispLotto(HashSet lotto) {
		// 정렬
		// lotto.sort() X
		// ArrayList lottoList = new ArrayList();
		// lottoList.addAll(lotto);
		ArrayList lottoList = new ArrayList(lotto);
		lottoList.sort(null);
		// 출력
		Iterator ir = lottoList.iterator();
		while (ir.hasNext()) {
			// Integer n = (Integer) ir.next();
			int n = (int) ir.next(); // 오토언박싱
			System.out.printf("[%d]", n);
		}
		System.out.println();
	}
	
	private static void fillLotto(HashSet lotto) {
		// Set 인터페이스를 구현한 컬렉션 클래스 : 중복 허용 X, 순서 유지 X
		while (lotto.size() < 6) {
			// lotto.add((int)Math.random()*45+1);
			int n = (int)(Math.random()*45)+1;
			System.out.println(n);
			lotto.add(n);
		}
		
	}

}//class
