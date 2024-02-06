package days19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오전 11:29:07
 * @subject    한 라인 읽어와서 출력 
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		String fileName = "C:\\Setup.log";
		
		FileReader fr = null;
		BufferedReader br = null; // 버퍼 기능 + 라인 단위로 처리하는 리더기
		
		// 12:05 수업 시작~ 
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr); // 업캐스팅
			String line ;
			while(     ( line= br.readLine() ) != null    ) {
				System.out.println( line );
			}
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		}

	} // main

} // class










