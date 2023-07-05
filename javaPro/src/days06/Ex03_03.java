package days06;

/**
 * @author hyejin
 * @date 2023. 2. 2. - 오후 3:30:25
 * @subject 
 * @content 
 *
 */
public class Ex03_03 {

	public static void main(String[] args) {
		String name = "hong gil dong";
		
		// char String.charAt(index)
		
		// 문자열의 길이
		int nameLength = name.length();
		// System.out.println(nameLength); // 13
		
		for (int i = 0; i < nameLength; i++) {
			System.out.println(name.charAt(i));
		}

	}//main

}//class
