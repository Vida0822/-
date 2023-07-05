package days18;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오전 11:41:43
 * @subject         클래스를 설계할 때
 * @content         추상화 작업 언제/어떻게 해야하는지 이해...
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		

	} // main

} // class

/*
class Marine{ // 해병대원
	int x, y;  // 현재 위치
	void move(int x, int y) {}
	void stop() {}
	void stimPack() { }	
}

class Tank{  // 탱크
	int x, y;  // 현재 위치
	void move(int x, int y) {}
	void stop() {}
	void changeMode() {}   // 공격모드 변환
}

class DropShip{ // 수송선
	int x, y;  // 현재 위치
	void move(int x, int y) {}
	void stop() {}
	
	void load() {}
	void unload() {}
}
*/

/*
// 유닛 : Marine, Tank, DropShip
// 공통으로 하는 것들을 추상화- 추상 클래스 선언
abstract class Unit{
	int x, y;  // 현재 위치
	abstract void move(int x, int y);
	abstract void stop();
}


class Marine extends Unit{ // 해병대원
	@Override
	void move(int x, int y) {
		// 구현 O
	}
	@Override
	void stop() {
		// 구현 O
	}
	void stimPack() { 
		
	}	
}

class Tank extends Unit{  // 탱크
	@Override
	void move(int x, int y) {
		// 구현 O
	}
	@Override
	void stop() {
		// 구현 O
	}
	void changeMode() {}   // 공격모드 변환
}

class DropShip extends Unit{ // 수송선
	@Override
	void move(int x, int y) {
		// 구현 O
	}
	@Override
	void stop() {
		// 구현 O
	}
	
	void load() {}
	void unload() {}
}
*/









