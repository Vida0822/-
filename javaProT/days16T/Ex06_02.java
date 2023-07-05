package days16;

/**
 * @author ♈ kenik
 * @date 2023. 2. 16. - 오후 2:30:11
 * @subject
 * @content
 *
 */
public class Ex06_02 {

	public static void main(String[] args) {
		
		Document doc1 = new Document();  // Noname1.txt
		Document doc2 = new Document();  // Noname2.txt
		Document doc3 = new Document("자바문서.txt"); 
		Document doc4 = new Document();  // Noname3.txt
		Document doc5 = new Document();  // Noname4.txt

	} // main

} // class

class Document{
	// 필드 
	String fileName;
	// 클래스 변수를 선언하는 것 좋겠다.
	static int count = 1;
	
	// 인스턴스  초기화 블럭 - 객체가 생성될 때 마다 호출된다.
	{
		count++;
	}
	
	// 생성자
	public Document() {
		this(String.format("Noname%d.txt", count) ); 
		//count++;
		// this.fileName =  String.format("Noname%d.txt", count) ;
	}
	
	public Document(String fileName) {
		this.fileName = fileName;		
		System.out.printf("문서 \"%s\"가 생성되었습니다.\n", this.fileName);
	}

	
	
}







