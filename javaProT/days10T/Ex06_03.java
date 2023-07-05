package days10;
 
/**
 * @author kenik
 * @date  2023. 2. 8. - 오후 4:05:45
 * @subject 
 * @content 
 *
 */
public class Ex06_03 {

	public static void main(String[] args) {
		// 4:05 수업 시작~  
		String rrn  =  "830412-1700001"; 
		
		/*
	    int ㄱ =	Integer.parseInt(  rrn.substring(0, 1) );
		int ㄴ =	Integer.parseInt(  rrn.substring(1, 2) );
		int ㄷ =	Integer.parseInt(  rrn.substring(2, 3) );
		int ㄹ =	Integer.parseInt(  rrn.substring(3, 4) );
		int ㅁ =	Integer.parseInt(  rrn.substring(4, 5) );
		int ㅂ =	Integer.parseInt(  rrn.substring(5, 6) );
		//                                                                      6, 7       -
		int ㅅ =	Integer.parseInt(  rrn.substring(7, 8) );
		int ㅇ =	Integer.parseInt(  rrn.substring(8, 9) );
		int ㅈ =	Integer.parseInt(  rrn.substring(9, 10) );
		int ㅊ =	Integer.parseInt(  rrn.substring(10, 11) );
        int ㅋ =	Integer.parseInt(  rrn.substring(11, 12) );
        int ㅌ =	Integer.parseInt(  rrn.substring(12, 13) );
        */
		int [] m = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		int tot = 0;
	    for (int i = 0; i <= 12; i++) {
	    	if( i == 6) continue; // -
	    	 tot += Integer.parseInt(  rrn.substring(i, i+1) ) * m[i];
		}
        int checksum = ( 11-(tot % 11) ) %10;
               
        int ㅍ =	Integer.parseInt(  rrn.substring(13,14) );
        if ( ㅍ == checksum) {
			System.out.println("올바른 주민등록번호.");
		} else {
			System.out.println("잘못된 주민등록번호.");
		}
        
	} //int ㅌ = main

} // class
