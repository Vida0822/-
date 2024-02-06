package days15;

import java.awt.*;
import java.awt.event.*;

// 4:00 수업 
public class MyApp extends Frame implements WindowListener{

	// 디폴트 생성자
	public MyApp() {
		init(); // 메서드 호출 부분
	}

	// 초기화 메서드
	private void init() {
		System.out.println("MyApp.init( ) 호출됨...");
		
		this.setTitle("새 윈도우 (창)"); 
		this.setSize(400,400);
		
		// this.addWindowListener( new 윈도우리스너() );
		// this.addWindowListener( new 윈도우어댑터()  );
		
		//                                     new MyApp(); 이 인스턴스 == this 
		this.addWindowListener( this ); // 단독으로 사용되는 this 용도 - 매개변수 
		
		this.setVisible(true);
		
		// 닫기(X) 버튼을 클릭하면 프로그램 종료
		// 자바에서  이벤트 처리 :  ~Listener(청취자), ~Adapter 
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료!!!");
		System.exit(-1);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
} // class

class 윈도우어댑터 extends WindowAdapter{
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료!!!");
		System.exit(-1);
	}
}

class 윈도우리스너 implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료!!!");
		System.exit(-1);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}






