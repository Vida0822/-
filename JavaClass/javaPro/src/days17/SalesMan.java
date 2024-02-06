package days17;

// 2:00 수업 시작~~  홍성철
// 영업직 사원클래스
// 급여 = 기본급 + 판매량 * 커미션
public final class SalesMan extends Regular{

	// 필드 : name, addr, tel, hiredate, basepay
	private int sales; // 판매량
	private int comm; // 커미션

	// 생성자
	public SalesMan() {
		super(); 
		System.out.println("> SalesMan 디폴트 생성자 호출됨.");
	}
	public SalesMan(String name, String addr, String tel, String hiredate, int basePay, int sales, int comm) {
		super(name, addr, tel, hiredate, basePay); // Regular 생성자 호출
		this.sales = sales;
		this.comm = comm;
		System.out.println("> SalesMan 7 생성자 호출됨.");
	}

	// 메서드 : dispEmpInfo()
	@Override
	public void dispEmpInfo() {
		/*
		super.dispEmpInfo();  // Regular.dispEmpInfo()
		System.out.printf("판매량=%d, 커미션=%d\n", this.sales, this.comm);
		 */

		System.out.printf("사원명:%s, 주소:%s, 연락처:%s, 입사일자:%s, 기본급=%d, 판매량=%d, 커미션=%d\n"
				,this.getName(), this.getAddr(), this.getTel(), this.getHiredate() , this.getBasePay()
				, this.sales, this.comm );
	}

	// 급여 계산해서 반환하는 메서드 
	@Override
	public int getPay() {
		// return this.getBasePay() + this.sales * this.comm;		
		return  super.getPay()  + this.sales * this.comm;
	}


} // class
