package days24;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 28. - 오후 12:12:08
 * @subject    Vector 컬렉션 클래스
 * @content     ㄴ List 인터페이스 구현한 클래스 
 *                        ㄴ 순서 유지 O, 중복 허용 O
 *                        ㄴ ArrayList 와 차이점 : 멀티 스레드 안전. ( 동기화 처리 )
 *                        
 *                        StringBuffer
 *                        StringBuilder : 멀티 스레드 안전( 동기화 처리 되어져 있다)
 */
public class Ex02 {

	public static void main(String[] args) {
		// Vector v = new Vector(초기용량 10, 증가치 0);
		Vector v = new Vector();
		
		v.add("박현주");
		v.addElement("박진용1");
		v.addElement("박진용2");
		v.addElement("박진용3");
		v.addElement("박진용4");
		v.addElement("박진용5");
		v.addElement("박진용6");
		
		// 요소 갯수
		System.out.println(   v.size()  );  // 2
		System.out.println(   v.capacity()  ); // 10
		
		v.trimToSize();
		System.out.println(   v.capacity()  ); // 2
		System.out.println( "-".repeat(40 ));
		
		v.setSize( 6 ); // 요소 6개 .   null null null null
		System.out.println(   v.size()  );       // 6
		System.out.println(   v.capacity()  ); // 6
		
		System.out.println( "-".repeat(40 ));
		System.out.println(   v  );  // [박현주, 박진용, null, null, null, null]
		
		System.out.println(  v.get(0) );
		// Returns the component at the specified index.
		// This method is identical in functionality to the get(int)method (which is part of the List interface).
		System.out.println(  v.elementAt(0)  );
		
		
		System.out.println( "-".repeat(40 ));
		// Iterator       [반복자]
		// 모든 요소를 반환하는 메서드
		// Enumeration [열거자]
		Enumeration  en = v.elements();
		// hasMoreElemetns()                         ==  hasMoreNext()
		// en.nextElement()                             ==  next() 
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			System.out.println(  name );
		}
		
		// v.setSize(6)   null X 4
		// [문제] v 안에 null 요소는 모두  제거하세요.. 
		// v.remove(0); ==		v.removeElementAt(0);
		// v.remove("홍길동"); ==		v.removeElement("홍길동)
		// v.removeAllElements(); ==		v.clear();
		/*
		v.removeIf(  new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t == null;
			}
		} );
		*/
		
		v.removeIf( (t)  ->  t == null );
		
		System.out.println( v );
		
		Object [] names = v.toArray();
		
		for (Object obj : names) {
			System.out.println(  (String)obj  );
		}
		
		//  v.firstElement() == v.get(0) == v.elementAt(0)
		//  v.lastElement() ==	v.get(   v.size() -1 );== v.elementAt(v.size() -1)
		
		// v.insertElementAt("박찬호", 1);  ==		v.add(1, "박찬호");
	   // 	isXXXX()  이니 아니니?   true/false
		
		// v.clear();
		// System.out.println(  v.size() ); // 0
	    // System.out.println(	 v.isEmpty()  );  // true
		
		//                1
		// [박현주, 박진용1, 박진용2, 박진용3, 박진용4, 박진용5]
		List  slist =  v.subList( 1,4 );  // 1<=   요소  < 4
		System.out.println( slist );
		
		// v.sort(null);
		// v.setElementAt("홍진용", 1);  ==		v.set(1, "홍진용");
		
		
		

	} // main

} // class







