package days08;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오전 08:23:26
 * @subject  [제어문  활용]
 * @content  1. 다시 게임할거니 ? y                 n
 *                             1)  반복처리해야할 부분이 어디인지 ? 
 *                           12: 05 수업시작~  
 *                      2. 입력값에 대한 유효성 검사 :  a,  1~3 정수
 */
public class Ex01 {

	// [시험 1] 5분~
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		char con ;  //  'y'  'n'
		int com, user;
		
		do {
			com =  (int)(Math.random()*3)+1;
			
			String regex = "[1-3]";
			String sUser;
			
			boolean flag = false;
			do {
				System.out.print("> user 가위(1), 바위(2),보(3) 선택 ? ");  //
				sUser = scanner.next();
				flag = sUser.matches(regex);
			} while (  !flag  );   // flag == false
			
			user = Integer.parseInt(sUser);
			System.out.printf("> com = %d, user = %d\n", com, user);
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
			} // switch
			
			// 다시 게임할거니 ? y   or n               y를 입력했을 때 다시 게임 처리..반복..  for / while / [do~ while] *** 
			System.out.print("\n\t 다시 게임할거니 ? ");
			con = scanner.next().charAt(0); // "y" -> 'y'			
			// con cannot be resolved to a variable  지역변수 개념 
		} while (   con == 'Y'  ||  con == 'y' );
		
		
	    System.out.println(" 게임 종료!!!");
	} // main

} // class


/*
1조_연봉1조  		:  [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범             		(화요일)
2조_귀염2(이)조 	: [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주                     	(수요일)
3조_자바를 잡아	: [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁              	(목요일)
 */
