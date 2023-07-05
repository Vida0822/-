package days14;

// package( == default ) 접근지정자를 선택.
class Person {
	
	// fields
	public String name;
	public int age;
	
	// methods
	public void walk() {
		System.out.println("사람이 걷는다.");
	}
	public void run() {
		System.out.printf("%s이 뛴다\n", name);
	}

}
