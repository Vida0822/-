package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오전 11:11:40
 * @subject  비트 논리 연산자 
 * @content    1) &   비트 논리 AND 연산자 
 *                      2) |    비트 논리 OR 연산자 
 *                      3) ^    XOR 연산자              eXclusive OR 연산자
 *                                                                 배타적인 == 서로 다른
 *                                                                 서로 다를 때 참인 연산자.
 *                      4) ~  비트 부정(틸드) 연산자 
 *
 *               연산자 우선 순위     ~ > & > ^ > |
 */
public class Ex02_02 {

	public static void main(String[] args) {
		int i = 10;    //  0000 1010
		System.out.println(  ~i  );  // -11		
		System.out.println(  i & 3  );  // 2	
		System.out.println(  i | 3  );  // 11	
		System.out.println(  i ^ 3  );  // 9
		//   0000 1010
		//& 0000 0011
		//   0000 1001

	}

}
