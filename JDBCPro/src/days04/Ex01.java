package days04;

import java.util.Scanner;

/**
 * @author Inhyuk
 * @date 2023. 4. 13.
 * @subject 한 페이지에 출력하는 게시글 목록수
 * @content
 */
public class Ex01 {

	public static void main(String[] args) {
		
		// [1]페이지 : 1 ~ 10
		// [2]페이지 : 11 ~ 20
		// [3]페이지 : 21 ~ 30
		int currentPage;
		int numberPerPage;
		int begin;
		int end;
		Scanner scanner = new Scanner(System.in);
		System.out.print("> 현재 페이지, 페이지당 게시글 개수 입력 : ");
		currentPage = scanner.nextInt();
		numberPerPage = scanner.nextInt();
		begin = numberPerPage * ( currentPage - 1 ) + 1;
		end = numberPerPage * currentPage; // begin + numberPerPage - 1
		System.out.printf("> begin : %d, end : %d\n", begin, end);
		
		//		:
		// 보고자하는 페이지 : [3]
		// 한 페이지에 출력할 게시글 수 : 10
		// 게시글 목록 출력
		// BoardDAOImpl 클래스의 select() 메서드 수정
		
/*
			  게시판
--------------------------------------------------------------
글번호	글제목             	   글쓴이  	작성일   조회수
--------------------------------------------------------------
150	수정제목                   CgvQy	2023-04-12	1
149	게시글 - 149               UgVwM	2023-04-12	0
148	게시글 - 148               vEGbm	2023-04-12	0
147	게시글 - 147               eOmgG	2023-04-12	0
146	게시글 - 146               CMsKK	2023-04-12	0
145	게시글 - 145               mTopb	2023-04-12	2
144	게시글 - 144               iEuHj	2023-04-12	0
143	게시글 - 143               VTogq	2023-04-12	0
142	게시글 - 142               NVXDP	2023-04-12	0
141	게시글 - 141               qoFav	2023-04-12	0
--------------------------------------------------------------
		[1] 2 3 4 5 6 7 8 9 10 >
--------------------------------------------------------------
 		 계속하려면 엔터치세요.
*/

	}//main

}//class

/*
[ 검색하기 + 페이징 처리 ]
1. BoardController.검색하기() 수정
*/
