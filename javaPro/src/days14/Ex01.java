package days14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오전 7:05:08
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		
		// days14.Ex01                  참조 가능
		//            public   Car
		//                X       Tv
		Car myCar;
		Tv   t1;		
		// days01.Ex01.java 이동
		
		
		// 9:35 제출
		int [] m = { 3,5,2,4,1 };
		
		// max
		// 스트림
		int max =  Arrays.stream(m).max(  ).getAsInt();
		System.out.println( max ); 
		
		/*
		for (int i = 0; i < m.length; i++) {
			System.out.printf("[%d]", m[i]);
		}
		System.out.println();
	    */
		
		// (람다와 스트림)
		// int [] -> IntStream 변환
		// Arrays.stream(m).forEach( System.out::println);
		
		//  -> 람다식
		// Arrays.stream(m).forEach(   i -> System.out.printf("[%d]", i)  );
		   

	} // main

} // class

/*
 * 1조_연봉1조 : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일) 2조_귀염2(이)조
 * : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일) 3조_자바를 잡아 :
 * [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
