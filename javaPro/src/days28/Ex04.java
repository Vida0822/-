package days28;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오후 2:51:45
 * @subject
 * @content
 */
public class Ex04 {

	public static void main(String[] args) throws IOException {

		Child c = new Child();
		c.name = "홍길동";
		c.age = 20;
		
		String fileName = ".\\src\\daus28\\child.ser";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c);
		oos.close(); // flush()
		System.out.println("end");

	}//main

}//class

// 부모 클래스가 직렬화가 가능하면
// 자식 클래스는 자동으로 직렬화 가능한 클래스가 된다
/*
class Parent implements Serializable {
	String name;
}

class Child extends Parent {
	int age;
}
*/

// 부모 클래스는 직렬화 할 수 없는 클래스
// 자식 클래스는 직렬화 가능한 클래스
// 이럴 경우에는 부모의 멤버는 직렬화 대상에서 제외된다
class Parent {
	String name;
}

class Child extends Parent implements Serializable {
	int age;
	// 부모의 name 필드를 직렬화 대상에 추가하도록 개발자가 직접 구현하면 된다 
	   private void writeObject(ObjectOutputStream out) throws IOException {
	      out.writeUTF(name); // 개발자가 직접 직렬화 대상에 포함시키는 코딩
	      out.defaultWriteObject();
	   }
	   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	      name = in.readUTF();
	      in.defaultReadObject();
	   }
}
