package days18;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오전 11:27:32
 * @subject            추상화, 추상메서드, 추상 클래스
 * @content
 *
 */
public class Ex02 {

	public static void main(String[] args) {
 
		// 추상클래스로 객체 생성할 수 없다. 
		// Player p = new Player();
		
		// 추상클래스 업캐스팅 = new  CDPlayer();
		// 추상클래스도 일종의 클래스이기 때문에 업캐스팅 가능하다. 

		// AudioPlayer p = new  CDPlayer();
		 Player  p2  = new  CDPlayer();
		 
		 p2.play(10);
		 p2.stop();
		
		 
		 // 멤버변수에는 abstact 안붙나요?  X

	} // main

} // class

abstract class Player{
	// 필드
	boolean pause;  // 작동 중지
	int currentPos;  // 현재 위치
	// 생성자
	Player(){}
	// 추상 메서드  2개
	abstract void play(int pos);
	abstract void stop();
}

abstract class AudioPlayer extends Player{ 
	
	// 필드
	// 생성자
	// 메서드
	
	// 부모로 부터 물려받은 추상메서드를 오버라이딩하지 않으면 그 클래스는 추상클래스가 된다. 
	@Override
	void play(int pos) {
		System.out.println("추상메서드를 오버라이딩 완료!!!");
	}
	// 하나라도 추상 메서드를 가지면  추상클래스이다.
	
}

class CDPlayer extends AudioPlayer{

	// 필드
	// 생성자
	// 메서드
	
	@Override
	void stop() {
		System.out.println("추상메서드를 오버라이딩 완료!!!");
	}
	
}










