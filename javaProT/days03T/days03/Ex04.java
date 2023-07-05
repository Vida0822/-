package days03;

/**
 * @author kenik
 * @date 2023. 1. 30. - 오후 2:50:56
 * @subject  형(type)변환 == 자료형 변환
 * @content   1. 형변환 ? 
 *                      2. 형변환 종류 2가지 설명.
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// 3:02 수업시작~
		/*
		 * 1.  모든 변수, 리터럴는 자료형이 있다. 
		 *     자료형 변수명;
		 * 2.     true, false -> boolean    
		 *           1,2,100      -> int
		 *           3.14           -> double
		 *           'A','X'         -> char
		 *           "홍길동"      -> String   
		 * 3. 프로그램을 작성하다 보면 서로 다른 타입(자료형) 간의 연산을 수행할 때 가 있다. 
		 *    서로 다른 자료형을 일치시켜야 할 필요가 있다.             
		 *    "형변환" 이라고 한다. 
		 * 
		 *  4. 형변환
		 *        1) 강제 형변환
		 *        2) 자동 형변환되는 2가지 경우.
		 *                 ㄱ.  작은 자료형 +(연산)  큰자료형 => 자동으로 큰 자료형 연산
		 *                        double
		 *                        (long)int  + int => long
		 *                        
		 *                        [자료형의 크기]
		 *                        byte < short < int < long(8) < float(4)  < double(8)
		 *                                    char 
		 *                        
		 *                 ㄴ.   좌측 큰자료형 = 우측 작은 자료형일 때 자동으로 형변환된다. 
		 *                       double result = 300;
		 * */
		
		/*
		int i = 100;                   //  int 4바이트 정수    :  [][][][01101100]
		double d = 3.14;		  // double 8바이트실수:  [0][][][][][][][]	
		//  100 + 3.14 = 103.14
		double result =  d + i;  // double d + int i    자동형변환
		System.out.println( result );
		*/
		
		/*
		int i = 100;
		int j = 200;
		// i + j ==    int  +  int = int 4바이트
		// Type mismatch: cannot convert from int to double  왜 ? 자동 형변환 
		double result = i + j;
		System.out.println(result ); // 300.0
		*/
		
		// Type mismatch: cannot convert from double to float
		// 좌측 = 우측
		//  f    =  d
		// float f = 3.14; X		
		// double  d = 3.14f;
		
		// -128~127 정수 byte 1바이트   
		// Type mismatch: cannot convert from int to byte   형변환 
		//                  int
		// byte age = 300;  자동형변환 X
		
		
		//  [강제형변환 설명]		
		//  우측 자료형이 좌측 보다 더 큰 자료형이기 때문에 자동형변환 되지 않는다. 
		// float  f = 3.14f;
		
		// double -> float 강제로 형변환
		// 이 때 사용하는 연산자가   "cast 연산자"
		// "cast 강제 형변환"이라고 한다. 
		// float  f = 3.14;
		float f = (float)3.14;  // 피연산자
		//             ( 변환하고자하는 자료형) cast 연산자
		
		
		// 연산자 우선 순위 :  곱셈  > 덧셈
		// 3 + 5 * 2                         =  13
		//          (1)10
		//   (2) 13
		
		// ( 3 + 5 ) * 2
		//      (1)8
		//                (2) 16
		
		// () 연산자 -  최우선 연산자

	} // main
 
} // class






