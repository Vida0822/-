package days14;

// 시간 클래스 
public class Time {
	
	// 필드
	public int hour;
	int minute;
	protected int second;
	private int milisecond;  // 밀리 세컨트     1/1000초                  1000ms = 1초
	public int nano;           // 나노 세컨드    1/1000000000 초
	
	// 메서드 
	public void printTime() {
		
		// private 
		milisecond = 100;
		hour = 1;
		
	}
	
	
}
