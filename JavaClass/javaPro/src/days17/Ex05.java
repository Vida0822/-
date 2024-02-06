package days17;

/**
 * @author ♈ kenik
 * @date 2023. 2. 17. - 오후 2:04:08
 * @subject
 * @content
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		/*
		 * [ final 키워드 ]  ( 시험 ) final 키워드에 대해서 설명하세요~
		 * 1. 변수 앞에         선언할 때   -   상수
		 *     지역변수
		 *     매개변수
		 *      
		 *     인스턴스 변수
		 *     클래스 변수
		 *      
		 * 2. 메서드 앞에    선언할 때 
		 * 3. 클래스 앞에     선언할 때 
		 * */
		
		// System.out.println( Sample.PI );
		
		Sample s = new Sample(100);
		s.plus(100);
		System.out.println( s.m );  // 110

	}

}

class Sample{
	// 인스턴스 변수
	// double pi = 3.141592;
	// final double PI = 3.141592;  // 상수
	
	// 클래스 변수
	// static final double PI = 3.141592;  // 상수
	// public final static  double PI = 3.141592;  // 상수
	
	 final int MAX_VALUE ;  // 명시적 초기화
	// 생성자
	public Sample(  int maxValue ) {
		this.MAX_VALUE = maxValue;
	}
	
	void disp() {
		// 지역변수
		final int COUNT = 10;  // 상수
	}
	
	int m = 10;
	void plus( final int n ) {  // 여기서 final 의미 ?  지역변수 앞에 final
		// n = 30;
		m += n;
	}
}















