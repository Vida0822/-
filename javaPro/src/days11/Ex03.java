package days11;

/**
 * @author dlsgu
 * @date 2023. 2. 9. - 오후 12:47:55
 * @subject 머니 입력 받아 출력
 * @content 
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		int money = 125760;
		int share; // 몫 변수
		int rest; // 나머지 변수
		
		share = money / 50000; //몫 2
		rest = money % 50000; // 나머지 25760
		System.out.printf("5만원 : %d개\n", share);
		
		money = rest; //25760
		share = money / 10000; //몫 2
		rest = money % 10000; // 나머지 5760
		System.out.printf("1만원 : %d개\n", share);
		
		// 반복...
		
	}//main

}//class
