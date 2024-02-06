package days23;

import java.util.ArrayList;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오후 4:24:29
 * @subject
 * @content
 *
 */
public class Ex12_02 {

	public static void main(String[] args) {
		
		ArrayList   list = new ArrayList();
		
		list.add(  new Integer(50) );
		list.add( new Integer(10) );
		list.add(100);
		list.add(80);
		list.add(30);
		
		// [50, 10, 100, 80, 30]
		System.out.println( list  );
		
		list.sort(null);  // 정렬
		
		// int -> Integer  오토박싱
		
		System.out.println( list  );

	}

}







