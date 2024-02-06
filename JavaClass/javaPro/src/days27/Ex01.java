package days27;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오전 10:11:36
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {

		// 열거형(Enum) - 서로 관련된 상수를 선언한 것 + 모든 팀 성별(1/0, t/f, 'm'/'f') 일관성, 표준화 + 편리 + 코딩 가독성
		
		// 카드 모양
		int cardType = 0;
		switch (cardType) {
		case Card.CLOVER: // 클로버
			break;
		case 1: // 하트
			break;
		case 2: // 다이아
			break;
		case 3: // 스페이드
			break;
		}
		
	}//main

}//class

// Enum 열거형이름 {상수명1, 상수명2, ... } -> 컴파일 될 때 클래스로 변환
class Card {
	//정적 + 상수
	static final int CLOVER = 0;
	static final int HEART = 1;
	static final int DIAMOND = 2;
	static final int SPADE = 3;
}