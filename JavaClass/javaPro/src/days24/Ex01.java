package days24;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오전 7:26:02
 * @subject 
 * @content 
 */
public class Ex01 {

	public static void main(String[] args) {		
		// 9:40 제출~
		// 10:04 수업 시작~
		String [] names = {"박진용","박민종","이혜진", "김동현"};
		// String [] -> ArrayList 변환
		// [첫 번째]
		/*
		ArrayList list = new ArrayList();		
		for (int i = 0; i < names.length; i++) {
			// System.out.println(  names[i] );
			list.add(  names[i] );
		}
		*/
		// Arrays 클래스의 asList() 메서드 
		// List a = Arrays.asList(T... a);
		// List a = (List) Arrays.asList( names );
		
		// ( 암기)  String [] 을  ArrayList 변환하는 코딩.
		ArrayList  list = new ArrayList( Arrays.asList( names ) ); // 업캐스팅. 
	
		
		System.out.println(  list );
		
		// ArrayList -> String[] 다시 변환...
		/*
		String []  m = new String[ list.size() ];
		Iterator  ir =  list.iterator();
		int idx = 0;
		while (ir.hasNext()) {
			String name = (String) ir.next();
			m[idx++] = name;
		}		
		System.out.println(  Arrays.toString( m ) );
		*/
		
		/*
		Exception in thread "main" java.lang.ClassCastException:
	   class [Ljava.lang.Object; 
	   cannot be cast to class [Ljava.lang.String; 
       [Ljava.lang.Object; and [Ljava.lang.String; 
       are in module java.base of loader 'bootstrap')
		at days24.Ex01.main(Ex01.java:53)
		*/
		// Object[] toArray() -> String []
		//                    (String[]) cast 연산자로 형변환..
		
		// String[]  m =  (String[]) list.toArray();  XXXXX
		
		String []  m = null ; 
		m =  (String[]) list.toArray( new String[ list.size() ] );
		
		System.out.println(  Arrays.toString( m  ) );
		
		
		/*
		Object [] m = list.toArray();
		System.out.println(  Arrays.toString(m) );
		*/
		
		
		
		
	    
	} // main

} // class








/*
 * 1조_연봉1조          : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */










