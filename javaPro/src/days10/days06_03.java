package days10;

/**
 * @author dlsgu
 * @date 2023. 2. 8. - 오후 3:54:50
 * @subject 주민등록번호 검증 [시험문제 4]
 * @content 
 *
 */
public class days06_03 {

	public static void main(String[] args) {
	
		String rrn = "830412-1700001";
		int [] m = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		int tot = 0;
		for (int i = 0; i <= 12; i++) tot += (rrn.charAt(i)-48) * m[i];

        int checksum = (11-(tot % 11))%10;
        
        int ㅍ = Integer.parseInt( rrn.substring(12, 13) );
        
        String result = "올바른";
        if (ㅍ != checksum) result = "잘못된";
        System.out.printf("%s 주민등록번호\n", result);
        
	}//main

}//class
