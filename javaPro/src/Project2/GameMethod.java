package Project2;

import java.util.Random;

public class GameMethod extends GameElemnet{
	ScoreBoard sb = new ScoreBoard();
	
	int [][] board = new int [3][3];//선수의 이름과 포인트,게임,세트를 저장할 배열
	
	Random rnd = new Random();
	int p = 1;
	
	//게임값을 체크하는 메서드
	public void gameCheck() {
		//플레이어들의 게임 차이가 1보다 크고 승자의 게임이 5보다 크지않을때 반복
		while(!(board[p][1] - board[3-p][1] > 1 && board[p][1] > 5)) {
			gameRoll();//포인트 계산해서 출력 및 게임값 증가 메서드
		}
		board[1][1] = board[2][1] = 0;//게임값 0으로 초기화
		board[p][2]++;
		//승자와 , 세트승리 숫자를 넘겨 출력하는 메서드
		sb.printSet(p, Integer.toString(board[p][2]));
	}
	
	private void gameRoll() {
		String [] score = {"0","15","30","40","WIN"};//board[p][0]
		//포인트에서 게임으로 넘어가기위한 조건(승자의 포인트가 3(40)보다 크고 플레이어들의 포인트 차이가 1보다 클때
		while(!(board[p][0]>3 && board[p][0] - board[3-p][0]>1)) {
			pointWinner(p);//랜덤 p값에 따라 승리를 정하는 메서드
			//스코어보드 printScore에 score배열의 인덱스 값을 넘기는 코딩
			sb.printScore(score[board[1][0]], score[board[2][0]]);
			if(board[1][0] == 3 && board[2][0] == 3) p = deuce();//듀스의 조건
		}
		board[1][0] = board[2][0] = 0;//포인트값 0으로 초기화
		board[p][1] ++;//승자의 게임값 1증가
		sb.printGame(p, Integer.toString(board[p][1]));//승자와 게임값을 넘겨 출력하는 메서드
	}		
	//듀스 메서드
	private int deuce() {
		String [] score = { "0","15","30","40","AD" ,"WIN"};
		//승자의 포인트가 5(WIN)이고 패자의 포인트가 3(40)이 아닐때 반복
		while (!(board[p][0] == 5 && board[3-p][0] == 3)) {
			pointWinner(p);//랜덤 p값에 따라 승리한 사람을 정하는 메서드
			if(board[3-p][0] ==4) {//패자의 포인트가 4(AD)라면
				board[3-p][0]--;
				board[p][0]--;
			}
			sb.printScore(score[board[1][0]], score[board[2][0]]);
		}
		return p;//승리한 사람을 넘긴다.
	}
	
	//승리한 사람의 포인트를 올려주는 메서드
	private void pointWinner(int p) {
		this.p = rnd.nextInt(2)+1;//p의 값이 1,2 랜덤값으로 초기화
		board[this.p][0]++;//p의 값에 따라 승리한 사람의 포인트를 올려준다.
		
	}
	public void nameSet(String[] names) {
		//String[] names을 매개변수로 넘겨 플레이어의 이름을 저장하는 메서드
		sb.setscoreBoardName(names);
	}
	
	public void setCheck(int a) {
		////승리한 세트가 a/2+1보다 작을 때까지 gameCheck()메서드를 돌린다.
		while (board[1][2] < a && board[2][2] < a) { 
			gameCheck();
		} 
	}

	public void getNames(String[] names) {
		sb.getNames(names);
		
	}

	
}
