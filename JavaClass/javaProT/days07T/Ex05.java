package days07;

import java.util.Iterator;

/**
 * @author kenik
 * @date 2023. 2. 3. - 오후 4:06:58
 * @subject    5시 까지 수업 
 * @content   10분 휴식

1조 : 이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범                 (화요일)
2조 : 박진용(*), 이혜진(*), 하동호(*), 김수민, 신희민, 진예림, 박현주                     (수요일)
3조 : 박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁              (목요일)
       팀  + 카톡방
       팀장
       팀명
       각자 소개..                
 */
public class Ex05 {

	public static void main(String[] args) {
		// 1. 두 정수를 입력받아서 max, min
		// 2. 세 정수를 입력받아서  max, min 구해서 출력...
		int x , y, z ;
		x =  (int)(Math.random()*101) ;
		y =  (int)(Math.random()*101) ;
		z =  (int)(Math.random()*101) ;

		System.out.printf("x=%d, y=%d, z=%d\n", x,y,z);
		//  x=71, y=3, z=83
		// 1)  두 정수를 먼저 비교해서 큰/작은값 찾아서
		// 2) 찾은값하고 남은 하나의 값과 비교해서 큰/작은 값..
		int max , min ;
		/*
		 if (  x > y  ) {
			max = x;
		} else {
			max = y;
		}

		 if( max > z ) {
			 max = max;
		 }else {
			 max = z ;
		 }
		 */

		/*
		 if (  x > y  ) {
				if( x > z ) {
					// x
				}else {
					// z
				}
		} else {
				// y
			  if( y > z ) {
				   // y
			  }else {
				  // z
			  }
		}
		 */

		/*
		if (  x > y  ) {
			max = x;
		} else {
			max = y;
		}

		if( max < z ) { 
			max = z ;
		}
		*/
		
		// 삼항 연산자. 의 항으로 삼항연산자를 중첩해서 사용할 수 있다. 
		max =   x > y ? (  x > z ? x : z  )   :  ( y > z ? y : z ) ;
		min =   x > y ? ( y > z ? z : y  ) : ( x > z ?  z : x );
		
		System.out.printf("max = %d, min = %d\n" ,  max , min);
		
		// Ex05_02.java


	} // main

} // class








