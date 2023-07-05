package days27;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 3:40:01
 * @subject Data[InputStream] / Data[OutputStream]
 * @content - 바이트 스트림
 * 			- 기본형 8가지를 읽기/쓰기 가능한 바이트 보조 스트림
 */
public class Ex10_02 {

	public static void main(String[] args) {

		String name = "박민종";
		int kor = 87, eng = 79, mat = 80;
		int tot = kor + eng + mat;
		double avg = (double)tot/3;
		boolean gender = true;
		
		String fileName = ".\\src\\days27\\student.dat";
		
		try (
				FileInputStream in = new FileInputStream(fileName);
				DataInputStream dis = new DataInputStream(in);
			) {
			
			name = dis.readUTF();
			kor = dis.readInt();
			eng = dis.readInt();
			mat = dis.readInt();
			tot = dis.readInt();
			avg = dis.readDouble();
			gender = dis.readBoolean();
				
			System.out.printf("%s, %d, %d, %d, %d, %f, %b\n", name, kor, eng, mat, tot, avg, gender);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//main

}//class
