package days27;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오전 10:18:39
 * @subject
 * @content
 */
public class Ex02 {
	
	enum Direction { EAST, SOUTH, WEST, NORTH }

	public static void main(String[] args) {

		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("EAST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println(d1); // EAST
		System.out.println(d2); // EAST
		System.out.println(d3); // EAST
		
		System.out.println(d1 == d2);
		System.out.println(d1 == d3);
		
		switch (d1) {
		case EAST: // Direction은 생략되고 상수만 적으면 된다
			break;
		case WEST:
			break;
		case SOUTH:
			break;
		case NORTH:
			break;
		}
		
		// 모든 열거형의 상수를 얻어올 때는
		Direction [] dArr = Direction.values();
		for (Direction d : dArr) {
			System.out.printf("%s_%s_%d\n", d, d.name(), d.ordinal());
		}

	}//main

}//class
