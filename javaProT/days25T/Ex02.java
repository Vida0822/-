package days25;

import java.util.ArrayList;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오전 11:24:04
 * @subject 
 * @content 
 */
public class Ex02 {

	public static void main(String[] args) {
		ArrayList  list1 = new ArrayList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		ArrayList  list2 = new ArrayList();
		list1.add(11);
		list1.add(22);
		list1.add(33);
		
		ArrayList list3 = new ArrayList();
		//list3.addAll(list1);
		//list3.addAll(list2);
		
		list3.add(list1);
		list3.add(list2);
		
		System.out.println(  list3  );  // [1, 2, 3, 11, 22, 33]
		

	}

}







