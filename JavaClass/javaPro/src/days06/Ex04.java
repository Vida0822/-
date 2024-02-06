package days06;

/**
 * @author dlsgu
 * @date 2023. 2. 2. - 오후 4:07:15
 * @subject 중첩 if문, *** [중첩 for문] - 별찍기 ***
 * @content 
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		// 중첩 for문
		/*
		 * i=1 -> 1<=4(참)
		 * */
		for (int i = 1; i <= 4; i++) { // 행개수 (줄개수)
			// System.out.println("****");
			// * x 4 + 개행
			for (int j = 1; j <= 4; j++) { // 별(열)개수 (한 줄 별개수)
				System.out.print("*");
			}//for j
			System.out.println(); // 개행
		}//for i

	}//main

}//class
