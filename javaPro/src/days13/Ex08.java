package days13;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오후 4:30:00
 * @subject ***3차원 배열 예제***
 * @content days12.Ex04.java 참고
 */
public class Ex08 {

	public static void main(String[] args) throws IOException {
		// 세 반에 30명의 학생의 이,국,영,수,총,평,등 관리
		
		// 3행(반) 30열(학생)
		String [][] names = new String[3][30];
		double [][] avgs = new double[3][30];
		
		// 3면(반) 30행(학생) 6열(종류)
		// 0열 국어, 1열 영어, 2열 수학, 3열 총점, 4열 반등수, 5열 전체 등수
		int [][][] infos = new int[3][30][6];
		
		// 각 반의 입력받은 학생수
		int [] cnts = new int[3];
		
		char con = 'y';
		
		String name;
		int kor, eng, mat, tot, rank, wrank;
		double avg;
		 
		Scanner scanner = new Scanner(System.in);
		
		int ban; // 1,2,3 입력받은 반 저장할 변수
		
		do {
			// 1. 반 입력
			System.out.print("> 1. 반 입력 ? ");
			ban = scanner.nextInt();
			// 2. 이름,국,영,수
			System.out.printf("> 2. %d반의 [%d]번 학생 이름,국,영,수 입력하세요 ? ", ban, cnts[ban-1]+1);
			name = days12.Ex04.getName();
			kor = days12.Ex04.getScore();
			eng = days12.Ex04.getScore();
			mat = days12.Ex04.getScore();
			//    총,평,반등,전등
			tot = kor + eng + mat;
			avg = (double)tot/3;
			rank = 1;
			wrank = 1;

			// 3. 각 배열 채워넣는 코딩
			// names[행-반][열-학생] = name;
			names[ban-1][cnts[ban-1]] = name;
			avgs[ban-1][cnts[ban-1]] = avg;
			infos[ban-1][cnts[ban-1]][0] = kor;
			infos[ban-1][cnts[ban-1]][1] = eng;
			infos[ban-1][cnts[ban-1]][2] = mat;
			infos[ban-1][cnts[ban-1]][3] = tot;
			infos[ban-1][cnts[ban-1]][4] = rank;
			infos[ban-1][cnts[ban-1]][5] = wrank;
			
			// 4. 그 해당 반의 입력받은 학생수 1 증가
			cnts[ban-1]++;
			// 5. 입력 계속?
			System.out.print("> 학생 입력 계속 ? ");
			con = (char)(System.in.read());
			System.in.skip(System.in.available());
		} while (Character.toUpperCase(con) == 'Y');
		
		// 출력하기 전에 [반등수/전교등수 처리하는 코딩 추가] - 직접 구현
		
		
		// cnts 배열 - 각 반의 입력받은 학생수를 저장하는 배열
		int totalCnt = cnts[0] + cnts[1] + cnts[2];
		System.out.printf("[전체 학생 수 : %d명]\n", totalCnt);
		for (int i = 0; i < cnts.length; i++) {
			System.out.printf("[%d]반 학생 수 : %d명\n", i+1, cnts[i]);
			// [그 반의 학생 정보를 출력]
			for (int j = 0; j < cnts[i]; j++) {
				System.out.printf("\t[%d]\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\t%d\n"
						, j+1, names[i][j], infos[i][j][0], infos[i][j][1], infos[i][j][2], infos[i][j][3], avgs[i][j], infos[i][j][4], infos[i][j][5]);
			}//for j
		}//for i
		
	}//main
	
}//class
