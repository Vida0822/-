package days21;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author dlsgu
 * @date 2023. 2. 23. 오후 2:06:58
 * @subject
 * @content
 */
public class Ex03 {

	public static void main(String[] args) {
		// Object
		//	ㄴ Number
		//		ㄴ BigInteger : 정수 가장 큰 자료형 long(8) -900경~900경
		//			과학적인 계산 long형보다 더 큰 정수값을 저장하고자 한다면?
		//			- String 자료형처럼 불변
		//		ㄴ BigDecimal
		//			/ 실수 float(4), double(8)	정밀도 / 오차 존재
		//			- 오차가 없는 실수값을 다루고자 할 때
		
		BigInteger bi = new BigInteger("123123123123123123123213");
		bi = new BigInteger("EFEFEF12A", 16); // String, radix
		
		// 1 -> BigInteger
		// bi = BigInteger.valueOf(1L);
		System.out.println(bi.toString()); // "64407662890"
		
		// int +,-,*,/,% 산술연산자
		bi.add(bi);
		bi.subtract(bi);
		bi.multiply(bi);
		bi.divide(bi);
		bi.remainder(bi);
		
		BigDecimal bd = new BigDecimal(3.14);
		bd.add(bd);
		bd.subtract(bd);
		bd.multiply(bd);
		bd.divide(bd);
		bd.remainder(bd);
		
	}//main

}//class
