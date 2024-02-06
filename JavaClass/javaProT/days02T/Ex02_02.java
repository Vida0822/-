package days02;

/**
 * @author kenik
 * @date  2023. 1. 27. - 오후 2:16:57
 * @subject   printf() 예제
 * @content 
 *
 */
public class Ex02_02 {

	public static void main(String[] args) {
		 String name = "홍길동";
		 int age = 20;
		 double avg = 98.76;		 
		 // 이름은 홍길동이고, 나이는 20살이고, 평균은 98.76이다.
		 /*
		 System.out.println("이름은 " + name+"이고, 나이는 " 
		 + age + "살이고, 평균은 " + avg +"이다.");
		 */		 
		 /*
		 String  %s
		 int        %d
		 double  %f  소수점 6자리 까지 출력... 
		 */
		 System.out.printf("이름은 %s이고, 나이는 %d살이고, 평균은 %f이다."
				 , name, age, avg);
		 

	} // main

} // class








