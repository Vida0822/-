package days25;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author dlsgu
 * @date 2023. 3. 2. - 오후 4:44:36
 * @subject 
 * @content 
 *
 */
public class Ex08 {

	public static void main(String[] args) {
		// 파일 읽어와서 'A' 20 -> ##### 그래프 days20.Ex12
		String fileName = "days20\\Ex01.java";
		fileName = String.format("%s\\src\\%s", System.getProperty("user.dir"), fileName);
		// int [][] counts = new int[2][26]; // A ~ Z a ~ z
		// k + v = entry -> HashMap
		//'A'  1
		HashMap<Character, Integer> map = new HashMap<>();
		char one = '\u0000';
		int code = 0;
		
		try (FileReader fr = new FileReader(fileName)){
			while ((code = fr.read()) != -1) {
				one = (char)code;
				System.out.println(one);
				// key 존재 유무 확인
				// 1) 키 O	value 1 증가
				// 2) 키 X  value 1
				if (map.containsKey(one)) {
					int value = map.get(one);
					map.put(one, value+1);
				} else {
					map.put(one, 1);
				}
				}
			
			// 막대그래프
			/*
			for (int i = 0; i < counts.length; i++) {
				System.out.printf("%c(%02d) : %s\n", i+'A', counts[i], "#".repeat(counts[i]));
			}
			*/
			Set<Entry<Character, Integer>> es = map.entrySet();
			Iterator<Entry<Character, Integer>> ir = es.iterator();
			while (ir.hasNext()) {
				Entry<Character, Integer> entry =  ir.next();
				char key = entry.getKey();
				int value = entry.getValue();
				System.out.printf("%c(%02d) : %s\n", key, value, "#".repeat(value));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}//main

}//class
