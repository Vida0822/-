package days15;

// 저축 클래스 
public class Save {
	
	// 필드 선언
	private String name ; // 예금주
	private int money ;  // 예금액
	private double rate = 0.05; // 이자율
	
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

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	} 

	// 메서드 - 예금 정보를 출력하는 메서드 
	public void dispSave() {
		System.out.printf("> 예금주:%s, 예금액:%d, 이자율:%.2f\n"
				, this.name, this.money, this.rate);
	}
	
	
} // class



