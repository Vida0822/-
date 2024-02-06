package days25;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오후 3:26:34
 * @subject    HashMap(신) 과 Hashtable( 구 )
 * @content 
 */
public class Ex07 {

	public static void main(String[] args) {
		/*
		 * 1. Map 인터페이스를 구현한 컬렉션 클래스 
		 * 2. 키(key)와 값(value) 한 쌍으로 관리.   
		 *     1) 엔트리( Entry )
		 *     2) 키(key) 중복 허용 X
		 *          값(value) 중복 허용 O
		 *  3. Vector와 ArrayList 관계와 비슷 ( 멀티 스레드 안전(== 동기화 처리 ))      
		 *  4. Hash : 해싱이라는 기법을 사용하기 때문에 많은 양의 데이터를 검색할 때 성능이 뛰어난다. 
		 *      Tree  트리구조     
		 *      
		 *  [해싱(Hashing)] ? 
		 *  - 해시함수( hash function)를 이용해서 데이터를 해시테이블(hash  table)에 저장하고 
		 *     검색하는 기법을 말한다. 
		 *  - 해시함수( hash function) 는 데이터가 저장되어 있느 곳을 알려 주기 때문에 다량의 
		 *     데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다. 
		 *  - 해싱을 구현한 컬렉션 클래스 :  HashSet,    HashMap, Hashtable 등등       
		 *  
		 * 5. 가능하면 Hashtable 대신에 HashMap을 사용하자 ( 권장 )
		 * 6. 저장할 데이터( 키, 값)의 키를 해시함수에 넣으면 배열의 한 요소를 얻게 되고, 
		 *    다시 그 곳에 연결되어 있는 링크드 리스트에 저장하게 된다. 
		 *   
		 *    예) 데이터(키,값)
		 *        2020.1.1  XXX
		 *    
		 *          [해시함수] 
		 *          
		 *          
		 *               [ 1999  ]
		 *               [   ]
		 *               [   ]            [][][][][][][][][][]
		 *               [   ]              [][][][]
		 *        ->   [2020   ]  연결된  [1.1][][][][][][][][][][][][][][]
		 *               [   ]
		 *               [   ]
		 *               [   ]
		 *     
		 *  
		 * */
		// <E>   Element 요소
		// <T>  Type     자료형 
		// <K  Key, V  Value >
		HashMap<String, String> hm = new HashMap<>();
		hm.put("kenik", "이창익");  // 엔트리( Entry )
		hm.put("admin", "관리자");
		hm.put("hong", "홍길동");
		hm.put("root", "관리자");  // 값(Value) 은 중복 허용 O
		
		hm.replace("root", "관리자", "새관리자");
		System.out.println( hm.replace("hong", "홍길남") ); // oldValue 홍길동
		System.out.println( hm.put("hong", "홍길강") );  // oldValue 홍길남
		
		
		// [문제]
		// key - value 형식으로 모든 엔트리를 출력.
		// "kenik" - "이창익
		// "kenik" - "이창익
		// "kenik" - "이창익
		// "root" - "관리자
		// 1) 모든 키 - keySet()    +// 2) get()
		// java.util.Map.Entry<K, V>
		// key + value = Entry
		Set<Entry<String, String>>  es =hm.entrySet();
		Iterator<Entry<String, String>>  ir = es.iterator();
		while (ir.hasNext()) {
			Entry<String, String> entry = ir.next();
			String k =  entry.getKey();
			String v =  entry.getValue();
			System.out.printf( "%s - %s\n",   k , v  );
		}
		
		/*
		Set<String>  ks = hm.keySet();
		Iterator<String>  ir =  ks.iterator();
		while (ir.hasNext()) {
			String k = (String) ir.next();
			String v = hm.get(k);
			System.out.printf( "%s - %s\n",   k , v  );
		}
		*/
		
		
		// [문제] 모든  value 를 조회(출력)  -  values()
		/*
		Collection<String> vc = hm.values();
		// System.out.println( vc );
		Iterator<String>  ir =  vc.iterator();
		while (ir.hasNext()) {
			String v = (String) ir.next();
			System.out.println(   v   );
		}  
		*/
		
		// hm 안에 있는 모든 key 를 조회.  -  keySet()
		/*
		Set<String>  ks = hm.keySet();
		Iterator<String>  ir =  ks.iterator();
		while (ir.hasNext()) {
			String k = (String) ir.next();
			System.out.println(  k   );
		}
		*/
		
		
		
		/*
		// {hong=홍길동, kenik=이창익, root=관리자, admin=관리자}
		
		// 키(key)은 중복 허용 X, 새로운 값(Value)로 설정되더라...
		hm.put("admin", "이태규");
		
		// 키(key)이 null 허용O, 
		hm.put(  null, "박현주");
		hm.put(  null, null);
		
		System.out.println( hm  );
		
		//  "hong" 키가 존재하냐?
		/*
		hm.containsKey("");
		hm.containsValue("");
 
		
		System.out.println( hm.containsKey("hong") );  // true
		System.out.println( hm.containsKey("park") );  // false
		
		// admin 키가 존재하는 지 확인 후에  값(value)를 진예림으로 수정.
		if (  hm.containsKey("admin")  ) {
			hm.put("admin", "진예림");
		}
		
		// "admin" 키의 값을 얻어와서 출력
		// 4:05 수업 시작~ 
		// hm.merge() // 병합
// 		String value =  hm.get("admin");
//		String value =  hm.get("kkk");
// 		System.out.println( value ); // null
		
		 String value =  hm.getOrDefault("kkk", "익명");
		 System.out.println( value);
		 
		 // get() 와  getOrDefault() 메서드의 차이점. 
		 // null                         , 2번째 매개변수값을 반환.
		
		*/
		
		

	}

}
