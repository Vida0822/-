package days26;

import java.util.ArrayList;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 3:49:08
 * @subject  
 * @content
 *
 */
public class Ex07_06 {

	public static void main(String[] args) {
		/*
		 * 8. 와일드 카드 ( ? )
		 *     <? extends T>    와일드 카드의 상한 제한.    T의 자손만 가능
		 *     <? super T>         와일드 카드의 하한 제한.    T의 조상만 가능
		 *     <?>                        제한 없음.   <? extends Object>  동일한 의미
		 * */  

		
		FruitBox<Fruit>  fruitBox = new FruitBox<Fruit>();
		Juice juice =  Juicer.makeJuice(fruitBox);
		System.out.println( juice );  // days26.Juice@69222c14 
		
		FruitBox<Apple>  appleBox = new FruitBox<Apple>();
		juice =  Juicer.makeJuice(appleBox);
		System.out.println( juice );  // days26.Juice@69222c14
		
		FruitBox<Grape>  grapeBox = new FruitBox<Grape>(); 
		juice =  Juicer.makeJuice(grapeBox);
		System.out.println( juice );  // days26.Juice@69222c14
		
	} // main

} // class

// 과일 클래스
class Fruit {   public String toString() { return  "Fruit";  }   }
// 사과 클래스
class Apple extends Fruit{  public String toString() { return  "Apple";  }  }
// 포도클래스 
class Grape extends Fruit{  public String toString() { return  "Grape";  }  }

// 4:05 수업 시작~~ 
// 과일/사과/포도 -> 과일박스를 매개변수로     쥬스만들어서 반환하는 Juicer 라는 클래스 선언.
//                                                                      static  makeJuice() 메서드 선언  
class Box05<T>{
	ArrayList<T>  list = new ArrayList<T>();	
	void add(T item) {    this.list.add(item);  }
	T get(int i) {  return  this.list.get(i); }
	int size() {  return this.list.size();  }
	public String toString(){  return this.list.toString(); }
}

class FruitBox<T extends Fruit> extends Box05<T>{
	// 구현
}

// 쥬스를 만드는 기기
class Juicer{
	
 
	static Juice makeJuice(  FruitBox<? extends Fruit>  box ) {
		//
		// 
		return new Juice();
	}	
	 
	
	// 위의 메서드를 "제네릭 메서드"로 선언...
	// 리턴 자료형 앞에 <T> 타입변수를 선언한다. 
	// 제네릭클래스의 <T>와는 별개 X
	/*
	static  <T extends Fruit> Juice makeJuice(  FruitBox<T>  box ) {
		//
		// 
		return new Juice();
	}	
	*/
	
	// 오버로딩.... ( 중복함수 )
	/*
	static Juice makeJuice(  FruitBox<Fruit>  box ) {
		//
		// 
		return new Juice();
	}	
	
	static Juice makeJuice(  FruitBox<Apple>  box ) {
		//
		// 
		return new Juice();
	}	
	
	static Juice makeJuice(  FruitBox<Grape>  box ) {
		//
		// 
		return new Juice();
	}
	*/	
}

// 쥬스클래스
class Juice{
	// 구현
}





