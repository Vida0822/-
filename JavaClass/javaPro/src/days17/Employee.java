package days17;

// 12:07 수업시작~ 
// [사원클래스]
// 사원이라면 공통적으로 있어야할 멤버(필드, 메서드)를 구현한 클래스
// getPay() X   왜 선언하지 않았을까요 ? 

// 추상 메서드를 하나라도 가지고 있으면 반드시 객체를 생성할 수 없는 추상 클래스로 선언해야 된다.

// 추상 클래스
// 불완전한 클래스 이기 때문에 객체를 생성할 수 없는 클래스
// public abstract class Employee {  //  extends Object
public abstract class Employee {  //  extends Object
	// 필드
	private String name; // 사원명
	private String addr;   // 사원주소
	private String tel ;      // 사원연락처
	private String hiredate; // 입사일자

	// 생성자
	public Employee() {
		super();  // 
		System.out.println("> Employee 디폴트 생성자 호출됨.");
	}
	
	public Employee(String name, String addr, String tel, String hiredate) {
		super();  // 
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.hiredate = hiredate;
		System.out.println("> Employee 4 생성자 호출됨.");
	}



	// getter, setter
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	 
	// 메서드
	// 사원 정보를 출력하는 메서드 
	public void dispEmpInfo() {
		System.out.printf("사원명:%s, 주소:%s, 연락처:%s, 입사일자:%s\n"
				,this.name, this.addr, this.tel, this.hiredate );
	}
	
	
	// 급여 계산해서 반환하는 메서드 
	// 가상(Virtual) 메서드
	/*
	public int getPay() {
		return 0;  // 의미 X -> R/S/T  새로 재정의 할 수 밖에 없어요.. 
	}
	*/
	
	// 추상 메서드
	// 몸체가 구현이 안된 불완전한 메서드 
	// 클래스 설계할 때   추상 메서드를 왜 만듭니까? 
	public abstract int getPay();  //  몸체 (body) { }  구현 X
	
} // class














