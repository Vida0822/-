package days22;

import java.text.MessageFormat;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 3:26:50
 * @subject    MessageFormat 형식화 클래스
 * @content     ㄴ 어떤 값( 데이터 )을 정해진 형식에 맞게 출력.
 *
 *                          System.out.printf("format", args);
 *                          String  String.format("format", args);
 */
public class Ex06 {

	public static void main(String[] args) {
		String name = "신희민";
		int age = 20;
		boolean gender = false;
		
		// 출력형식   -              "이름:신희민, 나이:20살, 성별:여자"
		/*
		String str =  String.format("이름:%s, 나이:%d살, 성별:%s",  name, age, gender ? "남자" : "여자");
		System.out.println( str  );
		*/
		
		String pattern = "이름:{0}, 나이:{1}살, 성별:{2}";
		
		// MessageFormat mf = new MessageFormat(pattern);
		// mf.format();
		
		// static 메서드 format()은 객체 생성할 필요없이 클래스명.static메서드 
		String str =  MessageFormat.format(pattern,  name, age, gender ? "남자" : "여자");
		System.out.println( str );
	

		// SQL
		pattern = "INSERT INTO board ( no, title, writer, content, regdate ) "
				+ " VALUES ( {0}, '{1}','{2}', '{3}',{4} )";
	}

}
