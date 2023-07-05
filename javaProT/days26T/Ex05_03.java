package days26;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 3. - 오후 2:09:24
 * @subject  
 * @content
 *
 */
public class Ex05_03 {

	public static void main(String[] args) {
		// C:\Class\WorkSpace\JavaClass\javaPro
		/*
		String dir = System.getProperty("user.dir");
		System.out.println( dir );
		*/
		
		Properties p = System.getProperties();
		/*
		p.propertyNames();
		p.keys();
		p.keySet();
		*/
		
		Enumeration<String>  en = (Enumeration<String>) p.propertyNames();
		while (en.hasMoreElements()) {
			 String key   =  en.nextElement();
			System.out.printf("%s - %s\n",  key,   p.getProperty(key) );
		}
		

	} // main

} // class









