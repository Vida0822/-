package days26;

import java.util.ArrayList;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 3:04:56
 * @subject  
 * @content
 *
 */
public class Ex07_04 {

	public static void main(String[] args) {
		/*
		 * 6. 제네릭 클래스의 객체 생성과 사용.
		 *  3:16 수업 시작~~~ 
		 * */ 
		
		/*
		Box03<Fruit> fruitBox = new Box03<Fruit>();
		Box03<Apple> appleBox = new Box03<Apple>();
		Box03<Grape> grapeBox = new Box03<Grape>();
		Box03<Toy> toyBox = new Box03<Toy>();
		
		// Type mismatch: cannot convert from Box03<Grape> to Box03<Apple>
		// Box03<Apple>  box1 = new Box03<Grape>(); // 에러 발생.
		
		fruitBox.add(  new Fruit() );  // 과일 객체 
		fruitBox.add(  new Apple() );  // 사과객체 
		fruitBox.add(  new Grape() );  // 포함객체 
		
		// The method add(Fruit) in the type Box03<Fruit> is not applicable for the arguments (Toy)
		// fruitBox.add(  new Toy() );  // 장난감객체          에러 
		
		toyBox.add(new Toy() );
		// toyBox.add(new Apple() );    // 에러 
		*/
		
		

	} // main

} // class

/*
// Fruit
//    ㄴ  Apple
//    ㄴ  Grape
// Toy
class Fruit{   public String toString() { return  "Fruit";  }   }
class Apple extends Fruit{  public String toString() { return  "Apple";  }  }
class Grape extends Fruit{  public String toString() { return  "Grape";  }  }

class Toy{  public String toString() { return  "Toy";  }  }

// 제네릭 클래스 선언
class Box03<T>{
	ArrayList<T>  list = new ArrayList<T>();	
	void add(T item) {    this.list.add(item);  }
	T get(int i) {  return  this.list.get(i); }
	int size() {  return this.list.size();  }
	public String toString(){  return this.list.toString(); }
}
*/








