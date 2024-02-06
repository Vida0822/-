package days06;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 2. - 오후 4:24:59
 * @subject 
 * @content 
 * 10.  두 정수 n, m을 입력받아서 
      두 정수 사이의 합을 구해서 출력
      예) 입력형식)
                                두 정수 입력 ? 3 5 엔터
           출력형식)       
                                3+4+5=12
 */
public class Ex05 {

	public static void main(String[] args) {
		// (1) 두 정수 입력
		int n, m;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 정수 n, m 입력 ? ");
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		// (2) for/while sum ~
		// 문제점) n > m 이면 sum = 0 도출
		// 문제해결)
		// 1. 초기식: int i = 작은값
		// 2. 조건식: i <= 큰값
		int sum = 0;
		/*
		if (n < m) {
			for (int i = n; i <= m; i++) {
				System.out.printf("%d+", i);
				sum += i;
			}//for
		} else {
			for (int i = m; i <= n; i++) {
				System.out.printf("%d+", i);
				sum += i;
			}//for
		}//if
		*/
		
		/*
		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}
		for (int i = m; i <= n; i++) {
			System.out.printf("%d+", i);
			sum += i;
			}
		*/
		
		int min = n > m ? m : n;
		int max = n > m ? n : m;
		
		//int min = Math.min(n, m);
		//int max = Math.max(n, m);
		
		for (int i = min; i <= max; i++) {
			System.out.printf("%d+", i);
			sum += i;
			}
		System.out.printf("\b=%d\n", sum);
		
	}//main

}//class
