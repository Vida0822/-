package days23;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import days14.Student;

/**
 * @author ♈ kenik
 * @date 2023. 2. 27. - 오후 4:43:05
 * @subject
 * @content
 *
 */
public class Ex13 {

	public static void main(String[] args) throws IOException {
		// days14.Ex07.java 복사 + 붙이기.. 
		// 클래스 배열을 사용 -> ArrayList 사용.
		// [한 반에 30명 학생의 이,국,영,수,총,평,등 입력/등수/출력 ]		
		final	int STUDENT_COUNT = 30; 

		// 클래스(객체) 배열 -> ArrayList 사용.
		ArrayList    list = new ArrayList();

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

			Student s  = new Student();  // 4

			s.no = list.size()+1; 
			s.name = name;
			s.kor = kor;
			s.eng = eng;
			s.mat = mat;
			s.tot = tot;
			s.avg = avg;
			s.rank = rank;
			
			list.add(  s ) ;			

			// 
			System.out.print("> 학생 입력 계속 ? ");
			con = (char)( System.in.read() );
			System.in.skip(System.in.available());
		} while ( Character.toUpperCase(con) == 'Y' );

		// 등수처리 
		rankProcess( list );
		

		System.out.printf("> 입력받은 학생수 : %d명 \n",  list.size() ); 
		Iterator  ir = list.iterator();
		while (ir.hasNext()) {
			Student s = (Student) ir.next();
			System.out.println(  s  );
		}
		


	} // main

	private static void rankProcess(ArrayList list) {
		 for (int i = 0; i < list.size(); i++) {			
			 Student a = (Student) list.get(i);
			 // a.tot   a.rank			 
			 for (int j = 0; j < list.size(); j++) {
				 Student b = (Student) list.get(j);		
				if( a.tot < b.tot)  a.rank++;
			} //  
			 
		}// 
	}

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
