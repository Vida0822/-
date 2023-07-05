package days28;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오전 9:05:26
 * @subject gab == 510
 * @content [RandomAccessFile]
 * 			랜덤하게 + 접근 + 파일 스트림
 * 			파일의 어느 위치에나 읽기/쓰기가 가능한 장점이 있는 스트림
 * 			readXXX()
 * 			writeXXX()
 * 			seek(위치)
 */
public class Ex01 {

	public static void main(String[] args) throws IOException {
		String s = "I Love normal Java";
		String q = "javabook";
		
		// RandomAccessFile을 사용해서 파일 쓰기(저장)
		String name = ".\\src\\days28\\random.txt";
		String mode = "rw"; // read, write
		try (RandomAccessFile raf = new RandomAccessFile(name, mode)) {
			// raf.getFilePointer(); 파일 포인터
			raf.writeBytes(s); // I Love normal Java
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("> 엔터 치면 진행합니다");
		System.in.read(); // 일시 정지
		System.in.skip(System.in.available()); // 13, 10 제거
		
		try (RandomAccessFile raf = new RandomAccessFile(name, mode)) {
			// 임의의 위치로 FP를 이동시킨 후 쓰기
			raf.seek(7); // 파일 포인터(file-pointer) == 파일 위치
			raf.writeBytes(q); // I Love javabookava
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("> 엔터 치면 진행합니다");
		System.in.read(); // 일시 정지
		System.in.skip(System.in.available()); // 13, 10 제거
		
		try (RandomAccessFile raf = new RandomAccessFile(name, mode)) {
			// 임의의 위치로 FP를 이동시킨 후 쓰기
			// I_Love
			raf.seek(2); // 파일 포인터(file-pointer) == 파일 위치
			String line = raf.readLine();
			System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end");

	}//main

}//class

/*
 * mode = "rw" "r" "rwd" "rws"
 * seek(pos)
 * writeXXX()
 * readXXX()
 * skipBytes(n) 지정된 n만큼 바이트를 건너뛰는 메서드
 * length() 파일의 크기를 반환하는 메서드 (byte)
 * */
