package days04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오후 2:06:18
 * @subject 두 문자열을 비교 [시험문제]
 * @content
 */
public class Ex06 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String name = "홍길동";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("> 또 다른 이름(name2)을 입력 ? ");
		String name2 = br.readLine();
		
		System.out.println("> name = " + name);
		System.out.println("> name2 = " + name2);
		
		// 두 문자열을 == 연산자로 비교하니 false로 나옴
		// System.out.println(name == name2); // false
		
		// 참조타입 자료형 이해 필요: 배열, 클래스(String), 인터페이스
		
		// (암기) 두 문자열을 비교할 때는 == 연산자 사용 X -> equals() 함수 사용 O\
		System.out.println(name.equals(name2));

	}

}
