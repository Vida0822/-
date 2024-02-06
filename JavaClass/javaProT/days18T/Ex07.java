package days18;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface IA{
	void aaa();  // 추상 메서드 
}

interface IB{
	void bbb();
}

interface IC extends IA,IB{
	// void aaa();
	// void bbb();
	void ccc();
}

// abstract class Ex00  implements IA{
class Ex00  implements IC{

	@Override
	public void aaa() {
	 
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ccc() {
		// TODO Auto-generated method stub
		
	}
	
}


