package days25;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오후 4:44:35
 * @subject 
 * @content 
 */
public class Ex08 {

	public static void main(String[] args) {
		// 파일 읽어와서  'A' 20 -> ####### 그래프
		String fileName = "days20\\Ex01.java";
		fileName  =  String.format("%s\\src\\%s"
                ,  System.getProperty("user.dir")
                , fileName );
		//   k     + v = entry
		//   'A'      1
		// HashMap
		// 5:00 수업 시작~
		HashMap<Character, Integer>   map = new HashMap<>();
		
		char one = '\u0000';
		int code = 0;
		
		try (
				FileReader fr = new FileReader(fileName);
				){
			while (       ( code =  fr.read() )      != -1            ) {
				one = (char) code;
				// System.out.println(  one  );
				if(  map.containsKey(   one  )  ) {  // 존재한다
					int value =  map.get(one);
					map.put( one ,    value+1 );
				}else {  // 존재 X
					map.put( one , 1);
				}
			
			} // while
			
			//  막대그래프
    		//    A(20) : #################### 
			Set<Entry<Character, Integer>>  es = map.entrySet();
			Iterator<Entry<Character, Integer>>  ir = es.iterator();
			while (ir.hasNext()) {
				Entry<Character,Integer> entry = ir.next();
				char  key = entry.getKey();
				int     value = entry.getValue();
			 
				System.out.printf(" %c(%d) : %s\n",
                                                 key  ,  value , "#".repeat(value)
				
              ); 
				
			}
			
		} catch (Exception e) {
			System.out.println( e.toString() );
		}

	} // main

} // class











