package days26;

import java.util.Arrays;
import java.util.Calendar;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 4:38:15
 * @subject  
 * @content
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		/*
		 * [ 열거형( enums ) ]
		 *  - 서로 관련된 상수를 편리하게 선언하기 위한 것. 
		 *  - JDK 1.5 추가.
		 *  
		 *  - 열거형 선언 형식
		 *    enum 열거형이름 { 상수명1, 상수명2, ...  }
		 *    
		 *  - 열거형의 조상은  java.lang.Enum 클래스이다. 
		 *  
		 *  -  열거형을 사용하는 방법.  
		 *       열거형이름.상수명
		 * */  

		System.out.println(    Direction.EAST  );  // EAST
		System.out.println(    Direction.EAST.name()  );  //   열거형 상수의 이름을 문자열로 반환하는 메서드 
		System.out.println(    Direction.EAST.ordinal()  );  //  열거형 상수가 정의된 순서를 반환하는 메서드               0 
		
		// valueOf() 메서드
		Direction d =  Direction.valueOf("WEST");
		System.out.println( d );
		
		// values()
		Direction []  m = Direction.values();
		System.out.println(  Arrays.toString( m ) );  // [EAST, SOUTH, WEST, NORTH]
		
		// 7명의 팀원 프로젝트 진행... 
		// 성별 남자/여자  코딩...
		//           true/false
		//             1     / 0
		//            'm' / 'f'
		//          "남자"/"여자"
		//          등등		
		// Calendar.YEAR  == 1
	} // main
	
} // class

enum Card {   CLOVER, HEART, DIAMOND, SPADE  }


// 열거형
// 어노테이션 
// 자바 입출력( IO )
// 람다식와 스트림(고려)
// 팀프로젝트 (목/금)  월




