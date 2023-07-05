package days09;

import java.util.Random;

/**
 * @author dlsgu
 * @date 2023. 2. 7. 오후 3:39:25
 * @subject
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		// 신용카드
		//             0    1    2    3      랜덤하게 0~3 정수를 발생
		String card ="7655-8988-9234-5677";
		// - String [] 구분자로 card 문자열을 잘라내기(split)
		// [1]="****"
		// 배열의 문자열을 다시 조립(결합)해서 출력
		
		String [] cards = card.split("-");
		
		for (int i = 0; i < cards.length; i++) {
			System.out.printf("cards[%d]=%s\n", i, cards[i]);
		}
		
		Random rnd = new Random();
		int index = rnd.nextInt(4);// 0, 1, 2, 3 배열의 index
		cards[index] = "****";
		
		/*
		card = String.format("%s-%s-%s-%s", cards[0], cards[1], cards[2], cards[3]);
		System.out.println(card);
		*/
		
		card = String.join("-", cards);
		System.out.println(card);
		
	}//main

}//class
