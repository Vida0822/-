package days13;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오전 11:57:51
 * @subject  검색(Search)  == 탐색
 * @content   - 같은 성질을 갖는 항목의 집합 중에서 특성을 갖는 항목을 찾아내는 것.
 *                      1) 순차 검색( Sequence Search )
 *                      2) 이진검색( binary Search )
 */
public class Ex04_02 {

	public static void main(String[] args) {
	 
		int [] m = { 0, 2, 12, 16, 7, 9, 2, 9, 0, 13, 7, 13, 3, 14, 10, 15, 11, 6, 19, 5, 2, 0, 16, 18, 15, 18, 0, 9, 13, 16 };
		System.out.println( Arrays.toString( m ) );
        Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 배열에서 찾을 정수 입력 ? ");
		int n = scanner.nextInt();
		
		int idx = -1;
		int fromIndex = 0;
		
		while(   (idx =  sequenceSearch(m, n, fromIndex))  !=  -1  ) {
			System.out.println( idx +" 찾았다." );
			fromIndex = idx +1;
		}
		/*
		idx =  sequenceSearch(m, n, fromIndex);
		System.out.println( idx +" 찾았다." );
		
		fromIndex = idx +1;
		idx =  sequenceSearch(m, n, fromIndex);
		System.out.println( idx +" 찾았다." );
		
		fromIndex = idx +1;
		idx =  sequenceSearch(m, n, fromIndex);
		System.out.println( idx +" 찾았다." );
		
		:
		찾은 위치값이  -1 이 될 때까지 반복. 
		*/
			
	   
	    
		
	}  // main
	
	  private static int sequenceSearch(int[] m, int n, int fromIndex) {  
			for (int i = fromIndex; i < m.length; i++) {
				if( m[i] == n )   return i; 
			}		 
			return -1;
	}
	
	 private static int sequenceSearch(int[] m, int n) {  
			for (int i = 0; i < m.length; i++) {
				if( m[i] == n )   return i; 
			}		 
			return -1;
	}
	  

}  // class









