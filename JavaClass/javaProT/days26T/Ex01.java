package days26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author ♈ kenik
 * @date 2023. 3. 3. - 오전 8:36:14
 * @subject  
 * @content
 *
 */
public class Ex01 {

	public static void main(String[] args) {
		//  9:40 제출
		/*
		 * 1조_연봉1조          : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범 (화요일)
		 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
		 * 3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
		 */    
		    
		String [] 팀1 = {  "이태규", "김지은", "설경인", " 윤재민", "홍성철", "김동현", "박상범", "이예진" };
		String [] 팀2 = { "하동호", "박진용", "이혜진", "김수민", "신희민", "진예림", "박현주" };
		String [] 팀3 = { "박민종", "심성환", "이진우", "홍찬기", "김예지", "하지예", "탁인혁" };
		
		// 1)  각 팀원들을 ArrayList 객체에 요소로 저장을 했습니다. 
		ArrayList<String> team1 = new ArrayList<String>();
		for (int i = 0; i < 팀1.length; i++) 			team1.add( 팀1[i]  );		
		System.out.println( team1 ); // [이태규, 김지은, 설경인,  윤재민, 홍성철, 김동현, 박상범]
	 
		// String[]      -> List     -> ArrayList 변환
		//        Arrays 클래스의 asList() 메서드 
		List<String> temp =  Arrays.asList(팀2); 
		ArrayList<String> team2 = new ArrayList<String>(temp);
		System.out.println(  team2 );
		 
		ArrayList<String> team3 = new ArrayList<String>(  Arrays.asList(팀3)   );
		System.out.println(  team3 );
		
		// 10:15 수업 시작~ 
		// 2) HashMap 각 팀을 엔트리로 저장. 
		HashMap<String, ArrayList<String>>  class5Map = new HashMap<>();
		class5Map.put("연봉1조", team1);
		class5Map.put("귀염2(이)조", team2);
		class5Map.put("자바를 잡아", team3);
		
		printMap(  class5Map   );
		

	} // main

	private static void printMap( HashMap<String, ArrayList<String>> class5Map) {
		//  1조_연봉1조(7명)
		//       ㄴ
		// 2조_귀염2(이)조(7명)
		//       ㄴ
		// 3조_자바를 잡아(8명)
		//       ㄴ
		//       ㄴ
		//       ㄴ
		//       ㄴ
		
		Set<Entry<String, ArrayList<String>>>  es =    class5Map.entrySet();
		Iterator<Entry<String, ArrayList<String>>>  ir = es.iterator();
		int n = 1;
		while (ir.hasNext()) {
			Entry<String, ArrayList<java.lang.String>> entry =  ir.next();
			String key = entry.getKey(); // 팀명
			ArrayList<String> value = entry.getValue();
//			int count = value.size();
			System.out.printf("%d조_%s(%d명)\n", n++, key, value.size() );
			
			Iterator<String> ir2 =  value.iterator();
			while (ir2.hasNext()) {
				String name = ir2.next();
				System.out.printf("\t\tㄴ %s\n", name);
				
			}
			
			
		} // while
		
		
	}

} // class










/*
 * 1조_연봉1조          : [팀장]이태규(*), 김지은(*), 설경인(*), 윤재민(*), 홍성철, 김동현, 박상범, 이예진 (화요일)
 * 2조_귀염2(이)조  : [팀장]하동호(*), 박진용(*), 이혜진(*), 김수민, 신희민, 진예림, 박현주 (수요일)
 * 3조_자바를 잡아  : [팀장]박민종(*), 심성환(*), 이진우(*), 홍찬기(*), 김예지, 하지예 , 탁인혁 (목요일)
 */
