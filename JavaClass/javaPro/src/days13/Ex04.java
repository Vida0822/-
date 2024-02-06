package days13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오전 11:58:04
 * @subject 검색(Search) == 탐색
 * @content	- 같은 성질을 갖는 항목의 집합 중에서 특성을 갖는 항목을 찾아내는 것
 * 			1) 순차검색 (Sequence Search)
 * 			2) 이진검색 (binary Search)
 */
public class Ex04 {

	public static void main(String[] args) {
		// 정렬 - 버블정렬, 선택정렬 / 병합정렬, 삽입정렬 X (쉘정렬, 힙정렬 X)
		// 앞으로 코딩할 때 정렬이 필요하다면 Arrays 클래스의 sort() 메서드를 사용하자
		// Arrays.sort() -> 베열 정렬
		// Collections.sort() -> 컬렉션 정렬
		
		// [순차검색]
		/*
		int [] m = new int[30];
		// 0~20 임의의 정수
		for (int i = 0; i < m.length; i++) {
			m[i] = (int)(Math.random()*21);
		}
		System.out.println(Arrays.toString(m));
		*/
		int [] m = {5, 11, 20, 13, 1, 5, 20, 1, 15, 1, 2, 8, 9, 17, 3, 8, 4, 9, 20, 2, 15, 14, 19, 9, 9, 12, 5, 19, 8, 9};
		System.out.println(Arrays.toString(m));
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("> 배열에서 찾을 정수 입력 ? ");
		int n = scanner.nextInt();
		
		//[문제] m 배열 속에서 찾을 n의 모든 위치(index)를 출력하는 코딩을 하세요
		int [] result = sequenceSearch(m, n);
		System.out.println(Arrays.toString(result));
		for (int i = 0; i < result.length && result[i] != -1; i++) {
			System.out.println(result[i] + " 위치에 있습니다");
		}
		
		// 순차검색(seqenceSearch)해서 찾은 위치를 반화하는 함수(메서드)를 선언
		// -> 앞에서부터 차례대로 찾아나가는 것
		/*
		int index = sequenceSearch(m,n); // 값 없으면 -1 반환
		if (index == -1) {
			System.out.println("찾는 정수는 없습니다");
		} else {
			System.out.println(index + " 위치에 있습니다");
		}
		*/


	}//main
	
	private static int [] sequenceSearch(int[] m, int n) {
		int [] sm = new int[m.length]; // 0으로 초기화되어있는 상태
		Arrays.fill(sm, -1);
		int index = 0;
		
		for (int i = 0; i < m.length; i++) {
			if (m[i] == n) {
				sm[index++] = i;
			}
		}
		return sm;
	}

	// 출력만 가능 -> 활용 불가
	/*
	private static void sequenceSearch(int[] m, int n) {
		boolean flag = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i] == n) {
				flag = true;
				System.out.println(i + " 위치에 있습니다");
			}
		}
		if (!flag) System.out.println("찾는 정수가 없습니다");
	}
	*/
	
	/*
	private static int sequenceSearch(int[] m, int n) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] == n) return i;
		}
		return -1;
	}
	*/

}//class
