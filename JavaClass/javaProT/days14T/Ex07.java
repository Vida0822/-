package days14;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 14. - 오후 2:44:54
 * @subject   객체( 클래스 )  배열  예제
 * @content   days12.Ex04.java
 *                      Student 클래스 사용 +  30 :  클래스 배열 사용 코딩 수정.
 */
public class Ex07 {

	public static void main(String[] args) throws IOException {		
	       // [한 반에 30명 학생의 이,국,영,수,총,평,등 입력/등수/출력 ]		
		    final	int STUDENT_COUNT = 30; 
			
		    // 클래스(객체) 배열
			Student[] students = new Student[STUDENT_COUNT];
			
			int cnt = 0 ;    
			char con = 'y';
			 
			String name;
			int kor, eng, mat, tot, rank;
			double avg;
			
			Scanner scanner = new Scanner(System.in);
			
			do {
				// 입력.
				System.out.print("> 이름 국어 영어 수학 정보 입력 ? ");
				name = getName();  
				kor =  getScore();    
				eng =  getScore();  
				mat =  getScore();   
				
				tot = kor + eng + mat;
				avg = (double)tot/3;
				rank = 1;
				
				students[cnt] = new Student();  // 4
				
				students[cnt].no = cnt + 1;
				students[cnt].name = name;
				students[cnt].kor = kor;
				students[cnt].eng = eng;
				students[cnt].mat = mat;
				students[cnt].tot = tot;
				students[cnt].avg = avg;
				students[cnt].rank = rank;
				
				cnt++;  // 1
				
				// 
				System.out.print("> 학생 입력 계속 ? ");
				con = (char)( System.in.read() );
				System.in.skip(System.in.available());
			} while ( Character.toUpperCase(con) == 'Y' );
			 
			// 등수처리
			// 1. 등수 처리하는 메섣 :   getRank()
			// 2. 매개변수
			// 3. 리턴값, 리터자료형
			for (int i = 0; i < cnt; i++) {    
				students[i].rank = getRank(i+1, students);
			}
			
			System.out.printf("> 입력받은 학생수 : %d명 \n",  cnt ); 
			for (int i = 0; i < cnt ; i++) {
				 System.out.println(    students[i].getStudentInfo() );
			}
			
			 
			
		} // main
		
	    // 4:05 수업 시작~
	   // 학생의 번호를 입력하면 등수를 반환하는 함수 선언
		public static int getRank( int no, Student[] students) {
			// 총점
			int tot = students[no-1].tot;
			// 모든 학생의 총점 비교  tots 배열
			int rank = 1; 
			for (int j = 0; j < students.length; j++) { 
				if( students[j]  == null ) break;
				if(   tot < students[j].tot )  rank++;   //  students[j].tot X         NullPointException
			} 
			return rank;
		}

		public static int getScore() {		
			return     (int)( Math.random()*101 ) ;
		}
		
		public static String getName() { 
			char [] nameArr = new char[3];
			Random rnd = new Random();
			for (int i = 0; i < nameArr.length; i++) {
				 nameArr[i] = (char)( rnd.nextInt('힣' - '가' + 1) + '가' );
			} 
			String name = new String( nameArr );
			return name;
		}
		
		private static int getTotalScore() {		
			return     (int)( Math.random()*301 ) ;
		}
		
		public static String getAlphabetName(int len) { 
			char [] nameArr = new char[len];
			Random rnd = new Random();
			int index = 0;
			while( index < len) { 
				 int code =  rnd.nextInt('z' - 'A' + 1) + 'A' ;		 
				 if(  Character.isAlphabetic(code)  )	{
					 nameArr[index++] = (char)code;
				 } // if
			} // while 
			String name = new String( nameArr );
			return name;
		}

	} // class
 











