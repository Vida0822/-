package days04;

/**
 * @author kenik
 * @date  2023. 1. 31. - 오후 3:17:49
 * @subject   ( 시험 ) 인덱스 연산자 설명 *****
 * @content                []
 *                        String[] args
 */
public class Ex09 {

	// main ()함수의 매개변수가  String 배열이다.
	public static void main(String[] args) {
		// 국어 점수를 저장할 변수 하나 선언하세요.. 
		// int kor;
		
		// 국어 점수를 5만명 저장할 변수를 선언하세요..
		/*
		int kor00001;
		    :
			:
		int kor50000;
		*/
		
		// 참조형 - 배열
		// 동일한 자료형으로 여러 개의 기억공간을 할당하는 방법 : 배열
		// 1. 배열 정의 ? [동일한 자료형]을 메모리 상에 [연속적]으로 놓으게 한 것.
		// 2. 배열 선언 형식
		//     자료형 [] 배열명 = new 자료형[배열크기] ;  
		//     자료형 배열명[] = new 자료형[배열크기] ;
		
		// int 배열
		int [] kors = new int[3];
		// kors : 변수,  참조변수, 배열명
		// 3       : 배열 크기
		//  [] [] []
		//   0 1   2 요소
		// 인덱스값( index ) == 첨자값
		// LowerBound(아랫첨자값) = 0
		// UpperBound(윗첨자값)     = 배열크기 - 1 = 3-1 = 2
		
		// 0 번째 요소  ==  배열명[첨자값]
		kors[0] = 90;
		System.out.println( kors[0] );
		
		// 배열의 크기  : 배열명.length
		System.out.println(  kors.length );
		// UpperBound(윗첨자값)     = 배열크기 - 1 = 3-1 = 2
		System.out.println(  kors.length -1 );
		
		//(  배열을 사용할 때 주의할 점.)
		// ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		// 배열   인덱스 아~윗  예외(오류)
		// kors[3] = 100;

		// String 배열
		// String name ; // 이름을 저장할 변수를 1개 선언
		String [] names = new String[3];
		names[0] = "홍길동";
		names[1] = "김예지";
		names[2] = "박진용";
		
		System.out.println(  names[0] );
		System.out.println(  names[1] );
		System.out.println(  names[2] );

	} // main

} // class






