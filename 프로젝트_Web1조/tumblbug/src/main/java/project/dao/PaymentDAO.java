package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import project.model.DetailCategory;
import project.model.Payment;
import project.model.Project;

public class PaymentDAO {

	// 필드 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 생성자 
	public PaymentDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDAO(Connection conn) {
		super();
		// TODO Auto-generated constructor stub
	}

	// 메서드 
	public ArrayList<Payment> select(Connection conn) throws SQLException {
		ArrayList<Payment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * "
					+ "FROM PAYMENT_PLAN "; 

			pstmt =  conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Payment payment = null;
			if (rs.next()) {
				list = new ArrayList<Payment>(); 
				do {
					payment = new Payment(						
							rs.getString("pay_cd"), 
							rs.getString("pay_name"), 
							rs.getString("pay_fee")
							);
					list.add(payment); 
				} while ( rs.next() );
			} // if
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
	return list;
	}
}