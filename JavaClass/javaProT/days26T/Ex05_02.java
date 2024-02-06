package days26;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 12:43:57
 * @subject  
 * @content
 *
 */
public class Ex05_02 {

	public static void main(String[] args) {
		String fileName = ".\\src\\com\\util\\jdbc.properties";
		
		Properties p = new Properties(); // Hashtable 자식 클래스 (Map)
		try( FileReader reader = new FileReader(fileName) ) {
			p.load(reader);			
			// list() 메서드 
			// p.list( System.out  );
			
			System.out.println(   p.getProperty("password") );
			System.out.println(   p.getProperty("url") );
			System.out.println(   p.getProperty("user") );
			System.out.println(   p.getProperty("className") );
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

} // class






