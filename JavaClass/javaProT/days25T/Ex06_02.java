package days25;

import java.util.TreeSet;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오후 2:48:22
 * @subject 
 * @content 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// 3:00 수업 시작~  
		TreeSet ts = new TreeSet();
		ts.add("abc");		ts.add("alien");		ts.add("bat");
		ts.add("car");		ts.add("Car");		ts.add("disc");
		ts.add("dance");		ts.add("dzzz");		ts.add("dzzzz");
		ts.add("elephant");		ts.add("elevator");		ts.add("fan");
		ts.add("flower");	
		
		// 문자열 정렬~ 
		System.out.println(   ts  );
		
		// 범위 검색
		System.out.println(  ts.subSet("a", "d")   );  // [abc, alien, bat, car]
		System.out.println(  ts.subSet("c", "dzzz")   );  // [car, dance, disc]

		

	}

}






