package days19;

/**
 * @author dlsgu
 * @date 2023. 2. 21. 오후 4:23:37
 * @subject
 * @content
 */
public class Ex07_04 {

	public static void main(String[] args) {
		// dir 문자열 속에 마지막 문자열이 '\\'인지 여부 체크해서
		String dir = "C:\\temp\\test";
		String fileName = "aaa.html";
		String fullPath;
		if(dir.charAt(dir.length()-1) == '\\') {
			fullPath = dir.concat(fileName);
		} else {
			fullPath = dir.concat("\\").concat(fileName);
		}
		System.out.println(fullPath);
		// C:\temp\test\aaa.html
		
		/*
		for (int i = 0; i < fullPath.length(); i++) {
			System.out.printf("%d - %c\n", i, fullPath.charAt(i));
		}
		*/
		
		// [질문] 전체경로에서 파일명만 얻어오고 싶다 aaa.html
		// 마지막 위치의 \ 뒤의 문자열을 얻어오면 파일명
		// int idx = fullPath.indexOf("\\");
		int idx = fullPath.lastIndexOf("\\");
		System.out.println(fullPath.substring(idx+1));
		
		// [질문] 전체경로에서 확장자만 얻어오고 싶다 html
		// .위치 찾아서 그 뒤의 문자열을 얻어오면 확장자
		idx = fullPath.lastIndexOf(".");
		System.out.println(fullPath.substring(idx+1));
		
	}//main

}//class
