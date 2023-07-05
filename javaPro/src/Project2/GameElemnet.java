package Project2;

public class GameElemnet {
	public String [] names;
	public int setNumber;
	
	public GameElemnet() {
		
	}
	
	public GameElemnet(String[] names, int setNumber) {
		this.names = names;
		this.setNumber = setNumber;
	}
	public String[] getNames() {
		return names;
	}
	
	public void setName(String[] names) {
		this.names = names;
	}

	public int getsetNumber() {
		return setNumber;
	}

	public void setsetNumber(int setNumber) {
		this.setNumber = setNumber;
	}
	
}
