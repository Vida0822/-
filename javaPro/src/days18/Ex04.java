package days18;

/**
 * @author dlsgu
 * @date 2023. 2. 20. 오전 11:53:16
 * @subject 인터페이스(interface) *****
 * @content
 */
public class Ex04 {

	public static void main(String[] args) {
		/*
		 * [인터페이스(interface)]
		 * 1. 자바의 자료형
		 * 	- 기본형 8가지
		 * 	- 참조형 : 배열, 클래스, 인터페이스
		 * 2. 참조타입
		 * 3. 일종의 추상클래스
		 * 4. 차이점 : 필드 선언 불가, 일반 메서드 선언 불가
		 * 	100% 추상메서드, 상수만을 갖는 추상클래스
		 * 5. 기본 클래스
		 * 6. 인터페이스 그 자체만으로 사용되기보다는 다른 클래스를 작성하는데 도움을 줄 목적으로 작성된다
		 * 7. 모든 필드는 public static final이다 (자동으로)(생략을 해도)
		 *    모든 메서드는 public abstract이다 (자동으로)(생략을 해도)
		 * 8. JDK1.8부터는 인터페이스 안에
		 * 	1) static 메서드
		 * 	2) default 메서드
		 * 	를 선언할 수 있다
		 * 9. 인터페이스끼리 상속이 가능하다
		 * 	- extends 키워드를 사용한다
		 * 10. 인터페이스는 다중상속이 가능하다
		 * 11. 인터페이스를 구현할 때는 implements 키워드를 사용해서 클래스를 선언한다
		 * */
		
		Tank t = new Tank();
		DropShip s = new DropShip();
		Fighter f = new Fighter();
		
		SCV scv = new SCV();
		scv.repair(t); // Repairable r
		scv.repair(s); // Repairable r
		
		// 인터페이스 매개변수 다형성
		// scv.repair(f); // 수리하는 메서드에 매개변수로 사용할 수 없음
		
		System.out.println("end");

	}//main

}//class

class Unit {
	int currentHP; // 유닛의 체력
	int x; // 유닛의 위치(x좌표)
	int y; // 유닛의 위치(y좌표)
}

// 공중 유닛
class AirUnit extends Unit {
	
}

// 지상 유닛
class GroundUnit extends Unit {
	
}

// 왜 굳이 move() 메서드만을 가진 인터페이스를 따로 이렇게 선언해야하나?
// java ~~able == ~~을 할 수 있다
interface Moveable { // 이동
	// 상수, 추상메서드 + static, default 메서드 선언
	void move(int x, int y); // public abstract 생략
}

interface Attackable { // 공격
	void attack(Unit u); // 공격 + 공격대상 유닛
}

// 인터페이스 다중 상속
interface Fightable extends Moveable, Attackable {
	
}

// class Fighter implements Moveable, Attackable {
class Fighter implements Fightable {

	@Override
	public void move(int x, int y) {
		// 구현
		
	}

	@Override
	public void attack(Unit u) {
		// 구현
		
	}
	
}

class Tank extends GroundUnit implements Fightable, Repairable {

	@Override
	public void move(int x, int y) {
		// 구현
		
	}

	@Override
	public void attack(Unit u) {
		// 구현
		
	}
	
//	int currentHP; // 유닛의 체력
//	int x; // 유닛의 위치(x좌표)
//	int y; // 유닛의 위치(y좌표)
	
}

class Marine extends Unit implements Fightable {

	@Override
	public void move(int x, int y) {
		// 구현
		
	}

	@Override
	public void attack(Unit u) {
		// 구현
		
	}

//	int currentHP; // 유닛의 체력
//	int x; // 유닛의 위치(x좌표)
//	int y; // 유닛의 위치(y좌표)
	
}

class DropShip extends AirUnit implements Fightable, Repairable {

	@Override
	public void move(int x, int y) {
		// 구현
		
	}

	@Override
	public void attack(Unit u) {
		// 구현
		
	}
	
//	int currentHP; // 유닛의 체력
//	int x; // 유닛의 위치(x좌표)
//	int y; // 유닛의 위치(y좌표)
	
}

// 안에 상수 X, 추상메서드 X, static/default 메서드 X	인터페이스 선언
// 이유? 이 인터페이스를 구현한 클래스는 수리가 가능한 클래스이다
interface Repairable {}

// 수리할 수 있는 클래스 : 탱크, 수송선, SCV - Repairable 구현한 Unit
// 수리할 수 없는 클래스 : Fighter, Marine
class SCV extends GroundUnit implements Repairable {
	SCV() {
	}
	
	// 고치는 메서드
	void repair(Repairable r) { // 인터페이스 매개변수 다형성
		if (r instanceof Unit ) {
			Unit u = (Unit)r; // 다운캐스팅
			// 수리하는 코딩
			System.out.println(u + "의 수리 완료!!!");
		}
	}
}

// 추상메서드가 존재하지 않아도 추상클래스로 선언할 수 있다
// 의도? 물려받는 자식부터 객체를 생성하세요
/*
abstract class Person {
	String name;
	int age;
	
	void dispInfo() {
		System.out.println("구현");
	}
}
*/