package days08;

/**
 * @author dlsgu
 * @date 2023. 2. 6. 오후 4:45:30
 * @subject
 * @content
 */
public class Ex04_02 {

	public static void main(String[] args) {

		// 윤년을 출력하고 싶다
		for (int i = 1500; i <= 2023; i++) {
			if (Ex04.isLeapYear(i)) {
				System.out.print("윤년 - ");
			}
			System.out.println(i);
		}

	}//main

}//class
