package days26;

import java.util.ArrayList;

/**
 * @author dlsgu
 * @date 2023. 3. 3. 오후 3:29:36
 * @subject
 * @content
 */
public class Ex07_05 {

	public static void main(String[] args) {
		/*
		 * 7. 제한된 제네릭 클래스
		 * 	- 타입 문자로 사용할 타입을 명시하면 한 종류의 타입만 지정할 수 있도록 제한할 수 있지만
		 * 	  
		 * */
		
		/*
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		// appleBox.add(new Grape()); // 포도 에러
		
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		*/
		
		// [문제점]
		// FruitBox 제네릭 클래스 선언 -> 과일만 담을 수 있는 상자
		// FruitBox 제네릭 클래스에는 장난감(ToY)는 담을 수 없는 제네릭 클래스로 제한
		
		// <T extends Fruit> 타입 제한하고 나면 Toy는 T(타입)으로 사용할 수 었다
		/*
		FruitBox<Toy> toyBox = new FruitBox<Toy>();
		toyBox.add(new Toy());
		*/

	}//main

}//class

/*
interface Eatable { }

class Fruit implements Eatable { public String toString() {return "Fruit";} }
class Apple extends Fruit {public String toString() { return "Apple";} }
class Grape extends Fruit {public String toString() { return "Grape";} }

class Toy {public String toString() { return "Toy";} }

// 상자 - 과일/장난감 ... 여러 타입의 객체를 담을 수 있는 상자
class Box04<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { this.list.add(item); }
	T get(int i) { return this.list.get(i); }
	int size() { return this.list.size(); }
	public String toString() { return this.list.toString(); }
}
*/

/*
// 과일만 담을 수 있는 상자
class FruitBox<T> extends Box04<T> {
	// 구현
}
*/
/*
// <T extends Fruit> 의미는 모든 타입(T)가 아니라 Fruit 클래스의 자식들만 T로 사용하도록 제한
class FruitBox<T extends Fruit> extends Box04<T> {
	// 구현
}
*/
/*
// Eatable은 인터페이스지만 implements를 사용하지 않고 extends 키워드를 사용한다
class FruitBox<T extends Eatable> extends Box04<T> {
	// 구현
}
*/
/*
// Eatable 인터페이스도 구현되고 Fruit 클래스 자식도 만족해야만 T 타입으로 사용할 수 있도록 제한
class FruitBox<T extends Fruit & Eatable> extends Box04<T> {
	// 구현
}
*/