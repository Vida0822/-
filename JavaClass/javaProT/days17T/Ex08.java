package days17;

import lombok.Singular;

/**
 * @author ♈ kenik
 * @date 2023. 2. 17. - 오후 4:33:08
 * @subject     생성자 +  접근지정자 ( public , default, private, protected )
 * @content
 *                      생성자에 접근지정자를 사용함으로써
 *                      인스턴스의 생성을 제한할 수 있다. 
 */
public class Ex08 {

	public static void main(String[] args) {

		/*
		Sington s = new Sington();		
		System.out.println(  s );  // 생성된 객체의 정보 :   days17.Sington@5aaa6d82		
        // s = new Sington();
		Sington s2 = s;
		System.out.println(  s2 );  // 생성된 객체의 정보 :   days17.Sington@73a28541
		 */

		// 어디에서도 객체를 생성할 수 없다..
		// The constructor Singleton()  [is not visible]
		// Singleton s = new Singleton();
		Singleton s =  Singleton.getInstance();
		System.out.println( s );
		s =  Singleton.getInstance();
		System.out.println( s );
		s =  Singleton.getInstance();
		System.out.println( s );
		s =  Singleton.getInstance();
		System.out.println( s );
	} // main

} // class

// 싱글톤 
class Singleton{

	// public                패키지 내/외 어디서든 객체생성할 수 있다.
	// default            패키지 내에서만 객체를 생성하세요.. ( 제한 )
	// protected                             "                                                     + 상속
	private Singleton() { }

	private static Singleton singleton = null ;  // 필드 선언

	public static Singleton getInstance() {
		// static 메서드 안에서 지역변수       사용가능 ? O
		// static 메서드 안에서 인스턴스변수 사용가능 ? X
		// Cannot make a static reference to the non-static field singleton
		if( singleton == null ) {
			singleton = new Singleton();
		}		
		return singleton;

	}

}




