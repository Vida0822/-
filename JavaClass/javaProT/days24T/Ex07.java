package days24;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 4:22:21
 * @subject   Comparable 인터페이스 : 기본 정렬 기준을 구현하는 데 사용 
 *                     Comparator 인터페이스 : 기본 정렬 기준외에 다른 기준으로 정렬하고자 할 때 사용.
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		String [] m = { "tiger", "cat" , "Dog", "lion" };
		System.out.println(  Arrays.toString( m )  );  //  [tiger, cat, Dog, lion]
		
		// m 배열을 정렬을 해서 다시 출력.
		// Arrays.sort(  m   );
		
		// 내림차순 정렬 해서 다시 출력.
		// Arrays.sort(  m,  new DesendingComparator() );
		
		// 대소문자를 구분하지 않고  오름차순 정렬
		Arrays.sort(m, String.CASE_INSENSITIVE_ORDER );
		
		System.out.println(  Arrays.toString( m )  );   //  [Dog, cat, lion, tiger]
	} // main

} // class

class DesendingComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		 String s1 = (String) o1;
		 String s2 = (String) o2;
		 
		return s2.toUpperCase().compareTo(s1.toUpperCase());  // 0, 양수, 음수
	}
	
}












