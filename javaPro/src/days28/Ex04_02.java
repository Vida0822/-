package days28;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오후 2:51:45
 * @subject
 * @content
 */
public class Ex04_02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String fileName = ".\\src\\daus28\\child.ser";
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child c = (Child) ois.readObject();
		ois.close(); // flush()
		System.out.println("end");

	}//main

}//class

