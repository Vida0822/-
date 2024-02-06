package days26;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 2:56:15
 * @subject  
 * @content
 *
 */
public class Ex07_03 {

	public static void main(String[] args) {
		/*
		 *  5. 제네릭스의 제한
		 *     1)  객체별로 다른 타입으로 지정해서 동작하도록 만든 기능이기 때문에 
		 *          static  필드는 선언할 수 없다. 
		 *      2) static 메서드의 매개변수 타입으로 T를 사용할 수 없다.
		 *      3) T 타입의 배열 선언할 수 있다.     
		 *      4) 
		 * */

	} // main

} // class

class Box02<T>{   
	
	//  static T item2;    static 필드는 제네렉 클래스에 선언할 수 없다. 
	// static int comapre( T t1, T t2 ) { // static 메서드의 매개변수 타입으로 T를 사용할 수 없다.
	// }
	
	T[] itemArr;  // T 타입의 배열 선언할 수 있다. 
	T[] toArray() {
		// T[] tmpArr = new T[itemArr.length];  // 제네릭 배열 생성 불가.           instanceof X new X
		//                         newInstance() 메서드로 동적 생성 가능하다. 
		// return tmpArr;
		return null;
	}
	
	private T item;
	public T getItem() {
		return item;
	}	
	public void setItem(T item) {
		this.item = item;
	}	
}
