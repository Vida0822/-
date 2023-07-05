package days19;

import java.util.Arrays;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오후 4:03:00
 * @subject 
 * @content 
 */
public class Ex07_03 {

	public static void main(String[] args) {
		 String team01 = "이태규    ,     김지은 , 설경인,윤재민,   홍성철, 김동현, 박상범 "; 
		 // String [] names = team01.split("\\s*,\\s*" ,  3);
		 String [] names = team01.split("\\s*,\\s*");
		 
		 System.out.println( "<ol><li>".concat( String.join("</li><li>", names) ).concat("</li></ol>")  );
		 
		 
		 
		 // [람다 와 스트림 ]
		 // Arrays.asList(names).forEach( n -> System.out.println(n)   );
		 // Arrays.asList(names).forEach( System.out::println   );
		 
		 /*
		 for (String name : names) {
				System.out.printf("[%s]\n", name);
		}
		*/
		 
		 // team01 문자열에서 팀원 String [] 받아서 출력.
		 /*
		 String [] names = team01.split(",");
		 for (String name : names) {
			System.out.printf("[%s]\n", name.trim());
		}
		*/
		  

	} // main

} // class










