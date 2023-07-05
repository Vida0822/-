package days24;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 4:54:40
 * @subject 
 * @content 
 */
public class Ex08_02 {

	public static void main(String[] args) {
		// 로또게임
		HashSet<Integer>  lotto = new HashSet<>();
		
		fillLotto( lotto );
		dispLotto( lotto );

	} // main 

	private static void dispLotto(HashSet<Integer> lotto) {
		 Iterator<Integer> ir = lotto.iterator();
		 while (ir.hasNext()) {
			 Integer n = (Integer) ir.next();
			System.out.println(   n  );
		}
	}

	private static void fillLotto(HashSet<Integer> lotto) {
		Random rnd = new Random();
		 while( lotto.size() < 6) {
			 int n = rnd.nextInt(45)+1;
			 lotto.add(n);
		 }
	}

} // class








