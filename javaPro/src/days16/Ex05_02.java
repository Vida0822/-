package days16;

public class Ex05_02 {

	public static void main(String[] args) {
	
		// Object...args == "홍길동", 20, 178.45, true, 'A'
		System.out.printf("%s %d %.2f %b %c\n", "홍길동", 20, 178.45, true, 'A');
		
		// [가변인자를 사용할 때 주의할 점]
		// - 제일 마지막에 가변인자를 선언한다
		// = 가변인자는 내부적으로 배열을 사용한다
		// - 비효율적이다 (꼭 필요한 경우만 사용)
		// - 오버로딩 X (사용 가능하지만 안하는게 좋다)
		String [] names = {"김동현", "이혜진", "김수민", "박현주", "진예림"};
		System.out.println(concate("-",names));
		
	}//main
	
	// concate 문자열 결합하는 메서드  구분자  결합할 문자들
	public static String concate(String delim, String...args) {
		String result = "";
		for (int i = 0; i < args.length; i++) {
			result += args[i] + delim;
		}
		return result;
	}
	
}//class
