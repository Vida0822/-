package days13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ♈ kenik
 * @date 2023. 2. 13. - 오후 2:13:46
 * @subject   배열 + 제어문 실습 예제
 * @content  *** 클래스 이론 수업 ***
 *                      검색
 *                      1) 순차검색
 *                      2) 이진검색(바이너리검색)
 */
public class Ex05 {

	public static void main(String[] args) {
		 // int Arrays.binarySearch( m, n)
		/*
		int [] m = new int[50];		
		int idx = 0;
		while( idx < m.length ) {
			int n = (int)( Math.random()*200); // 0~199
			if(  ! isDuplicateM(m, n, idx)   ) {
				m[idx++] = n;
			}
		} 
		Arrays.sort(m);  // 배열 정렬
		*/
		
		// 이진검색 필수 조건 : 정렬( 오름차순 정렬 )
		int [] m = { 0, 4, 5, 15, 20, 21, 22, 24, 25, 28, 29, 30, 32, 33, 40, 43, 46, 47, 48, 58, 62, 63, 71, 76, 
		   		 86, 91, 94, 99, 111, 116, 128, 135, 137, 139, 142, 145, 146, 150, 151, 160, 161, 166, 168, 
				 169, 172, 181, 184, 185, 191, 198 };
		System.out.println(   Arrays.toString(m)   );
		
		Scanner scanner = new Scanner(System.in);
			
		System.out.print("> 배열에서 찾을 정수 입력 ? ");
		int n = scanner.nextInt();
		
		int index =  binarySearch( m , n );
	
		if ( index == -1 ) {
			System.out.println("찾는 정수는 없습니다.");
		} else {
			System.out.println( index  + " 위치에 있습니다.");
		}

	} // main
	
	private static int binarySearch(int[] m, int n) {
		/*  2:48 풀이~~~ 
		 1. 배열의  bot/top 변수 저장
		 2. mid = (bot+top)/2
		 3. 
		               n== m[mid]   같으면 찾았기에  return mid
		               n   >  m[mid]  새로운 bot = mid +1
		               n   <  m[mid]  새로운 top = mid - 1
		  4.   위의 3번 코딩을 반복문을 사용해서 반복하다..    bot > top 이럴 때는 반복문을 빠져나와야 겠따.             
		 */
		int bot = 0, top = m.length-1 , mid;
		int count = 0;
		while( bot <= top) {
			mid = (bot+top)/2; 
			count++;
			if( n== m[mid]) 
			{
				System.out.println("> 찾은 횟수: "+ count);
				return mid;
			}
			else if(n   >  m[mid]) bot = mid +1;
			else if(n   <  m[mid]) top = mid - 1;
		}
		System.out.println("> 못 찾은 횟수: "+ count);
		return -1;
	}

	// 중복이 되면 true를 반환하는 메서드 
	public static boolean isDuplicateM(  int [] m, int n, int index ){
		for(int i=0; i< index ; i++){
			if(   m[i] == n  ) return  true;
		}
		return false;
	} 

} // class




