package article.model;

public class Writer {

	private String id;
	private String name;
	// 이거 굳이 왜 받아줬니?? 

	public Writer(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
