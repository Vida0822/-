package days07;

/**
 * @author dlsgu
 * @date 2023. 2. 3. 오후 4:09:23
 * @subject
 * @content
 */
public class Ex05 {

	public static void main(String[] args) {
		// 1. 두 정수를 입력받아서 max, min
		// 2. 세 정수를 입력받아서 max, min 구해서 출력
		int x, y, z;
		x = (int)(Math.random()*101);
		y = (int)(Math.random()*101);
		z = (int)(Math.random()*101);

		System.out.printf("> x=%d, y=%d, z=%d\n", x, y, z);
		// x=71, y=3, z=83
		// 1) 두 정수를 먼저 비교해서 큰/작은값 찾아서
		// 2) 찾은 값하고 남은 하나의 값과 비교해서 큰/작은 값 찾기
		int max, min;

		/*
		if (x>y) {
			max = x;
		} else {
			max = y;
		}

		if (max<z) {
			max = z;
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


		//삼항연산자의 항으로 삼항연산자를 중첩해서 사용할 수 있다
		max = x > y ? (  x > z ? x : z  )   :  ( y > z ? y : z ) ;
		min = x > y ? (y>z ? z : y) : (x>z ? z : x);

		System.out.printf("max = %d, min = %d\n" ,  max , min);

	}//main

}//class
