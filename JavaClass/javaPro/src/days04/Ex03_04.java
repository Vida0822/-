package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오후 12:13:41
 * @subject 쉬프트(shift) 연산자 >> >>> <<
 * @content (비트 연산자)
 * 			shift == 교대하다
 */
public class Ex03_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(15 >> 2); // 첫 부호 비트 1이면 모두 1, 0이면 모두 0으로 채우겠다
		System.out.println(15 >>> 2); // 비어있는 칸을 무조건 0으로 채우겠다
		System.out.println(15 << 2); // 비어있는 칸을 무조건 0으로 채우겠다
		
		// 15	0000 1111 >> 2
		//		0000 0011 -> 3
		
		// 15   0000 1111 << 2 // 무조건 0으로 채운다
		//      0011 1100 -> 60

	}//main

}//class
