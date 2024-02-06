package days26;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 4:18:20
 * @subject  
 * @content
 *
 */
public class Ex07_07 {

	public static void main(String[] args) {
		/*
		 * 9. 제네릭 메서드
		 *     - 메서드의 선언부에 제네릭 타입이 선언된 메서드를 제네릭 메서드라고 한다.  
		 *
		 * Ex07_06의 메서드를 제네릭메서드로 선언..
		 
		static  <T extends Fruit> Juice makeJuice(  FruitBox<T>  box ) {
		//
		// 
		return new Juice();
	}
	
	    [ Ex07_06.java ]
		 FruitBox<Apple>  appleBox = new FruitBox<Apple>();
		juice =  Juicer.makeJuice(appleBox);
		System.out.println( juice );  // days26.Juice@69222c14
		
		[제네릭 메서드로 선언하고 나면 호출방법이 다르다. ]
		FruitBox<Apple>  appleBox = new FruitBox<Apple>();
		juice =  Juicer.<Apple>makeJuice(appleBox);
		juice =  Juicer.makeJuice(appleBox);  // 생략 가능
		System.out.println( juice );  // days26.Juice@69222c14
		 * */ 

	} // main

} // class
