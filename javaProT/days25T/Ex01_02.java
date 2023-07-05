package days25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오전 7:42:39
 * @subject          게임 횟수 입력...
 * @content 
 */
public class Ex01_02 {

	public static void main(String[] args) { 
		// 순서 유지 O +  정렬 X + Set(중복허용 X) => 컬렉션 클래스
		int gameNumber = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 게임 횟수 입력 ? ");
		gameNumber = scanner.nextInt();  // 3
		
		// LinkedHashSet [] lottos = new LinkedHashSet[gameNumber]; 
		ArrayList lottos = new ArrayList(gameNumber );
		
		for (int i = 0; i < gameNumber; i++) {
			LinkedHashSet  lotto = new LinkedHashSet(6 );
			fillLotto( lotto );			
			// lottos.addAll(lotto);  // LinkedHashSet  객체
			lottos.add(lotto);  // LinkedHashSet  객체
		}
		
		// [26, 18, 37, 30, 20, 40, 42, 41, 20, 32, 7, 2, 8, 10, 21, 29, 42, 3]
		// System.out.println( lottos );
		/*
		// dispLotto( lotto );
		*/
		for (int i = 0; i < gameNumber; i++) {
			System.out.printf("%d 게임 : " , i +1 );
			dispLotto(  (LinkedHashSet)lottos.get(i) );  // 다운캐스팅.
		}
		
		
		
	} // main

	private static void dispLotto(HashSet lotto) { // 업캐스팅.
		ArrayList lottoList = new ArrayList( lotto );
		lottoList.sort(null);
		
		// 2. 출력
		 Iterator  ir =  lottoList.iterator();
		 while (ir.hasNext()) {
			int n = (int) ir.next();
			System.out.printf("[%d]", n);
		}
		 System.out.println();
	}

	private static void fillLotto(HashSet lotto) { 
		 while( lotto.size() < 6 ) {
			 int n = (int)(Math.random()*45)+1 ; 
			 lotto.add (   n   );  
		 }
	}
	
} // class










/*
 * 1조_연봉1조          : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
