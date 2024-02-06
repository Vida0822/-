package days20;

import java.util.StringTokenizer;

/**
 * @author dlsgu
 * @date 2023. 2. 22. 오후 12:45:25
 * @subject
 * @content
 */
public class Ex05 {

	public static void main(String[] args) {
		// StringTokenizer 클래스
		String str = "김지은,신희민,박민종,윤재민";
		// str.split(구분자 regex)
		StringTokenizer st = new StringTokenizer(str, ",");
		
		System.out.println(st.countTokens()); // 토큰 갯수
		
		/*
		String name = st.nextToken();
		System.out.println(name);
		
		name = st.nextToken();
		System.out.println(name);
		
		name = st.nextToken();
		System.out.println(name);
		
		name = st.nextToken();
		System.out.println(name);
		
		// 더 이상 가져올 토큰이 없을 때 -> 예외
		// NoSuchElementException
		name = st.nextToken();
		System.out.println(name);
		*/
		
		while (st.hasMoreTokens()) { // true / false
			String name = st.nextToken();
			System.out.println(name);
		}
		
		/*
		 * 구분자를 가지고 잘라내기 -> 토큰
		 * hasMoreTokens()
		 * nextToken()
		 * */

	}//main

}//class
