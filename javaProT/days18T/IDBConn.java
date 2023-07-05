package days18;

public interface IDBConn {
	void open();
	void close();
	
	void select();
	void insert();
	void update();
	void delete();
}
