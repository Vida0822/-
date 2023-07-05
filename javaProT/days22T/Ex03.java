package days22;

import java.text.DecimalFormat;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 12:34:32
 * @subject    [ 형식화 클래스  4가지 ]
 * @content    Decimal[Format]  클래스
 *                        SimpleDateFormat *****
 *                        ChoiceFormat
 *                        MessageFormat
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		 // [ DecimalFormat ]
		//     - 숫자를 형식화(내가 원하는 형식) 하는 클래스
		// int money = 3257600;
		
		double money = 3257600.8;
		
		// 출력형식     3,257,600                 세자리마다 콤마를 찍어서 출력.
		// 1) String.format()
		/*
		String strMoney =  String.format("\ %,d", money);
		System.out.println(  strMoney );
		*/

		// 패턴에 사용되는 기호
		// 							 0  10진수( 값이 없을 때는 0 )
		//                              #  10진수
		//                              .   소수점
		// -   음수부호
		//                              ,  단위 구분자
		// E   지수기호
		// ;    패턴 구분자            a패턴; b패턴
		// %  퍼센트
		// \u2030   퍼밀
		//                              \u00A4    통화기호
		// '  escape  문자
		
		//  화폐단위를 붙여서 출력.
		// 소수점 2자리 꼭 나왔으면 좋겠어요..
		String pattern = "\u00A4  #,###.00";
		DecimalFormat df = new DecimalFormat(pattern);
		String strMoney = df.format(money);
		System.out.println( strMoney );
		
	} // main

} // class

/*
// 그럼 #은 생략이 가능하다고 생각해도 되나요?
double money = 123456.78;
// String pattern = "#.####";
// String pattern = "#.0000";
// String pattern = "0000000000.0000";
String pattern = "##########.0000";
DecimalFormat df = new DecimalFormat(pattern);
System.out.println(  df.format(money)  );
*/
