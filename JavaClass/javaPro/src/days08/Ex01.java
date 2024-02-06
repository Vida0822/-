package days08;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 6. 오전 10:08:29
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) throws IOException {
		//
		int sum = 0, i = 1;
		boolean sw = false; //스위치 변수 flase(홀수) / true(짝수)
		while (i <= 10) {
			if (sw) {
				System.out.printf("%d+", i);
				//sum-=i;
				//sw = false;
			} else {
				System.out.printf("%d-", i);
				//sum +=i;
				//sw = true;
			}
			sum += sw ? i : -i;
			sw = !sw;
			i++;
		}
		System.out.printf("\b=%d\n", sum);

		/*
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i%2!=0) {
				System.out.printf("%d-", i);
				sum+=i;
			} else {
				System.out.printf("%d+", i);
				sum -=i;
			}
		}
		System.out.printf("\b=%d\n", sum);
		 */
		
	}//main

}//class
