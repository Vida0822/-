package days25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 3. 2. - 오전 10:27:13
 * @subject 게임 횟수 입력
 * @content 
 *
 */
public class Ex01_03 {

	public static void main(String[] args) {
		// 순서 유지 O + 정렬 X + Set(중복허용 X) -> 컬렉션 클래스
		int gameNumber = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 게임 횟수 입력 ? ");
		gameNumber = scanner.nextInt(); // 3
		
		// LinkedHashSet [] lottos = new LinkedHashSet[gameNumber];
		ArrayList lottos = new ArrayList(gameNumber);
		
		for (int i = 0; i < gameNumber; i++) {
			LinkedHashSet lotto = new LinkedHashSet(6);
			fillLotto(lotto);
			// lottos.addAll(lotto); // []
			lottos.add(lotto); // [[][][]] LinkedHashSet 객체
		}
		
		for (int i = 0; i < gameNumber; i++) {
			System.out.printf("%d게임 : ", i+1);
			dispLotto((LinkedHashSet)lottos.get(i)); // 다운캐스팅
		}

	}//main

	private static void dispLotto(HashSet lotto) { // 업캐스팅
		// 정렬
		ArrayList lottoList = new ArrayList(lotto);
		lottoList.sort(null);
		// 출력
		Iterator ir = lottoList.iterator();
		while (ir.hasNext()) {
			int n = (int) ir.next(); // 오토언박싱
			System.out.printf("[%d]", n);
		}
		System.out.println();
	}
	
	private static void fillLotto(HashSet lotto) {
		while (lotto.size() < 6) {
			int n = (int)(Math.random()*45)+1;
			// System.out.println(n);
			lotto.add(n);
		}
		
	}

}//class
