package days26;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @author dlsgu
 * @date 2023. 3. 3. 오전 11:38:26
 * @subject Properties 컬렉션 클래스 *****
 * @content 1) Hashtable의 자식 클래스이다
 * 			2) Map	(key + value = entry)
 * 			3)		String String
 */
public class Ex05 {

	public static void main(String[] args) {
		// Hashtable<String, String> ht;
		// Properties p;
		
		// JAVA + 오라클DB 연동 + CRUD 작업
		// DB 연결 설정 정보
		String className = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "scott";
	    String password = "tiger";
	    
	    // 1. 위의 DB를 연결하기 위한 설정 정보들을 Properties 컬렉션에 저장
	    Properties p = new Properties();
	    // p.put(key, value);
	    // p.setProperty(key, value); [권장]
	    p.setProperty("className", "oracle.jdbc.driver.OracleDriver");
	    p.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
	    p.setProperty("user", "scott");
	    p.setProperty("password", "tiger");
	    // {password=tiger, className=oracle.jdbc.driver.OracleDriver,
	    //	 user=scott, url=jdbc:oracle:thin:@localhost:1521:xe}
	    System.out.println(p);
	    
	    // value = p.get(key);
	    String value = p.getProperty("url");
	    System.out.println(value);
	    
	    // 2. Properties 객체에 있는 설정 정보를 파일(jdbc.properties)로 다시 저장
	    // 확장자가 (.properties)라면 Properties 컬렉션 객체에서 사용하는 파일이다
	    // 파일 쓰기(저장) : FileWriter
	    // 파일 읽기(열기) : FileReader
	    /*
	    String fileName = ".\\src\\com\\util\\jdbc.properties";
	    String comments = "[comments]";
	    try (FileWriter writer = new FileWriter(fileName)){
	    	p.store(writer, comments); // 파일 저장
	    	System.out.println("Save END");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	    
	    // xml 파일(.xml)로 저장
	    String fileName = ".\\src\\com\\util\\jdbc.xml";
	    String comments = "[comments]";
	    try (FileOutputStream os = new FileOutputStream(fileName)){
	    	p.storeToXML(os, comments, "UTF-8"); // XML 파일 저장
	    	System.out.println("Save END");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    // 3. 파일 -> Properties 객체를 사용해서 읽어와서 사용

	}

}
