package days04;

/**
 * @author Inhyuk
 * @date 2023. 4. 13.
 * @subject 게시글 페이지 번호 출력
 * @content
 */
public class Ex02 {

	public static void main(String[] args) {
		// [1] 2 3 4 5 6 7 8 9 10 >
		int currentPage = 2;
		int numberPerPage = 10;
		int numberOfPageBlock = 10;
		// 1 [2] 3 4 5 6 7 8 9 10 >
		// 1) 총레코드수 : 150 SELECT COUNT(*) FROM cstvsboard;
		// 2) 총페이지수 : 15 SELECT COUNT(*), CEIL( COUNT(*)/10 ) FROM cstvsboard;
		int totalPages = 15;

		for (int i = 1; i <= totalPages; i++) {
			System.out.printf("%d 페이지 : ", i);
			
			// int start = (currentPage -1) /numberOfPageBlock * numberOfPageBlock +1 ;
			int start = (i -1) /numberOfPageBlock * numberOfPageBlock +1 ;
			int end = start + numberOfPageBlock - 1;
			end = end > totalPages ? totalPages : end;
			
			if (start != 1) System.out.print("< ");
			for (int j = start; j <= end; j++) {
				System.out.printf(i==j ? "[%d] " : "%d ", j);
			}
			if (end != totalPages) System.out.print(">");
			System.out.println();
		}
		/*
		 * 		start			   	end
		1 페이지 [1] 2 3 4 5 6 7 8 9 10 >
		2 페이지 1 [2] 3 4 5 6 7 8 9 10 >
		3 페이지 
		4 페이지 
		5 페이지 
		6 페이지 
		7 페이지 
		8 페이지 
		9 페이지 
		10 페이지 1 2 3 4 5 6 7 8 9 [10] >
		11 페이지 < [11] 12 13 14 15
		12 페이지 < 11 [12] 13 14 15
		13 페이지 
		14 페이지 
		15 페이지 < 11 12 13 14 [15]
		*/

	}//main

}//class
