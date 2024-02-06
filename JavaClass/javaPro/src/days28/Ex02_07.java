package days28;

import java.io.File;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오후 12:13:14
 * @subject
 * @content
 */
public class Ex02_07 {

	public static void main(String[] args) {
		/*
		String pathname = ".\\upload\\temp";
		File f = new File(pathname);
		
		if (!f.exists()) {
			// 폴더 생성
			// System.out.println(f.mkdir()); 하위 폴더 있어서 생성 불가
			System.out.println(f.mkdirs());
		}
		*/
		
		String pathname = ".\\upload";
		File f = new File(pathname);
		
		if (f.exists()) {
			// upload 폴더 삭제
			// 	ㄴ temp 폴더 삭제
			// System.out.println(f.delete()); 하위 폴더가 존재해서 삭제 불가
			
			// 재귀 함수를 만들어서 삭제하면 된다
			directoryDelete(f);
		}

	}//main

	private static void directoryDelete(File f) {
		while (!f.delete()) {
			// 하위 목록
			File [] list = f.listFiles();
			for (int i = 0; i < list.length; i++) {
				if (list[i].delete()) {
					System.out.printf("%s 삭제 완료", list[i]);
				} else { // 하위 폴더 존재
					directoryDelete(list[i]);
				}
			}//for
		}//while
		
	}

}//class
