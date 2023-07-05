package days26;

import days17.Employee;
import days17.Regular;
import days17.SalesMan;

public class Ex02 {

	public static void main(String[] args) {
		
		// 자식 객체 생성해서 부모 클래스에 참조시킬 수 있다 : 업캐스팅
		Employee r1 = new Regular();
		test( r1 );
		
		SalesMan s1 = new SalesMan();
		test( s1 );

		String name = "홍길동";
		System.out.println(  name );
	}
                                        	//  업캐스팅
                                         	// 매개변수 다형성
	public static void test(     Employee emp   ) {
		// 
	}

}
