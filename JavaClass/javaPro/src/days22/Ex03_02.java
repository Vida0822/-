package days22;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex03_02 {

	public static void main(String[] args) {
		String strMoney = "1,234,567";
		int money;
		
		/*
		money = Integer.parseInt(strMoney.replaceAll(",", "")); // 1234567
		System.out.println(money);
		*/
		
		String pattern = "#,###";
		DecimalFormat df = new DecimalFormat(pattern);
		try {
			Number num = df.parse(strMoney);
			// Number -> int 형변환
			money = num.intValue();
			System.out.println(money);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
