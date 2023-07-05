package days04;

/**
 * @author dlsgu
 * @date 2023. 1. 31. 오전 11:31:50
 * @subject ++ -- 증감연산자(단항연산자) [시험문제]
 * @content 증감연산자가
 * 			1) 단독으로 사용될 때
 * 				++x == x++
 * 			2) 다른 수식이나 매서드의 매개변수로 사용될 때 Ex03_03
 * 				++x != x++
 * 
 */
public class Ex03_02 {

	public static void main(String[] args) {
		// (시험) 어떤 기억공간의 값을 1증가(1감소) 시키는 코딩을 하세요
		// 1) x = x + 1
		// 2) x += 1
		// 3) x++
		// 4) ++x
		int x = 10;
		System.out.printf("> x = %d\n", x);
		
		// x 1증가 코딩
		//x = x+1; // x = x-1;
		
		// +=, -=, *=, /=, %=, <<=, >>=, ^=, |= 복합대입연산자
		// this.textBox1.name = this.textBox1.name + 1;
		// this.textBox1.name += 1;
		// x+=1; // x-=1; == x = x-1;
		// x++; // x-- 후위형 증감연산자
		// ++x; // ==x; 전위형 증감연산자
		
		System.out.printf("> x = %d\n", x);
		
		
		/*
		// (시험) i를 양->음수, 음->양수 변경하는 코딩을 하세요
		int i = 10;
		// i = i * -1;
		i = -i;
		System.out.println(i);
		*/


	}

}
