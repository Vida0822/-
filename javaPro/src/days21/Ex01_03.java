package days21;

import java.util.Arrays;

/**
 * @author dlsgu
 * @date 2023. 2. 23. 오전 11:33:45
 * @subject
 * @content
 */
public class Ex01_03 {

	public static void main(String[] args) {
		/*
		문제 설명
		문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.

		제한사항
		•1 ≤ my_str의 길이 ≤ 100
		•1 ≤ n ≤ my_str의 길이
		•my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.
		 */
		// String my_str = "abc1Addfggg4556b";
		String my_str = "abcdef123";
		// int n = 6;
		int n = 3;
		// ["abc1Ad", "dfggg4", "556b"]
		// ["abc", "def", "123"]
		
		String [] answer = solution(my_str, n);
		
		System.out.println(Arrays.toString(answer));

	}//main

	public static String[] solution(String my_str, int n) {
		int my_strLength = my_str.length();
		int size = (int)Math.ceil((double)my_strLength / n);
		String[] answer = new String[size];
		/*
		int idx = 0;
		while (my_strLength - idx*n > n) {
			answer[idx] = my_str.substring(idx*n, idx*n + n);
			idx++;
		}
		answer[idx] = my_str.substring(idx*n);
		*/
		int i = 0, idx = 0;
		try {
			for ( ; i < my_strLength; i+=n, idx++) {
				answer[idx] = my_str.substring(i, i+n);
			}
			
		} catch (Exception e) {
			answer[idx] = my_str.substring(i);
		}
		
		
		return answer;
		
	}

}//class
