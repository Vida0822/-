package days25;

/**
 * @author ♈ k§nik
 * @date 2023. 3. 2. - 오후 12:32:15
 * @subject 
 * @content 
 */
public class Ex04_02 {

	public static void main(String[] args) {
		Student s1 =  new Student("200101", "김동현", "26");
		System.out.println( s1.hashCode() );  // 1521118594
		
		Student s2 =  new Student("200101", "김동현", "26");
		// Student s2 = s1;
		System.out.println( s2.hashCode() );  // 1940030785
		System.out.println( s1.equals(s2) );  // 1940030785
		

	}

}
