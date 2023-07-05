package days13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오후 2:13:55
 * @subject 배열 + 제어문 실습 예제
 * @content ***글래스 이론 수업***
 * 			검색
 * 			1) 순차검색
 * 			2) 이진검색(바이너리검색)
 */
public class Ex05 {

	public static void main(String[] args) {
		
		/*
		// int Arrays.binarySearch(m,n)
		int [] m = new int [50];
		int idx = 0;
		while (idx < m.length) {
			int n = (int)(Math.random()*200);
			if (!isDuplicateM(m, n, idx)) {
				m[idx++] = n;
			}
		}
		Arrays.sort(m);
		*/
		
		// 이진검색 필수 조건 : 정렬 (오름차순 정렬)
		int [] m = {3, 9, 16, 17, 22, 25, 34, 35, 47, 51,
					63, 65, 66, 67, 72, 73, 74, 75, 76, 80,
					93, 94, 95, 99, 100, 104, 105, 107, 116, 117,
					124, 127, 128, 139, 140, 142, 145, 148, 154, 156,
					165, 169, 174, 176, 178, 185, 192, 193, 197, 198};
		System.out.println(Arrays.toString(m));
		
		Scanner scanner = new Scanner(System.in);
		
		
		

	}//main
	
	private static int binarySearch(int [] m, int n) {
		/*
		1. 배열의 bot/top 변수 저장
		2. mid = (bot+top)/2
		3. 
			n == m[mid] 같으면 찾았기네 return mid
			n  > m[mid] 새로운 bot = mid+1
			n  < m[mid] 새로운 top = mid-1
		4. 위의 3번 코딩을 반복문을 사용해서 반복한다
		5. bot > top 일 때는 반복문을 빠져나와야한다
		*/
		int bot = 0;
		int top = m.length-1;
		int mid;
		
		while (bot <= top) {
			mid = (bot+top)/2;
			if (n > m[mid]) bot = mid+1;
			else if (n < m[mid]) top = mid-1;
			else return mid;
		}
		return -1;
	}

	// 중복이 되면 true를 반환하는 메서드
	public static boolean isDuplicateM(int[] m, int n, int index) {
	for (int i = 0; i < index; i++) {
		if (m[i] == n) return true ;
	}
	return false;
	}
	
}//class
