package Project2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ScoreBoard {

	String [][] scoreBoard = createscoreBoard();
	String logFileNames;	// Log 파일 이름을 지정하기 위한 변수
	int temp = 0;
	
	//계수기 생성 메서드
	private String[][] createscoreBoard() {
		scoreBoard = new String[3][8];
		String [] menu = {"Player" , "Point" ,"1Game" , "2Game" , "3Game" , "4Game" , "5Game" , "Set"};

		for (int i = 0; i < menu.length; i++) {
			scoreBoard[0][i]=menu[i]; //전광판 0열 초기화
		}
		for (int i = 1; i < scoreBoard.length; i++) {
			for (int j = 1; j < scoreBoard[i].length; j++) {
				scoreBoard[i][j] = Integer.toString(0);//이름을 제외한 1,2 열 0으로 초기화
			}
		}

		return scoreBoard;
	}	
	//이름 저장 메서드
	public void setscoreBoardName(String[] names) {

		scoreBoard[1][0] = names[0];//이름 세팅
		scoreBoard[2][0] = names[1];//이름 세팅



	}
	//스코어를 받아오는 함수
	public void printScore(String score1, String score2) {
		scoreBoard[1][1] = score1;//스코어 세팅
		scoreBoard[2][1] = score2;//스코어 세팅
		dispscoreBoard();//출력 메서드

	}
	//세트를 받아오는함수
	public void printSet(int p, String setScore) {

		if( p == 1) scoreBoard[1][7] = setScore;//세트(Match) 스코어 초기화
		else scoreBoard[2][7] = setScore;//세트(Match) 스코어 초기화
		dispscoreBoard();//출력 메서드
		try {//enter키를 누르기전까지 일시정지 enter 입력시 다음 매치까지 출력
			System.out.print("다음 확인 : enter"); 
			System.out.println();
			System.in.read();
			System.in.skip(System.in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//계수기 출력 메서드
	private void dispscoreBoard() {
		System.out.println("Tennis Match ScoreBoard");
		System.out.println("-".repeat(75));
		for (int i = 0; i < scoreBoard.length; i++) {//전광판 출력 반복문
			for (int j = 0; j < scoreBoard[i].length; j++) {
				System.out.printf("\t%s", scoreBoard[i][j]);
			}
			System.out.println();
			System.out.println("-".repeat(75));
		}
		System.out.println("\n\n");

		// 콘솔 또는 실행 파일에 출력하면서 Log파일에 기록
		creattxtfile(scoreBoard, logFileNames);

	}
	//게임 출력 메서드
	public void printGame(int p, String gameScore) {
		int i = temp;//temp= 출력되는 배열을 증가 시키기위한 필드

		if(p==1)scoreBoard[1][2+i] = gameScore;//각 세트의 스코어를 저장하는 코딩
		else scoreBoard[2][2+i] = gameScore;////각 세트의 스코어를 저장하는 코딩
		int sbd = Math.abs(Integer.parseInt(scoreBoard[1][2+i]) - Integer.parseInt(scoreBoard[2][2+i]));

		if(Integer.parseInt(scoreBoard[p][2 + i]) >= 6 && sbd >= 2) temp++;
		//p의 2+i의 이긴 세트가 6보다 크거나 같고 플어이어의 2+i의 세트의 차이가 2보다 크거나 같을때 세트는 다음 세트로 넘어간다.
		dispscoreBoard();//출력 메서드

	}
	//로그파일 저장 메서드
	public void creattxtfile(String[][] scoreBoard, String logFileNames) {

		// Log 파일 이름 형식 및 저장 위치 설정, 저장 위치 : C:\Users\"컴퓨터 사용자의 이름"  =>  모든 컴퓨터에서 동일하게 적용됨(user.home의 기능)
		String fileName = System.getProperty("user.dir") + "\\" + logFileNames + "MatchLog.txt";

		try {
			FileWriter fw = new FileWriter(fileName, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Tennis Match ScoreBoard");
			pw.println();
			pw.println("-".repeat(75));
			for (int i = 0; i < scoreBoard.length; i++) {
				for (String line : scoreBoard[i]) {
					pw.print(line+"\t");
				}
				pw.println();
				pw.println("-".repeat(75));
			}
			pw.println("\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//이름을 받아 로그파일 이름 저장하는 메서드
	public void getNames(String[] names) {
		logFileNames = Arrays.toString(names);

	}
	//최종 승자 출력 메서드
	public void dispWinner() {
		System.out.println(scoreBoard[1][7]+":"+scoreBoard[2][7]+"(으)로 승자는 "
	+(Integer.parseInt(scoreBoard[1][7])>Integer.parseInt(scoreBoard[2][7])?
			scoreBoard[1][0]:scoreBoard[2][0]));

	}

}