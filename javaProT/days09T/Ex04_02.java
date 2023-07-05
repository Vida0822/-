package days09;

/**
 * @author kenik
 * @date  2023. 2. 7. - 오후 4:07:53
 * @subject 
 * @content 
 *
 */
public class Ex04_02 {

	public static void main(String[] args) {
		// [ String 클래스의 메서드 ]
		String card ="7655-8988-9234-5677";
		// 1. 문자열의 길이 : length()
		System.out.println( card.length() );
		// 2. charAt(i)
		for (int i = 0; i < card.length(); i++) {
			System.out.printf("'%c'\n",    card.charAt(i));
		}
		// 3. String.format()
		String name = "hong";
		int age = 20;
		String output =  String.format("name=%s, age=%d", name, age);
		System.out.println(  output );
		
		// 4.	String.matches()
		String regex = "\\d{3}";
		System.out.println( "100".matches(regex) );
		
		// 5. split()   + trim()
		String input = "홍길동, 89, 28, 98";  // 이름, 국어, 영어, 수학
		String [] datas = input.split(",");
		name =  datas[0];
		int kor = Integer.parseInt( datas[1].trim() );   // "_98"
		int eng = Integer.parseInt( datas[2].trim() );
		int mat = Integer.parseInt( datas[3].trim() );
		
		// 6. 문자열 비교   equals(), equalsIgnoreCase()
		// "".equals("")
		// "".equalsIgnoreCase("")
		
		// 7. join()   각 배열의 요소를  원하는 구분자로 결합해서 반환하는 메서드 
		
		// 8. substring() ***
		
		

	} // main

}  // class







