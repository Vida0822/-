package days27;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 3:40:01
 * @subject Data[InputStream] / Data[OutputStream]
 * @content - 바이트 스트림
 * 			- 기본형 8가지를 읽기/쓰기 가능한 바이트 스트림
 */
public class Ex09_02 {

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
				FileReader reader = new FileReader(fileName);
				BufferedReader br = new BufferedReader(reader);
			) {
			String line;
			while ((line = br.readLine()) != null) {
				String [] datas = line.split(", ");
				name = datas[0];
				kor = Integer.parseInt(datas[1]);
				eng = Integer.parseInt(datas[2]);
				mat = Integer.parseInt(datas[3]);
				tot = Integer.parseInt(datas[4]);
				avg = Double.parseDouble(datas[5]);
				gender = Boolean.parseBoolean(datas[6]);
				
				System.out.printf("%s, %d, %d, %d, %d, %f, %b\n", name, kor, eng, mat, tot, avg, gender);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//main

}//class
