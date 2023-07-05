/**
 * 
 */
package days11;

/**
 * @author kenik
 * @date  2023. 2. 9. - 오후 2:15:14
 * @subject 
 * @content 
 *
 */
public class Ex03_02 {
 
	public static void main(String[] args) {
		int money = 125760;
		int share;  // 몫 변수
		int rest;    // 나머지 변수
		
		// i=1     5만원
		// i=2     1 만원
		// i=3     5천원
		// i=4	  1천원
		// i=5     5백원
		// i=6     1백원
		// i=7     5십원
		// i=8     1십원
		// i=9      5원
		// i=10     1원
		int [] unit = {50000,10000,5000,1000,500,100,50, 10, 5, 1}; // 화폐 단위 배열 선언
		String [] s_unit = { "5만원","1만원","5천원", "1천원", "5백원", "1백원","5십원","1십원","5원","1원" };
		
		for( int i=0 ; i< unit.length ; i++) {
			share =  money / unit[i];   // 몫
			rest = money %  unit[i]; // 나머지    25760
			System.out.printf("%s : %d 개\n",  s_unit[i],  share);		
			money = rest;   // 25760
		} // 
	
		/*
		share =  money / 50000;   // 몫
		rest = money % 50000; // 나머지    25760
		System.out.printf("5만원 : %d 개\n", share);		
		money = rest;   // 25760
		
		share =  money / 10000;   // 몫  2
		rest = money % 10000; // 나머지    5760
		System.out.printf("1만원 : %d 개\n", share);		
		money = rest;   // 5760
		
		share =  money / 5000;   // 몫  1
		rest = money % 5000; // 나머지    760
		System.out.printf("5천원 : %d 개\n", share);		
		money = rest;   // 760
		
		share =  money / 1000;   // 몫  0
		rest = money % 1000; // 나머지    760
		System.out.printf("1천원 : %d 개\n", share);
		money = rest;   // 760
		
		share =  money / 500;   // 몫  1
		rest = money % 500; // 나머지    260
		System.out.printf("5백원 : %d 개\n", share); 
		money = rest;   // 260
		
		share =  money / 100;   // 몫  2
		rest = money % 100; // 나머지    60
		System.out.printf("1백원 : %d 개\n", share);		
		money = rest;   // 60
		
		share =  money / 50;   // 몫  1
		rest = money % 50; // 나머지    10
		System.out.printf("5십원 : %d 개\n", share);		
		money = rest;   // 10
		
		share =  money / 10;   // 몫  1
		rest = money % 10; // 나머지    0
		System.out.printf("1십원 : %d 개\n", share);		
		money = rest;   // 0
		
		share =  money / 5;   // 몫  20
		rest = money % 5; // 나머지   0
		System.out.printf("5원 : %d 개\n", share);		
		money = rest;   // 0
		
		share =  money / 1;   // 몫  2
		rest = money % 1; // 나머지    60
		System.out.printf("1원 : %d 개\n", share);
		*/

	}  // end of main

}
 // end of class