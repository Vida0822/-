package days02;

/**
 * @author kenik
 * @date  2023. 1. 27. - 오후 4:43:54
 * @subject   A    'A'  "A" 차이점 이해.
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		
		// A cannot be resolved to a variable
		// System.out.println(  A  );   // variable
		
		int n = 1;
		char m = '1';
		String s = "1";
		
		
		char one  = 'A';
		System.out.println(  one  );  // char      한문자
		
		String two = "A"; // =  'A' + '\0'
		System.out.println(  two  ); // String  문자열

	} // main

} // class



