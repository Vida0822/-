package days03;

/**
 * @author kenik
 * @date 2023. 1. 30. - 오후 3:32:43
 * @subject   형변환 예제
 * @content  래퍼 클래스 ?  기본형을 사용하기 쉽도록 포장(가공)해 놓은 클래스
 *                                                                                   구현해 
 *                       Integer.MAX_VALUE                                                                                   
 *                       Integer.MIN_VALUE                                                                                   
 *                       함수( 메서드 )
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// int i = 2147483647;
		// 기본형 -> 래퍼(Wrapper)클래스
		//   int   ->  Integer 클래스
		int i = Integer.MAX_VALUE;		
        int j = 100;		
		// long j =100;
        
		// int k = i +  j; 
		// long k = i +  j;
		long k = (long)i + j;
		// long k = i + j;
		
		// i  = [][][][]
		// j  = [][][][]
		// k = [][][][]   int 표현할 수 있는 값의 범위 벗어난다.    [산술오버플로우]     
		
		System.out.printf("%d + %d = %d\n", i, j, k);
		// 2147483647 + 100 = -2147483549		

		// float f = 3.14;
		//   float f = (float)3.14;
		//   float f = 3.14f;
		
		/*
		3.14f
		하신것처럼하면
		강제형변환이 안되나요?
		*/
	} // main

} // class














