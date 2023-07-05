package days23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오후 3:52:47
 * @subject
 * @content
 *
 */
public class Ex12 {

	public static void main(String[] args) {
		// 4:05 수업 시작~ 
		ArrayList  list = new ArrayList();
		list.add("박진용");
		list.add("이혜진");
		list.add("김예지");		
		list.add("박현주");		
		
		// 복제 한 후에 요소의 수정, 삭제, 추가 데이터 변경
		// ArrayList listClone =  (ArrayList) list.clone();  // 다운캐스팅.
	 	
		// 이름을 오름차순으로 정렬
		//           Comparator c   비교기
		// list.sort(null);
		
		// 이름을 내림차순으로 정렬.
		// [ 익명(무명) 클래스 ]
		/*
		 list.sort(   new Comparator<String>() { 
			@Override
			public int compare(String o1, String o2) { 
				return o2.compareTo(o1);
			}
		}  );
		*/
		/*
		list.sort(   (o1,  o2) ->   ((String) o2).compareTo((String) o1)   );
		*/
       //                          Comparator c   비교기
		list.sort(  Collections.reverseOrder() );
		
		// get() + for문
		// *** 반복자 ***
		Iterator  ir =  list.iterator();		
		// ir.hasNext() 
		while (ir.hasNext()) {
			String name = (String) ir.next();
			System.out.println(  name );
		}
		
		

	} // main 

} // class







