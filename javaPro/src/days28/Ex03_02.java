package days28;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author dlsgu
 * @date 2023. 3. 7. 오후 2:22:53
 * @subject 역직렬화
 * @content
 */
public class Ex03_02 {

	public static void main(String[] args) {

		String fileName = ".\\src\\days28\\UserInfo.ser";
		
		try (
				// 보조 스트림
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);
			) {
			
			UserInfo u1 = (UserInfo) ois.readObject();
			UserInfo u2 = (UserInfo) ois.readObject();
			ArrayList<UserInfo> list = (ArrayList<UserInfo>) ois.readObject();
			
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//main

}//class

