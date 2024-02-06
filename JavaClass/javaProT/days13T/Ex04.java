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
public class Ex04 {

	public static void main(String[] args) {
		// 정렬 - 버블정렬, 선택정렬,                     병합정렬, 삽입정렬 X , 쉘정렬, 힙정렬 X
		// 앞으로 코딩할때 정렬이 필요하다면 Arrays 클래스의 sort() 메서드 사용하자. 
		// Arrays.sort();                배열 정렬
		// Collections.sort();  컬렉션 정렬
		
		// 12:12 수업 시작~ 
		// [순차검색]
		/*
		int [] m = new int[30];
		// 0~20 임의의 정수
		for (int i = 0; i < m.length; i++) {
		     m[i] = (int)( Math.random() *21 ) ;  // 0 ~ 20 
		}
		System.out.println( Arrays.toString( m ) );
		
		() 소괄호
		{} 중괄호
		[] 대괄호
		*/
		int [] m = { 0, 2, 12, 16, 7, 9, 2, 9, 0, 13, 7, 13, 3, 14, 10, 15, 11, 6, 19, 5, 2, 0, 16, 18, 15, 18, 0, 9, 13, 16 };
		System.out.println( Arrays.toString( m ) );
        Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 배열에서 찾을 정수 입력 ? ");
		int n = scanner.nextInt();
		
		// [문제]  m 배열 속에서 찾을 n의 모든 위치(index)을 출력하는 코딩을 하세요. 
	    int [] result = sequenceSearch(  m, n );
	    System.out.println(  Arrays.toString( result )   );
	    for (int i = 0; i < result.length  && result[i] != -1; i++) { 
			 // if( result[i] == -1 ) break;
			 System.out.println( result[i]  + " 위치에 있습니다."); 
		}
		
		/*
		// 순차검색(sequenceSearch)해서 찾은 위치를 반환하는 함수(메서드)를 선언
		// 1. 기능
		// 2. 매개변수 : int [] ,        int
		// 3. 리턴값(리턴자료형) : 찾은 위치,          못찾으면 -1 
		int index = sequenceSearch(  m, n );
		if ( index == -1 ) {
			System.out.println("찾는 정수는 없습니다.");
		} else {
			System.out.println( index  + " 위치에 있습니다.");
		}
		*/
		
	}  // main
	
	// 오버로딩(중복함수) X
	// 리턴자료형 X
	// 매개변수 갯수, 타입 O
	// [단점] 찾은 위치 -> 활용.
	
	//  리턴자료형을 int [] 선언.
	 private static int [] sequenceSearch(int[] m, int n) {
		    // 0, 8, 21, 26
		   int [] sm = new int[ m.length ]; // [-1][-1]...[-1]
		   Arrays.fill(sm, -1); 
		  
		    int index = 0;
			for (int i = 0; i < m.length; i++) {
				if( m[i] == n ) {
					 sm[index++] = i; 
				}
			}		
			return sm;
		}
	 
	/*
    private static void sequenceSearch(int[] m, int n) {
		boolean flag = false;
		for (int i = 0; i < m.length; i++) {
			if( m[i] == n ) {
				flag = true;
				System.out.println( i  + " 위치에 있습니다.");
			}
		}
		
		if (!flag) {
			System.out.println("찾는 정수는 없습니다.");
		}		
	}
	*/

    /*
	private static int sequenceSearch(int[] m, int n) {
		
		for (int i = 0; i < m.length; i++) {
			if( m[i] == n )  return i;   // 찾은 위치(index)을 반환.
		}
		
		return -1;  // 못 찾았다.( n이  없다 )
	}
	*/

}  // class









