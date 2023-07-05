package days20;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 22. - 오후 12:20:22
 * @subject 
 * @content 
 */
public class Ex03_03 {

	public static void main(String[] args) {
		
		// long nano = System.nanoTime();
		// long mili = System.currentTimeMillis();
		
		// testString();		
		testStringBuffer();
	} // main
	
	// 속도 600배 차이나요.. 
	// > 처리 시간 :       10503300ns
	// > 처리 시간 : 6초114562099ns
		private static void testStringBuffer() {
			// START
			long start = System.nanoTime();		
			// String sb = "a";
			StringBuffer sb = new StringBuffer("a");
			for (int i = 0; i < 200000; i++) {
				// sb += "a";
				sb.append("a");
			}
			// END
			long end = System.nanoTime();		
			System.out.printf("> 처리 시간 : %dns\n", ( end - start ));
			
		}

	// > 처리 시간 : 6초114562099ns
	private static void testString() {
		// START
		long start = System.nanoTime();		
		String sb = "a";		
		for (int i = 0; i < 200000; i++) {
			sb += "a";
		}
		// END
		long end = System.nanoTime();		
		System.out.printf("> 처리 시간 : %dns\n", ( end - start ));
		
	}

} // class










