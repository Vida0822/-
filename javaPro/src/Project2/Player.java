package Project2;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Player extends GameElemnet{
	Scanner sc = new Scanner(System.in);
	int setNumber;
	
	//매치 세트와 선수 이름 입력받는 메서드
	public void createMatch() {
		System.out.println("세트수를 입력하시오(1.5세트 2.3세트)");
		setNumber = sc.nextInt();//세트의 수를 입력받는다.
		while(!((setNumber == 1) || (setNumber == 2))) {//setNumber가 1,2가 아니면 반복
			System.out.println("올바른 입력이 아닙니다.");
			System.out.println("다시 세트수를 입력하시오 (1.5세트 2.3세트)");
			setNumber = sc.nextInt();
			try {
				System.in.skip(System.in.available());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(setNumber == 1) {//setNumber가 1이면
			setNumber = 3;//5판 3선승이기 때문에 3
		}
		else {
			setNumber = 2;//setNumber가 2이면 3판 2선승이기 때문에 2
		}

		//선수 이름 입력
		String [] name = new String[2];//플레이어의 이름을 저장하는 배열\
		String regex = "[가-힣]{2,5}";//한글 2~5글자 한글 
		boolean result;
		for(int j = 0; j<name.length; j++) {//2명의 이름을 받는 동안 반복
			System.out.printf("%d번 선수의 이름을 입력하시오(한글 2~5글자): " ,j+1);
			String exname = sc.next();//이름 입력 받는다.
			result = Pattern.matches(regex, exname); //입력 받은 이름이 조건에 맞는지 확인
			if(result){//result가 true이면
				name[j]=exname;//name[j]에 이름을 넣는다.

			}else{//result가 false이면
				System.out.printf("\n * %d선수 다시 입력해주세요\n", j+1);//다시 입력 받는다.
				j--;
			}
		}

		this.setName(name);
		this.setsetNumber(setNumber);
	}
}
