package days05;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 1. 오후 3:46:50
 * @subject if / switch / break
 * @content 가위(1)바위(2)보(3) 게임
 * 			컴퓨터: 1) 랜덤값 Ex06_02
 * 			사용자: 입력값
 * 			
 * 			2) 승부 체크 로직
 * 			사용자 이겼다 / 비겼다 / 졌다
 */
public class Ex06 {

	public static void main(String[] args) {

		int com = (int)(Math.random()*3)+1;
		
		System.out.print("> user 가위(1), 바위(2), 보(3) 선택 ? ");
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();
		
		System.out.printf("> com = %d, user = %d\n", com, user);
		
		/*
			user - com
		
		com/user	가위(1)		바위(2)		보(3)
		 가위(1)	   0		  1(w)		 2(l)
		 바위(2)	  -1(l)		   0		 1(w)
		  보(3)		  -2(w)		  -1(l)		  0
		  
		  user - com == 0 무승부
		  user 승리: 1, -2
		  com 승리: -1, 2
		 */
		switch (user - com) {
		case 0:
			System.out.println("무승부");
			break;
		case 1: case -2:
			System.out.println("사용자 승리");
			break;
		case -1: case 2:
			System.out.println("컴퓨터 승리");
			break;
		//default:
		//	break;
		}//switch

	}//main

}//class
