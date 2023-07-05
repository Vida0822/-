package days06;

import org.w3c.dom.NameList;

/**
 * @author kenik
 * @date  2023. 2. 2. - 오후 3:30:20
 * @subject 
 * @content 
 *
 */
public class Ex03_03 {

	public static void main(String[] args) {
		String name = "hong gil dong";
		
		// char  String.charAt(index)
		
		// 문자열의 길이
		int nameLength =  name.length();
		// System.out.println(  nameLength  );  // 13
		
		// index   0 ~ 12
		for (int i = 0; i < nameLength; i++) {
			System.out.println(  name.charAt(i) );
		}
		/*
		System.out.println(  name.charAt(0) );
		System.out.println(  name.charAt(1) );
		System.out.println(  name.charAt(2) );
		System.out.println(  name.charAt(3) );
		System.out.println(  name.charAt(4) );
		System.out.println(  name.charAt(5) );
		System.out.println(  name.charAt(6) );
		System.out.println(  name.charAt(7) );
		System.out.println(  name.charAt(8) );
		System.out.println(  name.charAt(9) );
		System.out.println(  name.charAt(10) );
		System.out.println(  name.charAt(11) );
		System.out.println(  name.charAt(12) );
		*/

	} // main

} // class









