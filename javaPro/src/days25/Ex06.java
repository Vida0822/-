package days25;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author dlsgu
 * @date 2023. 3. 2. - 오후 2:17:42
 * @subject 
 * @content 
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		/* Set 인터페이스를 구현한 컬렉션 클래스 : HashSet
		 * [TreeSet]
		 * 1. 중복 허용 X, 순서 유지 X(순서를 유지할 필요가 없다)
		 * 2. 이진 검색 트리를 사용해서 데이터를 순서대로 저장한다
		 * 3. 검색, 정렬, 범위 검색을 하는데 뛰어난 성능을 보이는 컬렉션 클래스이다
		 * 4. 링크드리스트처럼 노트(Node)가 서로 연결된 구조이다
		 * 5. 최상위 노드를 "루트(root)노드"라고 한다
		 * 	부모 - 자식 노드 관계
		 * 	형제 노드 관계
		 * 6. class TreeNode {
		 * 		TreeNode 왼쪽자식노드;
		 * 		Object value;
		 * 		TreeNode 오른쪽자식노드;
		 * 	}
		 * 7. [이진 검색 트리 구조] 
		 * 	부모노드의 왼쪽에는 부모노드의 값보다 작은 값의 자식노드를 위치(배치)시킨다
		 * 	부모노드의 오른쪽에는 부모노드의 값보다 큰 값의 자식노드를 위치(배치)시킨다
		 * 8. TreeSet도 Set 계열이므로 중복을 허용하지 않기 때문에
		 * 	  저장되는 객체(값)가 Comparable 구현 또는 Comparator(비교기) 제공
		 * */
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		ts.add(7);
		ts.add(4);
		ts.add(9);
		ts.add(1);
		ts.add(5);
		ts.add(6);
		// 추가한 순서대로 유지 X
		// 오름차순 정렬
		// [1, 4, 5, 6, 7, 9]
		System.out.println(ts);
		System.out.println(ts.first()); // 정렬된 순서에서 첫번째 값(객체)를 반환하는 메서드
		System.out.println(ts.last()); // 정렬된 순서에서 마지막 값(객체)를 반환하는 메서드
		
		SortedSet<Integer> ss = ts.subSet(1, 7);
		System.out.println(ss); // [1, 4, 5, 6]

		//higher(1) : 지정된 값(객체==1)보다 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환
		System.out.println(ts.higher(1)); // 4
		System.out.println(ts.lower(1)); // null
		// floor(3) : 지정된 값(3)과 같은 객체를 반환
		//			  트리 구조에 3값이 없으면 작은 값을 가진 객체 중 제일 가까운 값을 반환
		System.out.println(ts.floor(3)); // 1
		// floor(3) : 지정된 값(3)과 같은 객체를 반환
		//			  트리 구조에 3값이 없으면 큰 값을 가진 객체 중 제일 가까운 값을 반환
		System.out.println(ts.ceiling(3)); // 4

	}//main

}//class
