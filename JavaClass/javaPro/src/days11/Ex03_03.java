package days11;

/**
 * @author dlsgu
 * @date 2023. 2. 9. - 오후 12:47:55
 * @subject 머니 입력 받아 출력 (sw 변수) [시험문제2] sw 변수 사용
 * @content 
 *
 */
public class Ex03_03 {

	public static void main(String[] args) {
		// [정보처리기사 실기]
		int money = 125760;
		int unit = 50000;
		boolean sw = false; // 스위치 변수
		int count = 0; // 수량(갯수)
		while (unit >= 1) {
			count = money / unit; // 갯수
			System.out.printf("%d원 : %d개\n", unit, count);
			money %= unit;
			unit /= (!sw ? 5 : 2);
			sw = !sw;
		}

	}//main

}//class
