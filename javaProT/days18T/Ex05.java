package days18;

/**
 * @author ♈ kenik
 * @date 2023. 2. 20. - 오후 2:03:01
 * @subject  인터페이스 장점.
 * @content
 *
 */
public class Ex05 {

	public static void main(String[] args) {
		// 자바 문법에서 1개만 면접관으로 질문을 해야 하다면  - 다형성
		//                ****  인터페이스 ****
		
		/*
		 * [ 인터페이스의 장점 ] 
		 * 1. 개발 시간을 단축시킬 수 있다. 
		 *     - 인터페이스만 작성이 되면   +        사용하는 곳에서 개발 진행할 수 있기 때문에 
		 *        인터페이스를 구현한 클래스 X
		 *  2. 표준화가 가능하다. 
		 *     IDBConn 인터페이스를     A, B 등등 개발자 구현하더라도 일관되고 정형화된 프로그램 개발이 가능하다. .
		 *  3. 서로 관련없는 클래스 들에게 관계를 맺어 줄 수 있다. 
		 *      서로 관련없는  == 상속관계가 아닌     클래스 들도 같은 인터페이스를 구현하고 있다면 
		 *      관계를 맺어줄 수 있다.         
		 * */
		
		// 오라클 DB 서버
		// MySQL DB 서버
		// 등등
		/*
		DBConn con = new DBConn();
		con.open(); // DB 서버에 연결
		
		// CRUD
		con.select(); // 데이터 조회
		con.insert(); // 데이터 추가
		con.update(); // 데이터 수정
		con.delete();    // 데이터 삭제
		//
		
		con.close(); // DB 서버 닫기
		*/
		
		// 인터페이스를 사용해서 업캐스팅 가능
		// 오라클
		//IDBConn  con = new OracleDBConn();
		
		// MS SQL 서버
		IDBConn  con = new MSSQLDBConn();
		
        con.open(); // DB 서버에 연결
		
		// CRUD
		con.select(); // 데이터 조회
		con.insert(); // 데이터 추가
		con.update(); // 데이터 수정
		con.delete();    // 데이터 삭제
		//
		
		con.close(); // DB 서버 닫기
		


	} // main

} // class




// 오라클 DBMS <-연동-> 자바 프로그램  : 데이터 처리( CRUD )
/*
class DBConn{
	void open() {
		// 모든 구현이 되어져 있다. 
	}
	void close() {}
	void insert() {}
	void select() {}
	void update() {}
	void delete() {}
}
*/



















