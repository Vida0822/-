package days05;

import java.util.Scanner;

/**
 * @author kenik
 * @date  2023. 2. 1. - 오후 3:46:45
 * @subject    if/switch/break
 * @content     가위(1) , 바위(2), 보(3) 게임
 *                        컴퓨터 : 임의의 수( 보 ) =  1)랜덤하게 선정.  Ex06_02.java 
 *                        사용자 : 바위                = 직접 입력
 *                        
 *                        [2) 승부 체크 로직]
 *                        사용자 졌다.
 *                        사용자 이겼다.
 *                        무승부
 *                        
 *                        4:02 수업시작~
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		// 그런데 여기에 컴퓨터가 낸 수도 보여주면 더 좋을거 같습니다
		// > com = 1, user = 2
		// *** > com = 가위, user = 바위 ***
		
		// 만약에 4를 입력해서 컴퓨터가2를 내면 컴퓨터승으로 나오지않나요?
		// 답) 사용자의 입력값에 대한  유효성 검사를 한 후 ... 게임시작~ 
				
		int com =  (int)(Math.random()*3)+1;
		System.out.print("> user 가위(1), 바위(2),보(3) 선택 ? ");
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt(); // 1,2,3
		
		System.out.printf("> com = %d, user = %d\n", com, user);
		
		/*   user - com
		com/user       가위(1)    바위(2)    보(3)
		  가위(1)              0            사 1        컴2
		  바위(2)            컴-1           0         사 1
		  보(3)               사-2       -1컴           0
		  
		  
		  user-com == 0  무승부
		  사용자 승리 :    1 , -2
		  컴퓨티 승리 :     -1 , 2
       */
		switch (  user - com ) {
		case 0:
			System.out.println("무승부");
			break;
		case 1 : case -2:
			System.out.println("사용자 승리");
			break;
		case -1: case 2:
			System.out.println("컴퓨터 승리");
          break;
      // default:
	  //		break;
		}
	} // main

} // class











