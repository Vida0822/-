package days16;

public class Car {
	
	// 필드
	String name;
	String gearType; // 수동, 자동
	int door;
	
	// 클래스 필드
	static Member member;
	
	// [참조타입의 필드는 new 생성되었는지 꼭 확인]
	// 엔진 필드
	// 필드를 private 접근지정자로 설정하는 이유 - 잘못된 값을 입력하지 못하도록, 유효한 값만 넣을 수 있도록
	// getter / setter 필요
	private Engine engine = null; // has-a 관계
	// Car 클래스랑 Engine 클래스는 결합력이 높은 코딩(일체형) [시험문제]
	// Engine engine = new Engine();  ㄴ좋은 코딩이 아니다
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		// 장착할 수 있는 유효한 엔진인지 체크한 후 장착
		this.engine = engine;
	}
	
	// 생성자
	Car() {
		
	}

	public Car(Engine engine) {
		this.engine = engine;
	}

	// 메서드
	void speedUp(int fuel) {
		// engine 객체가 생성이 되었는지 확인
		this.engine.moreFuel(fuel); // NullPointerException 에러 발생
	}
	
	void speedDown(int fuel) {
		this.engine.lessFuel(fuel);
	}
	
	void stop() {
		this.engine.stop();
	}
	
}
