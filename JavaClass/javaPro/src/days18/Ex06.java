package days18;

/**
 * @author dlsgu
 * @date 2023. 2. 20. 오후 2:24:54
 * @subject
 * @content
 * 
 * 			추가한 디폴트 메서드와 기존 구현된 클래스의 메서드명이 충돌할 수도 있다
 * 			이 때 디폴트 메서드는 무시된다
 */
public class Ex06 {

	public static void main(String[] args) {

		String docType = "XML";
		//				 new XMLParser()
		//				 new HTMLParser()
		// 인터페이스 업캐스팅
		// 인터페이스 다형성
		Parseable.method1();
		
		Parseable parser = ParserManager.getParser(docType);
		parser.parse("ex01.xml");
		parser.print(); // 인쇄까지 해주면 좋을 것 같다라는 생각을 5년 뒤에 하게되었다 (가정)

	}//main

}//class

interface Parseable {
	// 구문 분석하는 메서드
	void parse(String fileName);
	
	// 5년 뒤 추가
	// default 메서드 추가 -> class에 오버라이딩 안해도 됨
	default void print() {
		System.out.println("print 기본 코딩");
	}
	// JDK 1.8 static 추가
	static void method1() {
		System.out.println("method1 기본 코딩");
	}
}

// 수백개의 클래스가 존재한다고 가정하자
// 5년동안 그 인터페이스를 구현한 클래스가 왜 오류가 발생할까
// abstract class 아니면 오버라이딩 해야한다
class XMLParser implements Parseable {

	@Override
	public void parse(String fileName) {
		System.out.println("XML 파일 구문 분석 메서드");
	}
	
	/*
	// 디폴트 메서드는 무시된다
	// 직접 추가 구현
	public void print() {
		
	}
	*/
	
}

class HTMLParser implements Parseable {
	
	@Override
	public void parse(String fileName) {
		System.out.println("html 파일 구문 분석 메서드");
	}
	
}

// 위에 구문분석하는 여러개의 클래스를 관리하는 관리자(Manager) 클래스 존재
class ParserManager {
	// 		인터페이스 다형성
	// 리턴자료형 : Parseable 인터페이스
	public static Parseable getParser(String docType) {
		if(docType.equals("XML"))
			return new XMLParser();
		else if(docType.equals("html"))
			return new HTMLParser();
		else
			return null;
	}
}