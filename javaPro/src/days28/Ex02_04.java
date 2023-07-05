package days28;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오전 11:22:50
 * @subject
 * @content
 */
public class Ex02_04 {

	public static void main(String[] args) {
		// [문제] days27 폴더 안에 있는 모든 자바파일(.java)만 출력
		String pathname = ".\\src\\days27";
		File file = new File(pathname);

		/*
		// String [] file.list();
		File [] list = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				String fileName = list[i].getName();
				System.out.println(fileName);
			}
		}
		 */

		// [문제] days27 폴더 안에 있는 모든 자바파일(.java)만 출력
		/* 1번째 방법
		File [] list = file.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				String fileName = list[i].getName(); // 파일명	.java
				if (fileName.endsWith(".java")) {
					System.out.println(fileName);
				}
			}
		}
		*/
		/* 2번째 방법
		File [] list = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				String fileName = list[i].getName(); // 파일명	.java
				if (fileName.endsWith(".java")) {
					System.out.println(fileName);
				}
			}
		}
		*/
		// 람다와 스트림 3번째 방법
		File [] list = file.listFiles((dir, name) -> name.endsWith(".java"));

		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile()) {
				String fileName = list[i].getName(); // 파일명	.java
				if (fileName.endsWith(".java")) {
					System.out.println(fileName);
				}
			}
		}

	}//main

}//class
