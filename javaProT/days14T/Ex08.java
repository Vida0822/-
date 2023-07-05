package days14;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오후 4:25:39
 * @subject 
 * @content 
 */
public class Ex08 {

	public static void main(String[] args) {
		/*
		 *  1. 클래스 앞에 붙는 접근지정자, 기타제어자 설명. ( 암기 ) 
		 *  2. 멤버( 필드, 메서드, 생성자 constructor )   앞에 붙는 접근지정자 설명 ( 암기 ) 
		 *      1) public               - 패키지 내부 /외부 어디서나 접근(참조) 가능
		 *      2) default           - 같은 패키지 내부에서만 접근(참조) 가능
		 *      3) protected      -  defulat + 상속( 다른 패키지의 자식 클래스에 접근(참조) 가능 )
		 *      4) private           -  같은 클래스 내에서만 접근(참조) 가능
		 *      
		 *      범위 :    public        >         protected      >     default     >     private
		 *      
		 *      지역변수에는 접근 지정자를 사용할 수 없다. 
		 * */

		// public days14.Time 클래스  - 패키지 내부/외부 어디서나 참조/상속 가능 
		//           days14.Ex08.main(){}  같은 패키지 안.. 테스트
		Time t = new Time();
		// t.멤버 ( 필드, 메서드 )
		// t.hour      O         public 
		// t.minute  O         defalut
		// t.second   O         protected
		// t.nano        O   public
		
		// t.milisecond  X   private  같은 클래스 에서만 참조(접근) 가능
		
		
		//           days01.Ex01.main(){}    다른 패키지       테스트
		
		
	} // main

} // class











