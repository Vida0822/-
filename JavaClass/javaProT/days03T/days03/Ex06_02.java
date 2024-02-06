package days03;

/**
 * @author kenik
 * @date 2023. 1. 30. - 오후 5:21:18
 * @subject    비교연산자 :             >    <    >=    <=       ==(같다)          !=(다르다)
 * @content       ㄴ  비교연산자의 결과값은 boolean( true/false ) 이다.
 *
 */
public class Ex06_02 {

	public static void main(String[] args) {
		// 
		int i = 10, j = 5;
		System.out.println(  i  >  j );  // true
		System.out.println(  i  <  j );  // false
		System.out.println(  i  >=  j );  // true
		System.out.println(  i  <=  j );  // false
		
		// (주의할점)    i=5, j=5
		// System.out.println(  i  =  j );  // 5        대입연산자 =
		// i = j;
		// System.out.println(i);
		
		System.out.println(  i  ==  j ); // false
		System.out.println(  i  !=  j ); // true                i  =!  j
		
		// 논리 연산자 ~~ ( 내일 )
	   

	} // main

} // class
