package days27;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오전 10:18:39
 * @subject
 * @content
 */
public class Ex03 {
	//				     0	    1	  2	     3
	// enum Direction { EAST, SOUTH, WEST, NORTH }
	// enum Direction { EAST=100, SOUTH=200, WEST=300, NORTH=400 } <- 다른 언어
	
	// The constructor Ex03.Direction(int) is undefined
	enum Direction {
		EAST(100, ">"), SOUTH(200, "v"), WEST(300, "<"), NORTH(400, "^");
		private final int value;
		private final String symbol;
		/*
		Direction(int value) {
			this.value = value;
		}
		*/
		Direction(int value, String symbol) {
			this.value = value; 
			this.symbol = symbol; 
		}
		public int getValue() {
			return this.value;
		}
		public String getSymbol() {
			return this.symbol;
		}
		
		// 추상 메서드를 선언할 수 있다
		// abstract int test(int v);
	 }
	
	/*
	enum Direction { EAST, SOUTH, WEST, NORTH } 열거형(enum) 선언
	 ㅣ
	클래스 변환
	class Direction {
		static final Direction EAST = new Direction("EAST");
		static final Direction SOUTH = new Direction("SOUTH");
		static final Direction WEST = new Direction("WEST");
		static final Direction NORTH = new Direction("NORTH");
	}
	
	enum Direction { EAST(100), SOUTH(200), WEST(300), NORTH(400) }
	 ㅣ
	클래스 변환
	 ㅣ
	*/

	public static void main(String[] args) {

		// Direction이라는 열거형의 ordinal() 메서드는 열거형 상수의 정의된 순서를 반환하는 메서드
		//											   내가 원하는 정수값으로 설정하고 싶다
		// 자바는 상수(정수값)으로 선언
		
		Direction [] dArr = Direction.values();
		for (Direction d : dArr) {
			System.out.println(d.name() + "-" + d.getValue() + "-" + d.getSymbol());
		}

	}//main

}//class
