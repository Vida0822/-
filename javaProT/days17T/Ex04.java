package days17;

/**
 * @author ♈ kenik
 * @date 2023. 2. 17. - 오전 11:47:23
 * @subject
 * @content
 *
 */
public class Ex04 {

	public static void main(String[] args) {
		/*
		 * 1. 사원 클래스                     - Employee 클래스 추가 - 사원이라면 공통적으로 가지고 있어야할 멤버를 선언
		 * 2. 정규직 사원 클래스 추가  - Regular extends Employee + 정규직 멤버 선언
		 * 3. 영업직 사원 클래스 추가 - SalesMan extends Regular + 영업직 멤버 선언
		 * 4. 임시직 사원 클래스 추가 - Temp extends Employee     + 임시직 멤버 선언
		 * 
		 * [개념설명]
		 * 1. 상속성
		 * 2. 다형성
		 * 3. 업캐스팅/다운캐스팅
		 * 4. 오버로딩/오버라이딩
		 * 5. 추상화 ( 추상메서드, 추상클래스 )
		 * 6. this, super 키워드 
		 * 7. 인터페이스 
		 * 등등
		 * */ 
		
		/*
		// 1. 사원(Employee) 객체 생성 후 메서드 호출
		Employee emp1 = new Employee("김동현", "서울 강남구", "010-1111-2222", "2021.12.21");
		emp1.dispEmpInfo();
		*/
		
		// 2. 정규직(Regular) 객체 생성 
		// [문제점] 생성자의 매개변수들은  필드 초기화 - super(name, addr, tel, hiredate) 부모필드 초기화 가능
		// [문제점] 사원 정보를 출력하는 메서드 + ( 기본급 출력 X ) - 
		 //  1)  오버로딩( 새로운 출력 메서드 선언 )
		//   2)  오버라이딩( 재정의 함수 ) *** 왜? 다형성 때문에... 
		
		// [ 생성자 호출 순서 ] 
		/*
		Regular  emp2 = new Regular("박진용", "서울 양천구", "010-1212-1212", "2020.01.24", 300000 );
		emp2.dispEmpInfo();
		*/
		
		// 3. 영업직(SalesMan) 객체 생성
		/*
		SalesMan emp3 = new SalesMan("윤재민", "경기도 남양주", "010-7887-9878", "2000.03.29", 500000, 20, 150000);
		emp3.dispEmpInfo();
		*/
		
		// 4. 임시직(Temp) 객체 생성
		/*
		Temp emp4  = new Temp("설경인", "서울 강북", "010-4334-3894", "2022.02.12", 15, 200000);
	    emp4.dispEmpInfo();
	    */
		
		// [문제제시]
		// 사원이 할 수 있는 일(기능) 중에 제일 중요한 일이 뭘까요?  (월급받는 일) 
		// getPay() 급여 메서드 추가 선언
		// Regular.getPay() 추가
		
       // 자식(Regular) 객체를 생성해서 부모(Employee)클래스에 참조
		//    업캐스팅( UpCasting )
		//           클래스들간의 자동 형변환이 되었다.
		//  E(자료형)         =          R(자료형)
		/*
        Employee  emp2 = new Regular("박진용", "서울 양천구", "010-1212-1212", "2020.01.24", 3000000 );
		
        emp2.dispEmpInfo(); // 이름,주소,연락처,입사일 ,  실제 참조된 객체가 Regular익때문에 + 기본급  
        System.out.println( emp2.getPay() ) ;
        */
        // R 생 ->  E 업캐스팅
        //               emp2.dispEmpInfo() -> Employee.dispEmpInfo() X
        //                                                          Regular.dispEmpInfo() O  사실도 확인.
		
		
		// System.out.println("월급 : " + emp2.getPay() );
		// [첫번째 질문]    Regular emp =  new Regular()
		//                    왜 ? Employee emp =  new Regular()        
		//                    답 :   다형성 때문에~    업캐스팅하는  좋은 이유... 
		// [문제발생]  R 생성해서        E 클래스 업캐스팅하고 나니 
		//                    getPay()O           getPay()X
		//                                                  emp2.getPay() 호출 X
        
        // 3:10 수업 시작~
        
        // 질문)  그럼 상속받은 클래스들은 객체 생성 가능한건가요?
        //   자식클래스에서 추상메서드를 재정의하면 그 자식클래스는 객체 생성할 수 있다. 
		
		// 월) OOP 특징- 구체적인 내용까지 상세하게 설명...
		// 클래스 특징 == OOP 특징 :     캡슐화, (은닉화), (상속성), (추상화),(다형성)
		// [ 다형성 ( polymorphism ) ]
		// 1. 상속 관계
		// 2. 다양한 성질
		// 3. 여러 가지 형태를 가질 수 있는 능력
		//       Employee emp = new Regular();
		//       Employee emp = new SalesMan();
		//       Regular emp = new SalesMan();
		//       Employee emp = new Temp();
		// 4. 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 한 것.
		// 5. 업캐스팅(UpCasting)
		
		// 4:05 수업시작~ 
		// 왜? ***
		// 정규직객체, 영업직객체,임시직객체
		
		// 여러 타입의 사원들이 있습니다.
		/*
		Employee  emp2 = new Regular("박진용", "서울 양천구", "010-1212-1212", "2020.01.24", 300000 );
		Employee emp3 = new SalesMan("윤재민", "경기도 남양주", "010-7887-9878", "2000.03.29", 500000, 20, 150000);
		Employee emp4  = new Temp("설경인", "서울 강북", "010-4334-3894", "2022.02.12", 15, 200000);
		*/
		//Employee emp5 = new Temp02();
		
		// 클래스 배열 ( 객체 배열 ) 초기화 + 다형성 + UpCasting
		Employee [] emps = {
				new Regular("박진용", "서울 양천구", "010-1212-1212", "2020.01.24", 300000 ), 
				new SalesMan("윤재민", "경기도 남양주", "010-7887-9878", "2000.03.29", 500000, 20, 150000),
				new Temp("설경인", "서울 강북", "010-4334-3894", "2022.02.12", 15, 200000)
		};
		
		// 각 사원들의 급여를 계산해서 출력하는 메서드
		/*
		regularPay(emp2);
		salesManPay(emp3);
		tempPay(emp4);
		*/
		// 50 개의 사원 타입(종류)
		//employeePay(emp2);  // 정규직
		//employeePay(emp3);  // 영업직
		//employeePay(emp4);  // 임시직
		//employeePay(emp5);  // 임시직
		/*
		for (int i = 0; i < emps.length; i++) {
			employeePay(   emps[i] );
		}
		*/
		employeePay( emps[1] );  // SalesMan 영업직 사원

	} // main
	                                    //                  매개변수 다형성
	public static void employeePay( Employee emp ) {
		
		// 매개변수 Employee emp 가 실제 어떤 객체가 매개변수 넘어오지 확인...       :   instanceOf 연산자.
		// ( 주의할 점) instanceof 연산자를 사용할 때 반드시 자식클래스 부터 체크한다. 
		if (   emp instanceof SalesMan ) {   // true
			System.out.println(" 매개변수 emp는  SalesMan 타입  객체입니다. ");
			SalesMan sm = (SalesMan) emp;  // 다운캐스팅 
		} else if (   emp instanceof Regular ) {   // true
			System.out.println(" 매개변수 emp는  Regualr 타입  객체입니다. ");
			Regular rm = (Regular) emp;  // 다운캐스팅 
		}else if (   emp instanceof Temp ) {   // true
			System.out.println(" 매개변수 emp는  Temp 타입  객체입니다. ");
			Temp rm = (Temp) emp;  // 다운캐스팅 
		}
		
		
		 System.out.println( emp.getPay() );
	}
	
	/*
	public static void regularPay( Regular emp ) {
		 System.out.println( emp.getPay() );
	}
	
	public static void salesManPay( SalesMan emp ) {
		 System.out.println( emp.getPay() );
	}
	
	public static void tempPay( Temp emp ) {
		 System.out.println( emp.getPay() );
	}
	*/

} // class






