package days22;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 3:07:32
 * @subject
 * @content
 *
 */
public class Ex03_02 {

	public static void main(String[] args) {
		String strMoney = "1,234,567";
		int money ;
		
		/*
		money = Integer.parseInt( strMoney.replaceAll(",", "")  );  // 1234567
		*/
		
		String pattern = "#,###";
		DecimalFormat df = new DecimalFormat(pattern);
		try {
			Number  num = df.parse(strMoney);
			// Number -> int 형 변환
		    money =	num.intValue();
			System.out.println( money );
		} catch (ParseException e) { 
			e.printStackTrace();
		}
		
		

	} // main

} // class











