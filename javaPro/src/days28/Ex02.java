package days28;

import java.io.File;
import java.io.IOException;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오전 10:21:00
 * @subject [File 클래스]
 * @content 1) 가장 많이 사용되는 입출력 대상
 * 			2) File 클래스는 파일 + 폴더(디렉토리)
 * 			3) 생성자 + 메서드
 * 				File(fileName)
 * 				File(String pathName, String fileName)
 * 					 .\src\days28		Ex01.java
 * 				File(File 경로, String fileName)
 * 				File(URL)
 * 
 * 				getName() 파일명을 반환하는 메서드
 * 				getPath() 경로를 반환하는 메서드
 * 				getAbsolutePath()
 * 				getCanoicalPath()
 * 				
 * 				pathSeparator : 경로(path) 구분자 - 운영체제마다 다르다
 * 
 * 
 */
public class Ex02 {

	public static void main(String[] args) throws IOException {
		String pathname = ".\\src\\days28\\Ex01.java"; // 파일
		// String pathname = ".\\src\\days28"; // 디렉토리
		File parent = new File(pathname);
		
		// System.out.println(file.isDirectory()); // 디렉토리 false
		// System.out.println(file.isFile()); // 파일 true
		String child = "Ex01.java";
		File file = new File(parent, child);
		
		System.out.println(file.getName()); // Ex01.java
		
		String fileName = file.getName();
		int pos = fileName.indexOf(".");
		System.out.println(fileName.substring(0, pos)); // 순수한 파일명 Ex01
		System.out.println(fileName.substring(pos)); // 확장자 .java
		
		System.out.println(file.getPath()); // .\src\days28\Ex01.java\Ex01.java
		System.out.println(file.getAbsolutePath()); // C:\Class\Workspace\Javaclass\javaPro\.\src\days28\Ex01.java\Ex01.java
		System.out.println(file.getCanonicalPath()); // C:\Class\Workspace\Javaclass\javaPro\src\days28\Ex01.java\Ex01.java
		
		// 파일이 속해있는 디렉토리
		System.out.println(file.getParent()); // .\src\days28\Ex01.java
		System.out.println(file.pathSeparator); // ;
		System.out.println(file.separator); // \
		
	}//main

}//class
