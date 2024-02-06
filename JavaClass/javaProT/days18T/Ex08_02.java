package days18;

import days17.Employee;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오후 3:37:50
 * @subject             익명클래스( anonymous class ) == 무명 클래스 ==  이름이 없다.  
 * @content
 *                         1. 클랫의 선언과 동시에   객체 생성하는 이름이 없는 클래스.
 *                         2. 단 한번만 사용될 수 있다. 오직 하나의 객체만 생성할 수 있는 일회성 클래스이다. 
 *                         3. 주로 GUI애플리케이션(AWT,Swing)에 이벤트 처리 사용
 *                         4. 익명 클래스의 선언 형식
 *                                 (1) 형식
 *                                 new 부모클래스(){
 *                                     // 부모클래스의 메서드만 오버라이딩해서 사용할 수 있다.
 *                                 }
 *                                 (2) 형식
 *                                 new 인터페이스(){
 *                                     // 인터페이스의 추상메서드만 오버라이딩해서 사용할 수 있다. 
 *                                 }
 *
 */
public class Ex08_02 {

	public static void main(String[] args) {
		// Ctrl + mouseover
		//                          익명 클래스
		Employee emp =  new Employee() {
			
											@Override
											public int getPay() { 
												return 300000;
											} 
											
										};
										
     System.out.println(  emp.getPay() );										

	} // main 

} // class
