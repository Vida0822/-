package days12;

/**
 * @author ♈ kenik
 * @date 2023. 2. 10. - 오후 2:50:34
 * @subject
 * @content
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		// 3:01 수업시작~
		int [] score = { 79, 88, 91, 33, 100, 55, 95 };
		int max = score[0];
		int min = score[0];
		
		for (int i = 1; i < score.length; i++) {
			if( max < score[i] ) max  = score[i];
			else if( min > score[i] ) min  = score[i];
		}
		
		System.out.println("최대값 : " +  max);
		System.out.println("최소값 : " +  min);

	} // main

} // class













