package days18;

/**
 * @author dlsgu
 * @date 2023. 2. 20. 오전 11:42:40
 * @subject 클래스를 설계할 때
 * @content 추상화 작업 언제/어떻게 해야하는지 이해하기위한 예제
 */
public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}//main

}//class

/*
class Marine { // 해병대원
	int x,y; // 현재 위치
	void move(int x, int y) {}
	void stop() {}
	void stimPack() {}
}

class Tank {
	int x,y; // 현재 위치
	void move(int x, int y) {}
	void stop() {}
	void changeMode() {} // 공격모드 변환
}

class DropShip { // 수송선
	int x,y; // 현재 위치
	void move(int x, int y) {}
	void stop() {}
	void load() {}
	void unload() {}
}
*/

/*
// 유닛 : Marine, Tank, DropShip
// 공통으로 하는 것들을 추상화 -> 추상클래스 선언
abstract class Unit {
	int x,y; // 현재 위치
	abstract void move(int x, int y);
	abstract void stop();
}

class Marine extends Unit { // 해병대원
	@Override
	void move(int x, int y) {
		// 구현 완료
	}
	@Override
	void stop() {
		// 구현완료
	}
	
	void stimPack() {
		
	}
}

class Tank extends Unit {
	@Override
	void move(int x, int y) {
		// 구현 완료
	}
	@Override
	void stop() {
		// 구현완료
	}
	
	void changeMode() {} // 공격모드 변환
}

class DropShip extends Unit { // 수송선
	@Override
	void move(int x, int y) {
		// 구현 완료
	}
	@Override
	void stop() {
		// 구현완료
	}
	
	void load() {}
	void unload() {}
}
*/