package days28;

import java.io.File;
import java.util.Date;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오전 10:40:02
 * @subject javaPro 모든 하위 폴더 (목록) 정보 조회
 * @content 재귀 함수
 */
public class Ex02_02 {

	public static void main(String[] args) {
		// javaPro 폴더 안에 하위 폴더 + 파일 정보 조회(출력)
		String currentDirectory = System.getProperty("user.dir");
		// C:\Class\Workspace\Javaclass\javaPro
		// System.out.println(currentDirectory);
		File parent = new File(currentDirectory);
		// System.out.println(parent.isDirectory()); // true
		
		/*
		String [] list = parent.list();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		*/
		
		// [문제] 1678147516417 ->	"2023-12-01 오전 12:23"
		String pattern = "yyyy-MM-dd";
		
		File [] list = parent.listFiles();
		for (int i = 0; i < list.length; i++) {
			Date date = new Date(list[i].lastModified());
			
			System.out.printf("%s\t%s\t%s\t%s\n"
								, list[i].isDirectory() ? "[폴더]" : "[파일]"
								, list[i].getName()
		//						, sdf.format(date) // 수정된 날짜 정보
								, list[i].isFile() ? list[i].length() + "(bytes)" : "");
		}
		
	}//main

}//class
