package days26;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 2:16:32
 * @subject  
 * @content
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		// Arrays 클래스 -  fill(), copy(), sort(), binarySearch()  등등
		// Collections 클래스 
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(  list  );  // []
		
		// 1.   Collection  <? super T> c
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println( list  );  // [1, 2, 3, 4, 5]
		
		// 2. 오른쪽으로 2칸 이동 
		//Collections.rotate(list, 2);
		//System.out.println( list  );  // [4, 5, 1, 2, 3]
		
		// 3. 첫번째 요소와 세번째 요소를 교환(swap)
		//Collections.swap(list, 0, 2);
		//System.out.println( list  ); // [3, 2, 1, 4, 5]
		
		// 4. 임의의 위치로 변경
		Collections.shuffle(list);
		System.out.println(list);  // [3, 4, 1, 5, 2], [3, 2, 5, 1, 4]
		
		// 5. 오름차순 정렬
		//    내림차순 정렬
		//Collections.sort(list);
		Collections.sort(list, Collections.reverseOrder());
		// Collections.reverse(list);
		System.out.println( list ); // [1, 2, 3, 4, 5]
		
		// Collections.fill(list, 9);
		// Collections.copy(list, newList);
		// Collections.replaceAll(list, oldValue, newValue)
		// 등등
		
		// Arrays 클래스 사용..
		// Collections 클래스 



	}

}











