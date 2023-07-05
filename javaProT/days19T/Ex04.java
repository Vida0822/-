package days19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오전 11:12:32
 * @subject    finally 문 사용
 * @content   파일 읽어서 출력... ( 암기 )
 */
public class Ex04 {

	public static void main(String[] args)  {
		String fileName = "C:\\Setup.log";
		FileReader  fr = null;
		try {
			fr = new FileReader(fileName);
			
			/*
			// fr 사용해서 파일 읽어와서 출력.
			int one = fr.read(); // 한 문자를 읽어와서 int 반환하는 메서드
			System.out.printf("%c", (char)one);
			one = fr.read(); // 한 문자를 읽어와서 int 반환하는 메서드
			System.out.printf("%c", (char)one);
			one = fr.read(); // 한 문자를 읽어와서 int 반환하는 메서드
			System.out.printf("%c", (char)one);
			*/
			int one ;
			while (  (  one = fr.read() )   != -1) {   // end of Stream 
				System.out.printf("%c", (char)one);
			}
			 
			System.out.println();
		} catch (FileNotFoundException e) { 
			System.out.println("읽고자 하는 파일이 존재하지 않습니다.");
		} catch (IOException e) { 
			e.printStackTrace();
		}  finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("= end =");

		
		 
		
	} // main

} // class







