package days26;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 4:26:10
 * @subject  
 * @content
 *
 */
public class Ex07_08 {

	public static void main(String[] args) {
		/*
		 * 10. 제네릭 타입의 형변환.
		 * 
		 *    제네릭 타입과 원시 타입( raw type)  간의 형변환
		 * */
		
		// 제네렉클래스
		// ArrayList<Integer>  list = new ArrayList<Integer>();
		
		// ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
		// raw type == 원시 타입
		// ArrayList  list = new ArrayList();
		
		Box<Object> objBox = new Box<Object>(); 
		// 경고만 발생
		Box box =   objBox;
		
		Box b= new Box();
		// 경고만 발생.
		Box<Object> jb = b;
	
 
	} // main

} // class













