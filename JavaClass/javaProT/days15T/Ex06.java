package days15;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 15. - 오전 11:47:54
 * @subject   static 키워드 설명
 * @content  중첩 클래스 앞 기타제어자 static              X
 *                     메서드 앞에 static 
 *                     필드 앞에 static           - 클래스(static) 변수
 */
public class Ex06 {
	
	public static void main(String[] args) {
		// 12:01 수업 시작~~ 
		// 저축 클래스 선언 : Save
		// 기업은행 : 보통 예금 통장
		/*
		Save p1 = new Save("김예지", 10000, 0.05);
		Save p2 = new Save("이혜진", 4000, 0.05);
		Save p3 = new Save("박민종", 16000, 0.05);
		Save p4 = new Save("이태규", 65000, 0.05);
		Save p5 = new Save("탁인혁", 1000, 0.05);
		
		// 모든 예금 정보 출력(조회)
		p1.dispSave();
		p2.dispSave();
		p3.dispSave();
		p4.dispSave();
		p5.dispSave();
		*/
		
		// 객체(클래스) 배열
		/*
		 *  int [] m  = new int[5];
		 *  m[0] = 1;
		 *  m[1]=2;
		 *  m[2] = 3;
		 *  m[3]=4;
		 *  m[4]=5;
		 *  
		 *  배열 초기화
		 *  int []  m = {  1,2,3,4,5  }
		 */
		
		
		/*
		Save [] ps = new Save[5];
		ps[0] = new Save("김예지", 10000, 0.05);
		ps[1] = new Save("이혜진", 4000, 0.05);
		ps[2] = new Save("박민종", 16000, 0.05);
		ps[3] = new Save("이태규", 65000, 0.05);
		ps[4] = new Save("탁인혁", 1000, 0.05);
		*/
		
		// 객체 배열 초기화
		// 강사님 근데 배열 초기화할때 new Save도 꼭 적어야 하나요?
		Save [] ps = {
				 new Save("김예지", 10000, 0.05),
				 new Save("이혜진", 4000, 0.05),
				 new Save("박민종", 16000, 0.05),
				 new Save("이태규", 65000, 0.05),
		         new Save("탁인혁", 1000, 0.05)
		} ;
		
		for (int i = 0; i < ps.length; i++) {
			ps[i].dispSave();
		}

	} // main

} // class




