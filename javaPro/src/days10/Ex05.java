package days10;

import java.util.Date;
import java.util.Scanner;

/**
 * @author dlsgu
 * @date 2023. 2. 8. - 오후 12:40:44
 * @subject 주민등록번호 [시험문제 3] 만 나이
 * @content 
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		// 주민등록번호를 입력받아서
		Scanner scanner = new Scanner(System.in); // rrn = "830412-1700001";
		String rrn = Ex02.getRRN(scanner);
		System.out.println("> RRN : " + rrn);
		// 1. 생년월일 "1983-04-12"
		// System.out.println(getBirth(rrn));
		// 2. 성별 - 함수(메서드) 선언 1.기능 2.매개변수 3.리턴값
		// System.out.println(getGender(rrn) ? "성별 : 남자" : "성별 : 여자");
		// 3. 나이계산
		int countingAge = getCountingAge(rrn);
		System.out.println(countingAge);
		
		int americanAge = getAmericanAge(rrn);
		System.out.println(americanAge);
		// 4. 출생지역
		// 5. 검증

	}//main
	
	
	// 함수 ? 프로그램 + 반복적인 코딩 묶어서 + 함수 처리 + 구조화 + [재사용], 팀작업
	// drawLine(), drawLine(int n), drawLine(int n, char style) 오버로딩 == 중복함수
	
	
	// 나이 반환
	// 세는 나이 CountingAge - 태어나자마자 1살을 먹고, 새해(1월 1일)이 되면 1살을 먹는다
	// 세는 나이 = 현재년도 - 생일년도 + 1
	public static int getCountingAge(String rrn) {
		// 현재년도
		Date d = new Date();
		// 에러: The method getYear() from the type Date is deprecated -> 나중에(최신버전에서) 없어지는 함수
		int nowYear = d.getYear() + 1900;
		// System.out.println("> nowYear : " + nowYear);
		
		int birthYear = Integer.parseInt(getBirth(rrn).substring(0,4));
		int countingAge = nowYear - birthYear + 1;
		return countingAge;
	}
	
	// 만 나이 AmericanAge - 태어나는 일을 기준으로 1년이 지나야 1살을 먹는다
	// 만 나이 = 현재년도 - 생일년도 (생일 지나지 않았으면 -1)
	public static int getAmericanAge(String rrn) {
		
		int americanAge;
		Date d = new Date();
		int nowYear = d.getYear() + 1900;
		int birthYear = Integer.parseInt(getBirth(rrn).substring(0,4));
		
		americanAge = nowYear = birthYear;
		
		int nowMonth = d.getMonth()+1;
		int nowDay = d.getDate();
		int birthMonth = Integer.parseInt(getBirth(rrn).substring(5,7));
		int birthDay = Integer.parseInt(getBirth(rrn).substring(8));

		/*
		// 년도 필요 X
		// 현재월 현재일 생일월 생일일 필요 O
		// 현재월 > 생일월 || (현재월 == 생일월 && 현재일 >= 생일일) -> 생일이 지난 것
		// 현재월 > 생일월 || (현재월 == 생일월 && 현재일 < 생일일) -> 생일 지나지 않은 것 (-1)
		if (nowMonth<birthMonth || (nowMonth==birthMonth && nowDay<birthDay)) {
			americanAge--;
		}
		*/
		
		int nowMD = nowMonth*100 + nowDay;
		int birthMD = Integer.parseInt(getBirth(rrn).substring(5).replaceAll("-", "")); // 0000-00-00 -> 00-00 -> 0000
		
		if (nowMD<birthMD) americanAge--;
		
		return americanAge;
		
		/*
		// 현재년도
		Date d = new Date();
		int nowYear = d.getYear() + 1900;
		int nowMonth = d.getMonth()+1;
		int nowDay = d.getDate();
		int nowDate = nowMonth*100 + nowDay;
		int birthDate = Integer.parseInt(rrn.substring(2, 6));
		int americanAge;
		int birthYear = Integer.parseInt(getBirth(rrn).substring(0, 4));
		
		if (birthDate - nowDate > 0) americanAge = nowYear - birthYear - 1;
		else americanAge = nowYear - birthYear;
		
		return americanAge;
		*/
	}

	
	// 생년월일 반환 "0000-00-00"
	// 성별
	// 1,2,5,6 -> 1900
	// 3,4,7,8 -> 2000
	// 0,9      -> 1800
	public static String getBirth(String rrn) {
		String year = rrn.substring(0, 2); 
		String month = rrn.substring(2, 4);
		String day = rrn.substring(4, 6);
		
		String gender = rrn.substring(7, 8);
		switch (Integer.parseInt(gender)) {
		case 1: case 2: case 5: case 6:
			year = "19" + year;
			break;
		case 3: case 4: case 7: case 8:
			year = "20" + year;
			break;
		case 9: case 0:
			year = "18" + year;
			break;
		}
		return String.format("%s-%s-%s", year, month, day);		
	}

	
	// 성별 반환
	public static boolean getGender(String rrn) {
		String gender = rrn.substring(7, 8); // "1"
		if (Integer.parseInt(gender) % 2 != 0) return true;
		else return false;
	}
	
	/*
	public static boolean getGender(String rrn) {
		char gender = rrn.charAt(7); // '1' == 49
		// char '1' -> int 1 변환 (주의사항)
		if ((gender-48) % 2 != 0) return true;
		else return false;
	}
	*/
	
}//class
