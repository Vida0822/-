package days15;

// 저축 클래스 
public class Save {
	
	// 필드 선언
	// 인스턴스 변수
	private String name ; // 예금주
	private int money ;  // 예금액
	// [Method Area]
	// 클래스 변수 - 프로그램 시작시(클래스 파일 실행시) 생성 / 프로그램 종료시(클래스 파일 종료시) 소멸
	// static 변수
	// 정적 변수
	// 공유(shared) 변수
	private static double rate = 0.05; // 이자율
	
	// Alt + Shift + S
	public Save() {  // 디폴트 생성자
		// super();	
	}

	public Save(String name, int money, double rate) {
		//super();
		this.name = name;
		this.money = money;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	/* 객체를 생성해야 사용할 수 있는 인스턴스 메서드
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	} 
	*/

	// 메서드 - 예금 정보를 출력하는 메서드 
	public void dispSave() {
		System.out.printf("> 예금주:%s, 예금액:%d, 이자율:%.2f\n"
				, this.name, this.money, this.rate);
	}

	// 정적(static) 메서드
	// 프로그램이 시작되면 Method Area에 로딩된다
	// 그래서 인스턴스(생성된 객체)를 생성하지 않아도 클래스명으로 접근(사용)할 수 있다
	public static double getRate() {
		return rate;
	}

	// static 메서드 안에서
	public static void setRate(double rate) {
		// 1) 지역변수 사용할 수 있다
		int n = 100;
		String s = "aa";
		
		// 2) 인스턴스 변수 사용할 수 없다
		// Cannot make a static reference to the non-static field name
		// name = "홍씨";
		
		// 3) this 키워드 사용할 수 없다
		// this는 생성된 객체(인스턴스)에 자기자신의 주소값을 갖는 참조변수
		// this는 객체를 생성해야지만 사용할 수 있기 때문에
		
		Save.rate = rate;
	}
	
	
} // class



