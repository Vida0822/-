package days18;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오후 2:24:38
 * @subject
 * @content
 *
 *                      디폴트 메서드 추가와    기존 구현된 클래스의 메서드명이 충돌...  
 */
public class Ex06 {

	public static void main(String[] args) {
		
		String docType = "XML";
		//                                    new XMLParser()
		//                                    new HTMLParser()
		// 인터페이스 업캐스팅
		// 인터페이스 다형성 
		Parseable.method1();
		
		Parseable  parser  = ParserManager.getParser(docType);
		parser.parse("ex01.xml");
		parser.print(); // 인쇄까지 해 주면 좋은 것 같다라는 생각을 5년 뒤에 하게 되었다.. ( 가정 )

		
		// 방금 디폴트 한번만 더 설명가능하실까요?
		// 디폴트가 방금 부분에서 사용되기 편한지. 잘 모르겠어서요
	} // main

} // class


interface Parseable{
	// 구문 분석하는 메서드
	void parse(String fileName);
	
	// 5년 뒤~   추가
	// jdk 1.8
	// default 메서드 추가... 
	default void print() {
		System.out.println("기본 코딩");
	}
 
	
	// void print();  // 추상메서드 추가~~
	
	static void method1() {
		System.out.println("기본 코딩..");
	}
}

// 수 백개의 클래스 존재...한다고 가정하자.
// 5년동안 그 인터페이스를 구현한 클래스가 왜 오류가 났을 까요? 
// ㄴ 여기서 잘모르겠습니다..
class  XMLParser  implements Parseable{

	@Override
	public void parse(String fileName) {
		System.out.println("XML 파일 구문 분석 메서드");
	}
	
	// 디폴트 메서드는 무시된다..
	// 직접 추가 구현
	/*
	public void print() {
		// 구현
	}
	*/
	
}

class  HTMLParser  implements Parseable{

	@Override
	public void parse(String fileName) {
		System.out.println("html 파일 구문 분석 메서드");
	}
	
}


// 위에 구문분석  여러 개의 클래스를 관리는 관리자( Manager ) 클래스 존재..
class ParserManager{
	
	//           인터페이스  다형성
	// 리턴자료형 : Parseable 인터페이스 
	public static  Parseable  getParser(String  docType){
		if( docType.equals("XML"))
			return new XMLParser();
		else if(docType.equals("html"))
			return new HTMLParser();
		else 
			return null;
	}
	
}




