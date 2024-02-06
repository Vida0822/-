package days14;

// 학생 클래스 
public class Student {
	
	// 필드
	public int no; 
	public String name;
	public int kor;
	public int eng;
	public int mat;
	public int tot;
	public double avg;
	public int rank;
	
	// 메서드 
	public String getStudentInfo() {
	   return	String.format("[%d]\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d"
				,no, name, kor, eng, mat, tot, avg, rank);
	}

}
