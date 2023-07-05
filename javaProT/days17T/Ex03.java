package days17;

/**
 * @author ♈ kenik
 * @date 2023. 2. 17. - 오전 11:07:08
 * @subject          [  super 키워드 설명 ]
 * @content
 *
 */
public class Ex03 {

	public static void main(String[] args) {
		// 11:18 수업시작~ 
		Child c = new Child();
		
		c.dispChild();
		
		//c.x = 10;
		//System.out.println( c.x );
		
		/*
		 * 자식 객체 c를 생성하는 데...
		 *    ㄴ Parent 생성자 호출
		 *    ㄴ Child    생성자 호출
		 *    
		 *  [생성자 호출되는 순서]
		 *  1. 부모 생성자 먼저 호출되고 자식 생성자 호출된다.   
		 *      부모 객체 생성                       자식 객체 생성
		 *      
		 *  [키워드 설명]
		 *  this     :  클래스(객체)의 자기자신의 주소값을 갖는  참조변수
		 *     this 3가지 용도
		 *     1) 멤버를 가릴킬 때 this
		 *     2) 생성자에서 또 다른 생성자를 호출할 때의 this
		 *     3) 단독으로 사용될 때의 this :  리턴값, 매개변수
		 *     
		 *  super :  자식클래스에서 부모클래스의 멤버를 참조하는 데 사용되는   참조변수
		 *     super 3가지 용도
		 *     1) 부모의 멤버를 가릴킬 때 super
		 *     2) 생성자에서 또 부모의 생성자를 호출할 때의 super()
		 *     3) X
		 * */

	} // main

} // class


class Parent{
	// 필드
	int x = 10;  // 명시적 초기화
	
	Parent(){
		System.out.println("> Parent 디폴트 생성자 호출됨.");
	}
	
    void dispParent() {
    	
    }
}

class Child extends Parent{
	// 부모클래스 상속받은  int x = 10; 
	int y;
	int x = 20;

	public Child() {
		// 생성자는 상속이 안된다 했는데  호출은 가능한 건가요? 네... 
		super(); // 부모의 디폴트 생성자 호출
		System.out.println(">  Child 디폴트 생성자 호출됨.");
	} 
	
	void dispChild() {
		System.out.println("> Parent.x = " + this.x );  // > Parent.x = 20
		System.out.println("> Parent.x = " + super.x );  // > Parent.x = 10
	}
}

/*
1. 강사님
    this나 super가 주소가 담긴 참조변수라면,
     얘네도 stack에 따로 저장되어있는 변수인건가요??
      아니면 인스턴스 변수인데 주소값을 담고 있는건가요...? 
      
2. int x중복선언  오류는 안나는 건가요? 네 
		
*/	



