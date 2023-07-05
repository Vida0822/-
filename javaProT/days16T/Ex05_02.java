package days16;

/**
 * @author ♈ kenik
 * @date 2023. 2. 16. - 오후 12:35:44
 * @subject
 * @content
 *
 */
public class Ex05_02 {
	
	public static void main(String[] args) {
		// Object ... args  == "홍길동", 20, 178.45, true , 'A
		System.out.printf("%s %d %.2f %b %c\n" ,          "홍길동", 20, 178.45, true , 'A');
		
		// [가변 인자를 사용할 때 주의할 점]
		// - 제일 마지막에 가변 인자를 선언한다. 
		// - 가변인자를 내부적으로 배열을 사용한다. 
		// - 비효율적이다. ( 꼭 필요한 경우 )
		// - 오버로딩을 하지 않는 게 좋을 거 같다.
		String [] names = { "김동현", "이혜진", "김수민", "박현주", "진예림" };
		System.out.println(   concate("-", names)  );
		
	}
	
	// concate  문자열 결합하는 메서드       구분자            결합할문자들
	// public static String concate( String...args,   String delim ) {
	public static String concate( String delim , String...args   ) {
		String result = "";
		for (int i = 0; i < args.length; i++) {
			result += args[i] + delim;
		}
		return result;
	}
	
	public static String concate(  String...args   ) {
		String result = "";
		for (int i = 0; i < args.length; i++) {
			result += args[i] + "/";
		}
		return result;
	}
	
}
