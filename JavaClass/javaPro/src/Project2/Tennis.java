package Project2;

import java.io.IOException;

public class Tennis {
	public static void main(String[] args) {
		Player pl = new Player();
		pl.createMatch();
		GameMethod g = new GameMethod();
		String names[] = pl.getNames();
		int a = pl.getsetNumber();
		
		//계수기에 이름 반영
		g.nameSet(names);	
		
		// Log 파일 생성 시 파일 제목에 이름 반영
		g.getNames(names);			
		
		// 5판 3선일 경우 3, 3판 2선일경우 2인 a를 넘겨 세트의 수를 셋팅하는 메서드
		g.setCheck(a);					
				

		g.sb.dispWinner();//최종승자 출력 메서드
		//게임 종료
		try {
			System.out.println("게임이 끝났습니다. Enter를 누르면 종료합니다.");
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
