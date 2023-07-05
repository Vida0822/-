package days15;

public class Person {
	
	// 필드
	private String name;
	private int age;  // 왜 ? 접근지정자를 private 선언,  같은 클래스 내에서만 접근(참조) 가능
	private boolean gender;  // getter, setter   겟셋 만드세요.. 
	// Person this;
	
	// 단축키   Alt + Shift + S 
	
	public void setAge( int a ) {
		if( a >= 0 && a <= 125 )		    age = a;
		else                              			System.out.println("유효하지 않은 나이입니다.");
	}

	public String getName() {
		return name;
	}

	// this.
	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	// this.
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
 
	public int getAge() {
		return age;
	}
 

}





