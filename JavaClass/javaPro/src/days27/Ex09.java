package days27;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 3:40:01
 * @subject Data[InputStream] / Data[OutputStream]
 * @content - 바이트 스트림
 * 			- 기본형 8가지를 읽기/쓰기 가능한 바이트 스트림
 * 
 * 			Ex09.java -> Ex10.java
 * 			Ex09_02.java -> Ex10_02.java
 */
public class Ex09 {

	public static void main(String[] args) {

		String name = "박민종";
		int kor = 87, eng = 79, mat = 80;
		int tot = kor + eng + mat;
		double avg = (double)tot/3;
		boolean gender = true;
		
		// 한 학생 정보를 student.txt 파일에 저장
		// [FileWriter 와 BufferedWriter]		FileOutputStream / BufferedOutputStream
		String fileName = ".\\src\\days27\\student.txt";
		
		try (
				// 문자 스트림
				FileWriter writer = new FileWriter(fileName, true);
				BufferedWriter bw = new BufferedWriter(writer);
			) {
			// bw.write(name);		bw.write(kor);
			String data = String.format("%s, %d, %d, %d, %d, %f, %b\n", name, kor, eng, mat, tot, avg, gender);
			bw.append(data);
			bw.flush(); // 저장
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//main

}//class
