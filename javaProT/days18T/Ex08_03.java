package days18;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오후 3:48:45
 * @subject
 * @content
 *
 */
public class Ex08_03 {

	public static void main(String[] args) {
		
		new MyForm();

	} // main

} // class

class MyForm extends Frame{
	
	// 버튼 생성
	Button btnExit = null;
	
	// 디폴트 생성자
	MyForm(){
		// btnExit
		this.btnExit = new Button();
		this.btnExit.setLabel("Exit"); 
		
		//
		this.setTitle("윈폼");
		this.setSize(400, 400);
		
		// this.addWindowListener( new 윈도우어댑터() );  // 2) 객체 생성
		
		                          //  1) 클래스 선언 + 2) 객체 생성 ==> 익명클래스 구현. 
		this.addWindowListener( 
				                                         new WindowAdapter() {
				                                        	 @Override
				                                        		public void windowClosing(WindowEvent e) {
				                                        			System.out.println("프로그램 종료!!!");
				                                        			System.exit(-1);
				                                        		}
		                                                 }
				                                      );  
		// 버튼 클릭할때 이벤트 처리 등록 - ActionListener  익명클래스 사용. 
		this.btnExit.addActionListener( 
				                                                   new ActionListener() {  // 인터페이스

																	@Override
																	public void actionPerformed(ActionEvent e) {
																		
																		System.out.println(" 버튼 클릭됨....");
																		System.exit(-1);
																		
																	} 
				                                                   }
				                                                 );  
		 
	    this.add( this.btnExit );
		this.setVisible(true);
		// X 닫기 버튼 클릭..
	}
	
}  // MyForm

/*
// 1) 클래스 선언
class 윈도우어댑터 extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료!!!");
		System.exit(-1);
	}
}
*/









