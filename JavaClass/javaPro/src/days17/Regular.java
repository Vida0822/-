package days17;

// 정규직 사원 클래스 
// 급여 = 기본급
public class Regular extends Employee{
	// 필드 - name, addr, tel, hiredate 상속
	private int basePay; // 기본급 

	// getter, setter
	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	// 생성자
	public Regular() {
		super(); 
		System.out.println("> Regular 디폴트 생성자 호출됨.");
	}
	
	public Regular(String name, String addr, String tel, String hiredate, int basePay) {
		super(name, addr, tel, hiredate);
		
		// 필드 초기화 코딩..
		// The field Employee.name [is not visible] - private 로 선언된 필드 
		// this.name = name;    X
		// super.name = name; X
		
		/*
		this.setName(name);
		this.setAddr(addr);
		this.setTel(tel);
		this.setHiredate(hiredate);
		*/
		
		this.basePay = basePay;
		System.out.println("> Regular 5 생성자 호출됨.");
	}

	// 메서드 - dispEmpInfo() 상속 : name, addr, tel, hiredate 만 출력
	// [오버라이딩 조건]
	@Override
	public void dispEmpInfo() {
		System.out.printf("사원명:%s, 주소:%s, 연락처:%s, 입사일자:%s, 기본급=%d\n"
				,this.getName(), this.getAddr(), this.getTel(), this.getHiredate() , this.basePay);
		/*
		super.dispEmpInfo();
		System.out.printf("기본급=%d\n", this.basePay);
		*/		
	}
	
	// 급여 계산해서 반환하는 메서드 
	public int getPay() {
		return this.basePay;		
	}
		
	

} // class









