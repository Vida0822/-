package days04;

// Lombok 사용하면 DTO 선언안해도 됨
public class SalgradeDTO {

	private int grade;
	private int losal;
	private int hisal; 
	private int cnt; // 등급 사원수
	
	public SalgradeDTO(int grade, int losal, int hisal, int cnt) {
		super();
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
		this.cnt = cnt;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getLosal() {
		return losal;
	}

	public void setLosal(int losal) {
		this.losal = losal;
	}

	public int getHisal() {
		return hisal;
	}

	public void setHisal(int hisal) {
		this.hisal = hisal;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return String.format("%d등급 (%d~%d) - %d명"
						, this.grade, this.losal, this.hisal, this.cnt );
	}
	
	
	
}
