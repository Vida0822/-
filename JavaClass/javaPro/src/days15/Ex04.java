package days15;

import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 15. 오후 2:04:11
 * @subject [private로 선언된 필드에 접근하는 방법]
 * @content 1. 왜 private 접근지정자 - 필드 선언하는가?
 * 			이유? 객체명.필드명 = 값
 * 				  필드의 유효한 값만을 할당하도록 클래스를 설계하고 싶다면
 * 				  private int age라고 선언해서 클래스 외부에서 직접 age를 접근하지 못하도록 한다
 * 				  유효한 데이터만 필드에 할당하기 위해서 (가져올 수 있도록)
 * 			이유? 필드를 읽기 전용(getter만), 쓰기 전용(setter만)으로 사용할 수 있다
 * 			2. 자바에서는 getter, setter라고 부른다
 *			   읽기 용도의 메서드 getAge()
 * 			   쓰기 용도의 메서드 setAge()
 */
public class Ex04 {

	public static void main(String[] args) {
		// Person 클래스 선언
		// ㄴ default 필드 name, age, gender
		//		같은 패키지 내에서만 참조(접근) 가능
		
		// days15.Ex04
		Person p1 = new Person();
		p1.setName("홍길동");
		
		// 0~125 유효한 나이만을 입력받아서 Person 객체의 age 필드에 할당
		Scanner scanner = new Scanner(System.in);
		/*
		System.out.print("> 나이 입력 ? ");
		int age = scanner.nextInt();
		// The field Person.age [is not visible] 접근지정자 문제로 접근을 할 수 없는 상태
		// p1.age = age;
		 */
		p1.setAge(20);
		
		p1.setGender(true);
		
		System.out.printf("name=%s, age=%d, gender=%b\n", p1.getName(), p1.getAge(), p1.isGender());

	}//main

}//class
