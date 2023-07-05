package days28;

import java.io.File;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오전 11:15:31
 * @subject
 * @content
 */
public class Ex02_03 {

	public static void main(String[] args) {
		
		String pathname = ".\\src\\days28\\Ex01.java";
		File file = new File(pathname);
		
		// 파일 또는 폴더 존재 유무 확인 : boolean exists()
		System.out.println(file.exists()); // true
		
		if (file.isFile() && file.exists()) {
			// 파일 - 속성 - 특성
			System.out.println(file.canRead()); // 읽기 가능 여부 true
			System.out.println(file.canWrite()); // 쓰기 가능 여부 true
			System.out.println(file.canExecute()); // 실행 가능 여부 true
			System.out.println(file.isHidden()); // 숨김 파일 여부 false
		}

	}//main

}//class
