package project.model;

public class Item {

	private String item_name; // 아이템 이름
	private int item_cnt;
	
	public Item() {
		super();
	}
	public Item(String item_name, int item_cnt) {
		super();
		this.item_name = item_name;
		this.item_cnt = item_cnt;
	}
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_cnt() {
		return item_cnt;
	}
	public void setItem_cnt(int item_cnt) {
		this.item_cnt = item_cnt;
	}
	
}
