package days20;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 22. - 오전 11:51:00
 * @subject 
 * @content 
 */
public class Ex04 {

	public static void main(String[] args) {
		// 12:02 수업 시작~
		/*
		문제 설명
		길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

		제한 조건
		n은 길이 10,000이하인 자연수입니다.
		입출력 예
		n	return
		3	"수박수"
		4	"수박수박"
		*/
		
		String answer =  Solution.solution(4);
		System.out.println( answer );
		 
	} // main

} // class

class Solution {
	public  static String solution(int n) {  // 5 
		
		StringBuffer answer = new StringBuffer();		
		int 몫 = n/2;
		int 나머지 = n%2;
        for (int i = 1; i <= 몫; i++)   answer.append("수박" ) ;        
        if(나머지 ==1 ) answer.append("수");
	 
        return answer.toString();
    }
	
	/*
	public  static String solution(int n) {
		StringBuffer answer = new StringBuffer();		
        for (int i = 1; i <= n; i++) {
        	if( i%2==1) answer.append("수" ) ;
        	else answer.append("박" );
		}        
        return answer.toString();
    }
    */
	/*
    public  static String solution(int n) {
        String answer = "";        
        for (int i = 1; i <= n; i++) {
			// i 홀수  =  수 
        	// i 짝수 =  박
        	if( i%2==1) answer +="수";
        	else answer +="박";
		}        
        return answer;
    }
    */
}








