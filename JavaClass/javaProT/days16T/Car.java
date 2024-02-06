package days16;

public class Car {
	
	// 필드
	String name;
	String gearType; // 수정, 자동
	int door;
	
	// 클래스 필드
	static  Member member;
	
	// [참조타입의 필드는 new 생성되었는지 꼭 확인]
	// 엔진 필드
	// 필드를 priavte 접근지정자로 설정하는 이유 ? 
	// getter, setter
	private Engine engine = null;  // has-a 관계

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		// 장착할 수 있는 유효한 엔진 체크 한 후 장착..
		this.engine = engine;
	}
	
	
	// Car 클래스랑 Engine 클래스 랑  일체형(결합력)이 높은 코딩. -> 좋은 코딩이 아니다.  왜?   ( 시험 )
	// Engine engine = new Engine();     
	

	// 3:05 수업 시작
	// 생성자
	Car(){
		
	}
	
	public Car(Engine engin) {
		this.engine = engin;
	}

	// 메서드
	void speedUp( int fuel ) {
		// engine 객체가 생성 ( 확인 ) 
		this.engine.moreFuel(fuel);  // NullPointerException 에러 발생.
	}
	
	void speedDown( int fuel ) {
		this.engine.lessFuel(fuel);
	}
	
	void stop() {
		this.engine.stop();
	}

} // class


