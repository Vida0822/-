package days19;

/**
 * @author ♈ k§nik
 * @date 2023. 2. 21. - 오후 12:14:19
 * @subject   모든 클래스의 최상위 부모 클래스 : java.lang.Object 클래스
 * @content   멤버( 메서드 ) 살펴 보자~ 
 */
public class Ex05 {

	public static void main(String[] args) {
		
		// 1. Object.hashCode()  객체 자신의 해쉬코드를 반환하는 메서드 
		/*
		Value v1 = new Value(10);
		int hashCode = v1.hashCode();
		System.out.println(  hashCode );  // 1521118594
		
		Value v2 = new Value(10);
		hashCode = v2.hashCode();
		System.out.println(  hashCode );  // 1940030785
		*/
		
		// 2. Object.toString() - 객체 자신의 정보를  문자열로 반환하는 메서드
		/*
		//    패키지명.클래스명@5aaa6d82
		Value v1 = new Value(10);
		System.out.println( v1.toString() );  // days19.Value@5aaa6d82
		System.out.println( v1  );                   // days19.Value@5aaa6d82		
		// 객체명.toString()  == 객체명 ( 기억 )
		 */
		
		// 3. Object.getClass() - 객체의 클래스 정보를 담고 있는 Class 인스턴스를 반환하는 메서드 
		//                                                                                    Class   !=    class 자바 대소문자 구분
		/*
		Value v1 = new Value(10);
		
		// <T>  제네릭(지네릭스)
		 Class  cls = v1.getClass();		 
		 System.out.println( cls.getName() );  // days19.Value
		 int hashCode =  v1.hashCode();
		 System.out.printf("%s@%s\n", cls.getName(),  Integer.toHexString(  hashCode ));
		 System.out.println(  v1.toString() );
		 */
		
		// 4. Object.equals() - 같은 객체인지를 체크해서 true/false 반환하는 메서드
		/*
		int a = 10;
		int b = 20;
		// a와 b가 같냐 ?           ==
		System.out.println(  a  ==  b  );  // false
		*/
		
		Value v1 = new Value(10);  // 0x100
	    Value v2 = new Value(10);  // 0x200
		//Value v2 = v1; // 객체 복사( copy )		
		System.out.println(   v1  == v2  );  // false  0x100 == 0x200
		System.out.println(   v1.equals(v2)  );  // false  0x100 == 0x200
		
		// 문제) value 값이 같으면 나는 같다라고 출력.
		Point p1 = new Point(1, 2);
		Point p2= new Point(1, 2);
		
		// (기억) Object.equals() 메서드를 재정의 하지 않았다면 
		//              ==   , equals() 결과값은 동일하다. 
		
		// 두 좌표가 같냐 ? xy 좌표가 같은 같다.. 출력.
		// System.out.println(  p1   ==   p2 );         // false
		System.out.println(  p1.equals( p2 ));   // false
		// 방법은? Object.equals()를 Point 클래스에서 재정의 하면 된다. ( 오버라이딩 )

	} // main

} // class

// Cloneable 인터페이스를 구현해야지 복제할 수 있는 클래스가 된다. 
class Point  implements Cloneable{  // [1.] 단계
	int x , y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	// [2]오버라이딩. 단계
	/*
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = null;		
		obj  = super.clone();		
		return  obj;
	}
	*/
	
	// JDK1.5부터 '공변 반환 타입( convariant return type)' 추가
	// - 오버라이딩 할 때 조상 메서드의 반환타입을 자식 클래스의 타입으로 변경이 가능하다. 
	@Override
	protected Point clone() {
		Object obj = null;		
		try {
			obj  = super.clone();
		} catch (CloneNotSupportedException e) { 
			e.printStackTrace();
		}		
		return  (Point)obj;
	}

	// p1.equals( p2 )
	@Override
	public boolean equals(Object obj) {  // 업캐스팅 개념
		// p1  -  this.x;		this.y;		
		// instanceof 연산자 +  다운캐스팅
		if( obj instanceof Point  ) {
			 Point p =  (Point)obj;
			 if( this.x == p.x  && this.y == p.y)  return true;
		}
		
		return false;
	} 
	
}

class Value{  // extends Object 생략
	// 필드 
	int value;  // 10
	
	// 생성자
	public Value(int value) {
		this.value = value;
	}
	
}


