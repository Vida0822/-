package days14;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오후 2:09:00
 * @subject 
 * @content 
 */
public class Ex05_02 {

	public static void main(String[] args) {
		int [] m = new int[1];
		m[0] = 100;		
		plus( m );		// Call By Reference
		System.out.println(  m[0] ); // 300

	} // main

	private static void plus(int[] m) {
		m[0] += 200;
	}

} // class





