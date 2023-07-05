package days14;

import java.util.Random;
import java.util.Scanner;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오전 11:18:35
 * @subject 
 * @content 
 */
public class Ex03 {

	// static + 메서드 == 멤버함수
	// 정적메서드
	public static void main(String[] args) {
		
		// 배열설명할 때 가비지 설명 =  null 초기화.
		
		/*   스택                                       힙
		 *    [인스턴스 주소값 ]                생성과정 객체( new Car() )    인스턴스화
		 *                                                 인스턴스 주소값
		 *     myCar                                [name][speed][wheelCount][dispCarInfo()주소참조]
		 *     객체                                       인스턴스
		 *                                                객체명.필드명
		 *                                                myCar.name
		 *                                                myCar.speed
		 *                                                myCar.wheelCount
		 *                                                객체명.메서드명()
		 *                                                myCar.dispCarInfo()
		 *     
		 *     
		 *     
		 *                                                    메서드(함수)코드 영역
		 *                                                    [dispCarInfo()메서드 ]
		 * */ 
		Car myCar = null;  // 변수, 참조변수, [객체명], 지역변수
		myCar = new Car();  //
		
		// 그 객체의 필드, 메서드를 사용하려고 해요.  -  멤버연산자  .
		// [ 객체의 멤버에 접근할 때 멤버연산자(.)을 사용한다. ]
		//  객체명.필드명		
		// Cannot make a static reference to the non-static field Car.name
		// Car.name = "스포츠카-2";
		
		// The local variable myCar may not have been initialized
		// 자바에서 지역변수는 반드시 초기화 해야지만 사용할 수 있다. 
		myCar.name = "스포츠카-2";
		
		//  객체명.메서드명()
		myCar.dispCarInfo();
		
		
		// 스캐너
		//Car        myCar = new Car();
		/*
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		scanner.nextInt();
		
		Random rnd = new Random();
		rnd.nextInt(100);
		*/
		
		// The constructor System() is not visible 에러메시지 X
		// System   s = new System(); X
		// System 클래스는 인스턴스화 할 수 없다 == 객체 생성할 수 없다.   == new System();
		
		// 강사님 system이란  클래스만 new 연산자 쓰지 못하나요?  new 연산자로 객체 생성 X
		// 강사님 그럼 메인함수도 하나의 멤버함수(메서드)인가요 ? 예
		// 강사님 System 클래스는 아예 기능이 고정되어 있는 클래스인건가요? 예 (추후 설명)

	} // main

} // class

// NullPointerException

/*
int [] m = new int[3];   // 0, 1, 2
m[3] = 100;  ArrayIndexOutOfBoundException 발생
*/






