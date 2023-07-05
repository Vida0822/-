package days09;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03_05 {

	public static void main(String[] args) {
		// *** [ 람다식 + 스트림 ] ***
		// -> 람다 연산자.
        IntStream st = new Random().ints(1, 46);
		Stream<String> lotto =  st.distinct().limit(6).sorted().mapToObj(i -> i +", ");
		lotto.forEach(System.out::print);
		
	} // main

} // class
