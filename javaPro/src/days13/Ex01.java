package days13;

import java.util.Random;

/**
 * @author dlsgu
 * @date 2023. 2. 13. 오전 9:04:31
 * @subject
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {

		final int STUDENT_COUNT = 30;
		
		String [] names = new String[STUDENT_COUNT];
		int [] tots = new int[STUDENT_COUNT];
		int [] avgs = new int[STUDENT_COUNT];
		int [] ranks = new int[STUDENT_COUNT];
		String name;
		int tot, rank;
		double avg;
		
		for (int i = 0; i < STUDENT_COUNT; i++) {
			name = getName();
			tot = getTot();
			avg = (double)tot/3;
			rank = getRank(i+1, tots);
		}
		
	}//main

	private static int getRank(int number, int [] tots) {
		int tot = tots[number-1];
		int rank = 1;
		for (int i = 0; i < tots.length; i++) {
			if (tot < tots[i]) rank++;
		}
		return rank;
	}

	private static int getTot() {
		return (int)(Math.random()*301);
	}

	private static String getName() {
		Random rnd = new Random();
		char [] nameArr = new char[3];
		for (int i = 0; i < nameArr.length; i++) {
			nameArr [i] = (char)(rnd.nextInt('Z'-'A'+1) + 'A');
		}
		String name = new String(nameArr);
		return name;
	}

}//class
