package days25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오전 7:42:39
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:45 제출
		// [공지사항] 4/1 부터 대면 수업~
		HashSet lotto = new HashSet(6);
		fillLotto( lotto );
		dispLotto( lotto );
		
	} // main

	private static void dispLotto(HashSet lotto) {
		// 1. 정렬
		// lotto.sort() X
		// ArrayList lottoList = new ArrayList();
		// lottoList.addAll(lotto);
		
		// 11:01 수업 시작~ 
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
		 // Set 인터페이스를 구현한 컬렉션 클래스 : 중복 허용 X, 순서 유지 X
		 while( lotto.size() < 6 ) {
			 int n = (int)(Math.random()*45)+1 ;
			 // System.out.println(  n  );
			 lotto.add (   n   );  
		 }
	}
	
} // class










/*
 * 1조_연봉1조          : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
