package days26;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 2:40:15
 * @subject  
 * @content
 *
 */
public class Ex07_02 {

	public static void main(String[] args) {
		/*
		 * 4. 제네릭 클래스 선언 
		 * */ 
		/*
		Box box = new Box();
		// 1. int 
		// box.setItem(100);
		// 2. String
		// box.setItem("홍길동");
		// 3. double
		// box.setItem(3.14);
		// 4. char   'A'
		// box.setItem('A');
		
		System.out.println(  box.getItem() ); // 다운캐스팅..( 불편한 점 )
		*/
		
		//     String  대입된 타입( 매개변수화된 타입)
		// Box<String>  제네릭 타입 호출 
		Box<String> box = new Box<String>();
		box.setItem("홍길동");
		String name =box.getItem();
		System.out.println( name );
		
		Box<Integer>  box2 = new Box<Integer>();
		box2.setItem(100);
		int age = box2.getItem();
		System.out.println( age );
		

	}  // main

} // class

// [ 제네릭 클래스 ] 선언 - 컴파일 시에 타입이 결정된다. 
// T            타입 변수 또는 타입 매개변수 
// Box       원시 타입( raw type )
// Box<T> 제네릭 클래스 
class Box<T>{  // 클래스명 옆에 <T>을 부티이면  된다.	
	private T item;
	public T getItem() {
		return item;
	}	
	public void setItem(T item) {
		this.item = item;
	}	
}

/*
class Box{	
	private Object item;
	public Object getItem() {
		return item;
	}	
	public void setItem(Object item) {
		this.item = item;
	}	
}
*/
/*
class Box{	
	private int item;
	public int getItem() {
		return item;
	}	
	public void setItem(int item) {
		this.item = item;
	}	
}
*/

/*
class Box{	
	private String item;
	public String getItem() {
		return item;
	}	
	public void setItem(String item) {
		this.item = item;
	}	
}
*/

/*
class Box{	
	private double item;
	public double getItem() {
		return item;
	}	
	public void setItem(double item) {
		this.item = item;
	}	
}
*/

/*
class Box{	
	private char item;
	public char getItem() {
		return item;
	}	
	public void setItem(char item) {
		this.item = item;
	}	
}
*/






