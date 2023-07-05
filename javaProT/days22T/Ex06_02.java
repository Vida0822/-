package days22;

import java.text.MessageFormat;
import java.text.ParseException;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 3:26:50
 * @subject    MessageFormat 형식화 클래스
 * @content     ㄴ 어떤 값( 데이터 )을 정해진 형식에 맞게 출력. 
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		// 이름
		// 나이
		// 성별
		/*
		String [] datas  =  source.split(",");
		 String name =  datas[0].substring(  datas[0].indexOf(":")+1 );
		 System.out.println( name );
		 
		 int age =  Integer.parseInt(   datas[1].substring(  datas[1].indexOf(":")+1 ).replace("살", "") );
		 System.out.println( age );
		*/ 
		String source   =   "이름:신희민, 나이:20살, 성별:여자";
		String pattern = "이름:{0}, 나이:{1}살, 성별:{2}";
		MessageFormat mf = new MessageFormat(pattern);
		try {
			Object [] objs =  mf.parse(source);
			for (Object obj : objs) {
				System.out.println( obj );
			}
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		
		
		
	}

}
