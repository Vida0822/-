package days07;

/**
 * @author kenik
 * @date 2023. 2. 3. - 오전 6:07:10
 * @subject
 * @content  
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		// 9:40 제출~
		// [문제] 한 라인에 10개씩 출력하도록 코딩하세요. ( 이해 + 암기 )
		// [추가문제]  각 라인 앞에 라인번호를 붙이고자 한다.    1 :  , 2 : ,  
		
		int lineNumber = 1;
		for (int i = 0; i < 256; i++) {	 	
			if( i % 10 == 0 ) {
				// 출력 시키고 나서 증가시킨다 : 후위형 증감 연산자.
				System.out.printf("%d : " , lineNumber++);
			}
			 System.out.printf("[%c]", (char)i);
			 if( i % 10 == 9 ) {  // 9, 19, 29, ..
				 System.out.println();
			 }
		}
		
		/*
		int count = 2;
		System.out.printf("%d : " , 1 );
		for (int i = 0; i < 256; i++) {	 
			 System.out.printf("[%c]", (char)i);
			 if( i % 10 == 9 ) {  // 9, 19, 29, ..
				 System.out.println();
				 System.out.printf("%d : " , count );
				 count ++;
			 }
		}
		*/
		
		/*
		for (int i = 0; i < 256; i++) {	 	
			if( i % 10 == 0 ) {
				System.out.printf("%d : " , i / 10 + 1);
			}
			 System.out.printf("[%c]", (char)i);
			 if( i % 10 == 9 ) {  // 9, 19, 29, ..
				 System.out.println();
			 }
		}
		*/
		
		/*
		// i=0 개행 1번
		for(int i=0; i<=255;i++) {
			   if (i%10==0) System.out.println();
			   System.out.printf("[%c]" , (char)i );
		}
		*/
	
		/*
		for (int i = 0; i < 256; i++) {	 			
			 System.out.printf("[%c]", (char)i);
			 if( i % 10 == 0 ) {
				 System.out.println();
			 }
		}
		*/
		
		/*
		// 256*10
		// i=0
		// j=1,2,3,4,5,6,7,8,9,10 + 개행
		for (int i = 0; i < 256; i++) {			 
			for (int j = 1; j <=10; j++) {
				System.out.printf("[%c]", (char)i);
			}
			System.out.println();
			 
		}
		*/
		
		/*
		int count = 0;
		for (int i = 0; i < 256; i++) {
			count++;
			System.out.printf("[%c]", (char)i);
			if(count == 10) {
				System.out.println();
				count = 0;
			}
		}
		*/

		// (복습시험) 개행하는 코딩 모두 적으세요. 
		// [è][é][ê][ë][ì][í][î][ï][ð][ñ] + 개행
		// [è][é][ê][ë][ì][í][î][ï][ð][ñ] + 개행
		// [è][é][ê][ë][ì][í][î][ï][ð][ñ] + 개행
		// :
		// [è][é][ê][ë][ì][í]
	} // main

} // class










