package days27;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * @author dlsgu
 * @date 2023. 3. 6. 오후 2:34:57
 * @subject
 * @content
 */
public class Ex07_02 {

	public static void main(String[] args) {
		// [String[Reader] / String[Writer] 메모리 스트림]
		String source = "package days27;\r\n"
			+ "\r\n"
			+ "/**\r\n"
			+ " * @author ♈ k§nik\r\n"
			+ " * @date 2023. 3. 6. - 오전 10:17:50\r\n"
			+ " * @subject  \r\n"
			+ " * @content\r\n"
			+ " *\r\n"
			+ " */\r\n"
			+ "public class Ex03 {\r\n"
			+ "   //                                   0          1            2             3\r\n"
			+ "   // enum Direction { EAST=100, SOUTH=200, WEST=300, NORTH }\r\n"
			+ "   \r\n"
			+ "   // The constructor Ex03.Direction(int) is undefined\r\n"
			+ "   enum Direction { \r\n"
			+ "         EAST(100, \">\"), SOUTH(200, \"V\"), WEST(300, \"<\"), NORTH(400, \"^\");\r\n"
			+ "            private final int value;\r\n"
			+ "            private final String symbol;\r\n"
			+ "            /*\r\n"
			+ "         Direction(int value) {\r\n"
			+ "              this.value= value;\r\n"
			+ "         }\r\n"
			+ "         */\r\n"
			+ "         Direction(int value, String symbol) {\r\n"
			+ "            this.value = value;\r\n"
			+ "            this.symbol = symbol;\r\n"
			+ "         }\r\n"
			+ "         public int getValue() {\r\n"
			+ "            return this.value;\r\n"
			+ "         }\r\n"
			+ "         public String getSymbol() {\r\n"
			+ "            return this.symbol;\r\n"
			+ "         }\r\n"
			+ "         \r\n"
			+ "         // 추상 메서드 선언할 수 있더라..\r\n"
			+ "         //abstract int test(int v);\r\n"
			+ "   }\r\n"
			+ "   \r\n"
			+ "   /*\r\n"
			+ "   enum Direction { EAST, SOUTH, WEST, NORTH }  열거형(enum) 선언\r\n"
			+ "        ↓\r\n"
			+ "   클래스 변환\r\n"
			+ "        ↓\r\n"
			+ "   class Direction{\r\n"
			+ "        static final Direction EAST = new Direction(\"EAST\");\r\n"
			+ "        static final Direction SOUTH = new Direction(\"SOUTH\");\r\n"
			+ "        static final Direction WEST = new Direction(\"WEST\");\r\n"
			+ "        static final Direction NORTH = new Direction(\"NORTH\");\r\n"
			+ "   }     \r\n"
			+ "   \r\n"
			+ "   enum Direction { EAST(100), SOUTH(200), WEST(300), NORTH(400) }\r\n"
			+ "       ↓\r\n"
			+ "   클래스 변환\r\n"
			+ "   class Direction{\r\n"
			+ "        static final Direction EAST = new Direction(\"EAST\");\r\n"
			+ "        static final Direction SOUTH = new Direction(\"SOUTH\");\r\n"
			+ "        static final Direction WEST = new Direction(\"WEST\");\r\n"
			+ "        static final Direction NORTH = new Direction(\"NORTH\");\r\n"
			+ "        \r\n"
			+ "        static int value;\r\n"
			+ "        public Direction(int){\r\n"
			+ "        \r\n"
			+ "        }\r\n"
			+ "   } \r\n"
			+ "   */\r\n"
			+ "   \r\n"
			+ "   public static void main(String[] args) {\r\n"
			+ "      \r\n"
			+ "      // Direction 이라는 열거형의    ordinal() 메서드는 열거형 상수의 정의된 순서를 반환하는 메서드 \r\n"
			+ "      //                                                                              내가 원하는 정수값으로 설정하고 싶다. \r\n"
			+ "      // 자바는  (정수값)\r\n"
			+ "        \r\n"
			+ "       Direction [] dArr = Direction.values();\r\n"
			+ "       for (Direction d : dArr) {\r\n"
			+ "         System.out.println( d.name() +\" - \" + d.getValue() +\" - \" +d.getSymbol() );\r\n"
			+ "      }\r\n"
			+ "   }\r\n"
			+ "\r\n"
			+ "}\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "";

		// System.out.println(source);
		// [문제] source 문자열에서 [15번째 라인]의 문자열을 출력하는 코딩을 하세요
		// 결과 : "   enum Direction { "
		/*
		String regex = "\r\n";
		String [] sources = source.split(regex);
		
		for (int i = 0; i < sources.length; i++) {
			System.out.printf("%d : %s\n", i+1, sources[i]);
		}
		
		System.out.println(sources[14]);
		*/
		
		// 라인단위로 처리할 수 있는 보조스트림 : BufferedReader
		
		// 문자열 source -> StringReader 메모리 스트림 in -> 라인 단위로 처리 -> BufferedReader 보조스트림
		
		
		try (
				StringReader in = new StringReader(source);
				BufferedReader br = new BufferedReader(in);
			){
			int i = 1;
			while (i++<=14) br.readLine();
			
			String line15 = br.readLine();
			
			System.out.println(line15);
			
		} catch (Exception e) {
		}
		
	}//main

}//class
