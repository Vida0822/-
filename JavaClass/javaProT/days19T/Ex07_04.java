package days19;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오후 4:31:05
 * @subject 
 * @content 
 */
public class Ex07_04 {

	public static void main(String[] args) {
		//  dir 문자열 속에 마지막문자열이   '\\' 인지 여부 체크해서 
		String dir = "C:\\temp\\test\\";
		String fileName = "aaa.html";
		
		// dir.length()
		String fullPath ;
		if( dir.charAt( dir.length()-1)  == '\\') {
			fullPath =  dir.concat(fileName);
		}else {
			fullPath =  dir.concat("\\").concat(fileName);
		} 		
		System.out.println( fullPath );
		
		//  C:\temp\test\aaa.html
		
		// [질문] 전체경로에서 파일명만 얻어오고 싶어요.               aaa.html
		//         마지막 위치의  \ 뒤의 문자열 얻어오면 파일명.. 
		/*
		for (int i = 0; i < fullPath.length(); i++) {
			System.out.printf("%d - %c\n", i , fullPath.charAt(i));
		}
		*/
		
		// int idx =  fullPath.indexOf("\\");
		int idx =  fullPath.lastIndexOf("\\");
		System.out.println(   fullPath.substring(  idx + 1 )  );
		
		// [질문] 전체경로에서 확장자만 얻어오고 싶어요 ..             .html
		//            . 위치 찾아서 그 뒤의 확장자를 얻어오겠다.
		idx = fullPath.lastIndexOf(".");
		System.out.println(   fullPath.substring(idx+1)  );
		
	   // 5:09 수업 시작~ 
		
 
		
		

	} // main

}// class



