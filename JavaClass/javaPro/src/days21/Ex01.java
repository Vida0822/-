package days21;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author dlsgu
 * @date 2023. 2. 23. 오전 9:05:56
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		/*
		1. 3조 팀원들의 이름만 names 배열에 넣고
		   내림차순으로 정렬해서 아래와 같이 출력하세요.
		  String team02 = "3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)";
		  ( 조건 : StringTokenizer 클래스 사용해서 잘라내기 )
		 */
		String team03 = "3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)";
		// 1. team03에서 팀명을 제외한 문자들은 제거 -> String.replace(대상문자열, "");
		// StringBuffer sb = new StringBuffer(team03); -> 정규표현식 사용 불가
		String regex = ".*\\[팀장\\]|\\(\\*\\)|\\(.{3}\\)";
		team03 = team03.replaceAll(regex, "");
		// System.out.println(team03); // 박민종, 심성환, 이진우, 홍찬기, 김예지, 하지예 , 탁인혁 
		
		StringTokenizer st = new StringTokenizer(team03, ",");
		int size = st.countTokens();
		int idx = 0;
		String [] names = new String[size];
		while (st.hasMoreTokens()) {
			String name = st.nextToken();
			// System.out.println(name.trim());
			names[idx++] = name.trim();
		}
		System.out.println(Arrays.toString(names));
		/*
		// 1. 오름차순 정렬
		Arrays.sort(names);
		// 2. Reverse
		String [] temp = new String[names.length];
		for (int i = 0; i < names.length; i++) temp[(names.length-1)-i] = names[i];
		names = temp;
		System.out.println(Arrays.toString(names));
		*/
		
		/*
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1); // 
			}
		});
		*/
		//					람다식
		// Arrays.sort(names, (o1,o2) -> o2.compareTo(o1));
		
		Arrays.sort(names, Collections.reverseOrder());
		
		System.out.println(Arrays.toString(names));
		
	}//main

}//class
