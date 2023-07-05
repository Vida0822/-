package days07;

/**
 * @author dlsgu
 * @date 2023. 2. 3. 오후 4:53:09
 * @subject
 * @content
 */
public class Ex06 {

	public static void main(String[] args) {
		// [문제] 1-2+3-4+5-6+7-8+9-10=-5
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.printf("%d+", i);
				sum-=i;
			} else {
				System.out.printf("%d-", i);
				sum+=i;
			}
		}
		System.out.printf("\b=%d", sum);

	}//main

}//class