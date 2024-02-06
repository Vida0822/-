package days09;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오후 4:26:43
 * @subject
 * @content
 */
public class Ex05_02 {

	public static void main(String[] args) {
		String rrn = "830412-1700001";
		
		// 1. System.out.println("830412-*******");
		System.out.println(rrn.split("-")[0] + "-*******");
		// 2. System.out.println("830412-1******");
		System.out.println(rrn.split("-")[0] + "-" + rrn.charAt(7) + "******");
		/*
		// 1. System.out.println("830412-*******");
		
		String [] rrns = rrn.split("-");
		rrns[1] = "*******";
		rrn = String.join("-", rrns);
		System.out.println(rrn);
		
		// 2. System.out.println("830412-1******");
		
		String [] rrnss = rrn.split("-");
		rrnss[1] = "1******";
		rrn = String.join("-", rrnss);
		System.out.println(rrn);
		*/

	}//main

}//class
