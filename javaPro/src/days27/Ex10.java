package days27;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
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
 * 
 * 			오후 프로젝트 + 수/목 + 금(발표) PPT + 오라클 수업
 */
public class Ex10 {

	public static void main(String[] args) {

		String name = "진예림";
		int kor = 87, eng = 79, mat = 80;
		int tot = kor + eng + mat;
		double avg = (double)tot/3;
		boolean gender = true;
		
		String fileName = ".\\src\\days27\\student.dat"; // data
		
		try (
				FileOutputStream out = new FileOutputStream(fileName, true);
				DataOutputStream dos = new DataOutputStream(out)
			) {
			
			dos .writeUTF(name);
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(mat);
			dos.writeInt(tot);
			dos.writeDouble(avg);
			dos.writeBoolean(gender);
			
			dos.flush();
			System.out.println("end");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//main

}//class
