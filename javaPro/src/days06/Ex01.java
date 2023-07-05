package days06;

/**
 * @author dlsgu
 * @date 2023. 2. 2. - 오전 9:48:37
 * @subject 
 * @content 
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// (for) 1+3+5+7+9=25
		// 질문1) for문 안에 초기식 int i=1 선언 -> 메인함수에서 사용 불가
		//			for문 밖에 		int i=1 선언 -> 메인함수에서 사용 가능
		/*
		// 조건식 X -> 무한루프
		int sum = 0;
		int i = 1;
		for ( ; ; ) {
			if(i>10) break;
			System.out.printf("%d+", i);
			sum += i;
			i++;
		}//for
		// 에러: Unreachable code -> 무한루프 때문에 도달하지 않는다
		System.out.printf("=%d\n", sum);
		*/
		
		/*
		// for문 초기식, 증감식 여러개 사용 가능
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d+", i);
			sum += i;
		}//for
		System.out.printf("=%d\n", sum);
		// 에러: i cannot be resolved to a variable -> for문에서만 사용돼서 메인함수에서 선언되지 않았다 판단
		// System.out.println(i);
		*/
		
		/*
		// 초기식, 증감식 원하는대로 설정 가능
		int sum = 0;
		for (int i = 10; i > 0; i--) {
			System.out.printf("%d+", i);
			sum += i;
		}//for
		System.out.printf("=%d\n", sum);
		*/
		
		/*
		// (while) 1+3+5+7+9=25
		// +=65 나온 이유?
		// [디버깅]
		int i = 1;
		int sum = 0;
		while (i<=10) {
			System.out.printf("%d+", i);
			sum += i;
			i++;
		}//while
		System.out.printf("=%d\n", sum);
		*/
		
		/*
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.printf("%d+", i); //출력
				sum += i; //누적
			}//if
		}//for
		System.out.printf("=%d", sum);
		*/
		
		/*
		int sum = 0;
		for (int i = 1; i <= 10; i++) { //10번
			// 만약에 i가 짝수라면 출력+누적 하지말고 바로 [증감식]으로 가세요 -> continue문
			if (i%2==0) continue;//10번
			System.out.printf("%d+", i);
			sum += i;
		}//for
		System.out.printf("=%d\n", sum);
		*/
		
		/* -> best coding
		int sum = 0;
		for (int i = 1; i <= 10; i+=2) {//5번
			System.out.printf("%d+", i);
			sum += i;
		}//for
		System.out.printf("=%d\n", sum);
		*/
		
		/*
		// 조건식 true -> 무한루프
		int i = 1;
		int sum = 0;
		while (true) {
			if (i>10) break;
			System.out.printf("%d+", i);
			sum += i;
			i++;
		}//while
		// 에러: Unreachable code -> 무한루프 때문에 도달하지 않는다
		System.out.printf("=%d\n", sum);
		*/
		
		
		// 10+ 마지막 반복 숫자 10 뒤의 + 기호는 제거하자
		//int i = 1;
		//int sum = 0;
		//while (i<=10) {
			//System.out.printf(i==10 ? "%d" : "%d+", i);
			/*
			if (i == 10) {
				System.out.printf("%d", i);
			} else {
				System.out.printf("%d+", i);
			}
			*/
			//System.out.printf("%d+", i);
			//sum += i;
			//i++;
		//}//while
		//System.out.printf("\b=%d\n", sum); // \b -> backspace 한칸 지우기
		
		// 1) if
		// 2) continue
		/*
		int i = 1;
		int sum = 0;
		while (i<=10) {
			if (i%2!=0) {
				System.out.printf("%d+", i);
				sum += i;
			}//if
			i++;
		}//while
		System.out.printf("\b=%d\n", sum);
		*/
		
		/*
		int i = 1;
		int sum = 0;
		while (i<=10) {
			if (i%2==0) {
				i++;
				continue; // while문에서 continue문을 만나면 [조건식]으로 이동
			}//if
				System.out.printf("%d+", i);
				sum += i;
				i++;
		}//while
		System.out.printf("\b=%d\n", sum);
		*/
		
		/*
		int i = 1;
		int sum = 0;
		while (i<=10) {
				System.out.printf("%d+", i);
				//sum += i++; // 1+2+3+4+5+6+7+8+9+10+=55
				//sum += ++i; // 1+2+3+4+5+6+7+8+9+10+=65 (2~11)
		}//while
		System.out.printf("\b=%d\n", sum);\
		*/
		
		/*
		int i = 0;
		int sum = 0;
		//while (i++<=10) { // 2+3+4+5+6+7+8+9+10+11+=65 : 비교 -> 증가
		while (++i<=10) { // 2+3+4+5+6+7+8+9+10+=54 : 증가 -> 비교
			if(i%2==0) continue;
				System.out.printf("%d+", i);
				sum += i;
		}//while
		System.out.printf("\b=%d\n", sum);
		*/
		
		/*
		int i = 1;
		int sum = 0;
		while (i<=10) {
			System.out.printf("%d+", i);
			sum += i;
			i+=2;
		}//while
		System.out.printf("\b=%d\n", sum);
		*/
		
		//while 조건반복문: 한 번도 수행(반복)하지 않을 경우가 있다
		// do~while 조건반복문: 최소한 한 번은 실행이 되고 나서
		/*
		int i = 1;
		int sum = 0;
		while (i>10) {
			System.out.printf("%d+", i);
			sum += i;
			i++;
		}//while
		System.out.printf("\b=%d\n", sum);
		*/
		
		/*
		int i = 1;
		int sum = 0;
		do {
			System.out.printf("%d+", i);
			sum += i;
			i++;
		} while (i>10);
		System.out.printf("\b=%d\n", sum);
		*/
		
		// 1. 배열의 정의: [동일한 자료형]이 메모리 상에 연속적으로 놓이게 한 것
		// 2. 배열의 선언 형식: 자료형 [] 배열명 = new 자료형 [배열크기];
		//	그림) [][][][][][][][][][] -> [0x100] 참조타입,	변수, 참조변수, 배열명
		
		/*
		int [] kors = new int[10];
		
		for (int i = 0, kor; i <10; i++) {
			kor = kors[i] = (int)(Math.random()*101);
			// System.out.printf("kors[%d]=%d\n", i, kors[i]);
			System.out.printf("kors[%d]=%d\n", i, kor);
		}//for
		*/
		
		/*
		// 0.0 <= Math.random()*101 < 101
		kors[0] = (int)(Math.random()*101);
		kors[1] = (int)(Math.random()*101);
		kors[2] = (int)(Math.random()*101);
		kors[3] = (int)(Math.random()*101);
		kors[4] = (int)(Math.random()*101);
		kors[5] = (int)(Math.random()*101);
		kors[6] = (int)(Math.random()*101);
		kors[7] = (int)(Math.random()*101);
		kors[8] = (int)(Math.random()*101);
		kors[9] = (int)(Math.random()*101);
		*/
		
		/*
		// Alt + Shift + A 세로 드래그(토글)
		System.out.printf("kors[0]=%d\n", kors[0]);
		System.out.printf("kors[1]=%d\n", kors[1]);
		System.out.printf("kors[2]=%d\n", kors[2]);
		System.out.printf("kors[3]=%d\n", kors[3]);
		System.out.printf("kors[4]=%d\n", kors[4]);
		System.out.printf("kors[5]=%d\n", kors[5]);
		System.out.printf("kors[6]=%d\n", kors[6]);
		System.out.printf("kors[7]=%d\n", kors[7]);
		System.out.printf("kors[8]=%d\n", kors[8]);
		System.out.printf("kors[9]=%d\n", kors[9]);
		*/
		
		int [] kors = new int[10];
		
		for (int i = 0; i <10; i++) {
			kors[i] = (int)(Math.random()*101);
		}//for
		
		//확장for문 == foreach문
		/*
		for (자료형(배열) i : 배열 또는 컬렉션 객체) {
			
		}
		*/
		
		for (int kor : kors) {
			System.out.println(kor);
		}
		
		//for (int i = 0, kor; i <10; i++) {
			//kor = kors[i] = (int)(Math.random()*101);
			// System.out.printf("kors[%d]=%d\n", i, kors[i]);
			//System.out.printf("kors[%d]=%d\n", i, kor);
		//}//for
		
	}//main

}//class
