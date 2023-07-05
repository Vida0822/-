package days22;

import java.text.ChoiceFormat;

/**
 * @author ♈ kenik
 * @date 2023. 2. 24. - 오후 3:13:38
 * @subject                  ChoiceFormat  형식화 클래스
 * @content                 선택
 *                                     ㄴ 특정 범위에 속하는 값을         문자열로 반환해 준다. 
 *                                     ㄴ 불연속적인 범위의 값을 처리하는데 있어서 if문, switch문을 대신해서 사용할 수 있다.
 *
 *                                    예)   국어점수 -> 수,우,미,양,가  출력
 *                                            if문/  switch문 사용
 */
public class Ex05 {

	public static void main(String[] args) {
		int [] kors = { 100, 57,  95, 88, 77, 80, 0 };
		
		/*
		double[] limits = {0, 60,70, 80, 90};  // 낮은 값부터 범위~
		String[] formats = { "가", "양", "미", "우",  "수" }; // 반환될 문자열
		ChoiceFormat cf = new ChoiceFormat(limits, formats);
		*/
		
		//                                      #  경계값을 범위에 포함.
		//                                       <                            포함 X
		//                                      limit#value
		String newPattern = "0#가|60#양|70#미|80#우|90#수";
		ChoiceFormat cf = new ChoiceFormat(newPattern);
		
	  for (int i = 0; i < kors.length; i++) {
		System.out.printf("%d 점수 - %s  등급\n",  kors[i],     cf.format(   kors[i] )  ); 
	   }

	} // main

} // class














