package days08;

/**
 * @author kenik
 * @date 2023. 2. 6. - 오후 4:45:25
 * @subject          5시 까지 수업 진행
 * @content         5시 10분 쉬는 시간
 *                             5:11 ~ 5:49          팀 + 스터디
 *       
 */
public class Ex04_02 {

	public static void main(String[] args) {
		
		// 윤년을 출력하고 싶다. 
		for (int i = 1500; i <= 2023; i++) {
			// 재사용
			if(  Ex04.isLeapYear(i)  )  System.out.print("윤년 - ");
			System.out.println(i);
		}

	} // main

} // class









