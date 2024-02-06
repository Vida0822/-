package days11;

/**
 * @author dlsgu
 * @date 2023. 2. 9. - 오후 12:47:55
 * @subject 머니 입력 받아 출력
 * @content 
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		int money = 125760;
		int share; // 몫 변수
		int rest; // 나머지 변수
		
		// i=1 5만원
		// i=2 1만원
		// i=3 5천원
		// i=4 1천원
		// i=5 5백원
		// i=6 1백원
		// i=7 5십원
		// i=8 1십원
		// i=9   5원
		// i=10 1원
		int [] unit = {50000,10000,5000,1000,500,100,50,10,5,1}; // 화폐 단위 배열 선언
		String [] s_unit = { "5만원","1만원","5천원", "1천원", "5백원", "1백원","5십원","1십원","5원","1원" };
		
		for (int i = 0; i < unit.length; i++) {
			share = money / unit[i]; //몫 2
			rest = money % unit[i]; // 나머지 25760
			System.out.printf("%d원 : %d개\n", unit[i], share);
			System.out.printf("%s : %d개\n", s_unit[i], share);
			money = rest; //25760
		}
		
		/*
		share = money / 10000; //몫 2
		rest = money % 10000; // 나머지 5760
		System.out.printf("1만원 : %d개\n", share);
		
		// 반복...
		 */
		
	}//main

}//class
