package days09;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오후 4:26:06
 * @subject 
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		String rrn = "830412-1700001";
		// 1. System.out.println("830412-*******");
		 System.out.println( rrn.split("-")[0] + "-*******" ) ;
		// rrns[0] = 830412;
		// rrns[1] = ********
		//  String.join("-", 배열명)
		 
		// 2. System.out.println("830412-1******");
		 System.out.println( rrn.split("-")[0]+"-" +  rrn.charAt(7)+"******" );

		 // Ex05_02.java
	} // main

} // class










