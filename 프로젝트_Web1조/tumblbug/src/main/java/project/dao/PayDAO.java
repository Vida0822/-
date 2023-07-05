package project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import project.model.Item;
import project.model.PayList;
import project.model.Supporter;

public class PayDAO {
	//필드
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 생성자 
	public PayDAO() {
		super();		
	}

	public PayDAO(Connection conn) { // 
		super();		
		this.conn = conn;
	}
	// 메서드
	// SumByProCd
	public int SumByProCd(Connection conn, String pro_cd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		String sql = "SELECT SUM(sp_total) sum  "
				+ "FROM SP_PAY "
				+ "WHERE pro_cd = ? ";
	
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1,pro_cd);
		rs = pstmt.executeQuery();
		
		int paySum = 0;
		if (rs.next()) {
			paySum = rs.getInt("sum"); 
		}
		return paySum;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
	} // selectByProCd
	
	public int countByGiftCd(Connection conn, String gift_cd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT Count(*) count  "
					+ "FROM SP_PAY "
					+ "WHERE gift_cd = ? ";
		
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,gift_cd);
			rs = pstmt.executeQuery();
			
			int buyers = 0;
			if (rs.next()) {
				buyers = rs.getInt("count"); 
			}
			return buyers;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // finally
	} // SumByGiftCd
	
	public PayList selectByPROCD(Connection conn, String procd, String giftcd, String spadd) throws SQLException {
		ResultSet rs = null;
		PayList payList = null;
		
		String sql = "SELECT t.*, ROUND(pro_total/pro_price*100) achv "
				+ "FROM( "
				+ "    SELECT dtl_ctg_name, m_name, pro_long, SUM(sp_total) pro_total, pro_price, CEIL(TO_DATE(pro_end, 'RR/MM/DD') - SYSDATE) remain, gift_desc, item_name, item_cnt, gift_min, gift_dlv, pro_end + 1 pro_end, pro_sup "
				+ "    FROM project a "
				+ "        JOIN member c ON a.m_cd = c.m_cd "
				+ "        JOIN gift d ON a.pro_cd = d.pro_cd "
				+ "        JOIN item_set e ON e.gift_cd = d.gift_cd "
				+ "        JOIN item f ON f.item_cd = e.item_cd "
				+ "        JOIN sp_pay h ON h.pro_cd = a.pro_cd "
				+ "        JOIN dtl_ctg i ON i.dtl_ctg_code = a.dtl_ctg_code "
				+ "    WHERE a.pro_cd = ? AND d.gift_cd = ? "
				+ "    GROUP BY dtl_ctg_name, m_name, pro_long, pro_price, CEIL(TO_DATE(pro_end, 'RR/MM/DD') - SYSDATE), gift_desc, item_name, item_cnt, gift_min, gift_dlv, pro_end, pro_sup "
				+ ") t ";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, procd);
			pstmt.setString(2, giftcd);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				String dtl_ctg_name = rs.getString("dtl_ctg_name");
				String m_name = rs.getString("m_name");
				String pro_long = rs.getString("pro_long");
				int pro_total = rs.getInt("pro_total");
				int pro_price = rs.getInt("pro_price");
				int remain = rs.getInt("remain");
				String gift_desc = rs.getString("gift_desc");
				int gift_min = rs.getInt("gift_min");
				Date gift_dlv = rs.getDate("gift_dlv");
				Date pro_end = rs.getDate("pro_end");
				int pro_sup = rs.getInt("pro_sup");
				int achv = rs.getInt("achv");
				
				payList = new PayList(dtl_ctg_name, m_name, pro_long, pro_total, pro_price, remain, gift_desc, gift_min, gift_dlv, pro_end, pro_sup, achv);
				payList.setSp_add( Integer.parseInt(spadd) );
				payList.setTotal( payList.getGift_min() + Integer.parseInt(spadd) );
			}
			
			return payList;
		}  finally {
			JdbcUtil.close(rs);
		}
		
	}

	public Supporter selectSup(Connection conn, String mcd) throws SQLException {
		Supporter supporter = null;
		ResultSet rs = null;
		
		String sql = "SELECT m_tel, m_email, addr_cd, addr_rec, addr_postal, addr_detail, addr_tel, addr_default, pm_cd, pm_default, card_number, acnt_bank, acnt_number "
				+ "FROM member a FULL OUTER JOIN address b ON a.m_cd = b.m_cd "
				+ "    FULL OUTER JOIN pay_method c ON a.m_cd = c.m_cd "
				+ "    FULL OUTER JOIN card_info d ON c.card_cd = d.card_cd "
				+ "    FULL OUTER JOIN account_info e ON e.acnt_cd = c.acnt_cd "
				+ "WHERE a.m_cd = ? ";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, mcd);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				String m_tel = rs.getString("m_tel");
				String m_email = rs.getString("m_email");
				String addr_cd = rs.getString("addr_cd");
				String addr_rec = rs.getString("addr_rec");
				String addr_postal = rs.getString("addr_postal");
				String addr_detail = rs.getString("addr_detail");
				String addr_tel = rs.getString("addr_tel");
				String addr_default = rs.getString("addr_default");
				String pm_cd = rs.getString("pm_cd");
				String pm_default = rs.getString("pm_default");
				long card_number = rs.getLong("card_number");
				String acnt_bank = rs.getString("acnt_bank");
				long acnt_number = rs.getLong("acnt_number");
				
				supporter = new Supporter(m_tel, m_email, addr_cd, addr_rec, addr_postal, addr_detail, addr_tel, addr_default, pm_cd, pm_default, card_number, acnt_bank, acnt_number);
			}
			
			return supporter;
		} finally {
			JdbcUtil.close(rs);
		}
		
	}
	
	public List<Item> selectItem(Connection conn, String procd, String giftcd) throws SQLException {
		ResultSet rs = null;
		List<Item> list = null;
		Item item = null;
		
		String sql = "SELECT item_name, item_cnt "
				+ "    FROM project a "
				+ "        JOIN member c ON a.m_cd = c.m_cd "
				+ "        JOIN gift d ON a.pro_cd = d.pro_cd "
				+ "        JOIN item_set e ON e.gift_cd = d.gift_cd "
				+ "        JOIN item f ON f.item_cd = e.item_cd "
				+ "        JOIN sp_pay h ON h.pro_cd = a.pro_cd "
				+ "        JOIN dtl_ctg i ON i.dtl_ctg_code = a.dtl_ctg_code "
				+ "    WHERE a.pro_cd = ? AND d.gift_cd = ? "
				+ "    GROUP BY dtl_ctg_name, m_name, pro_long, pro_price, CEIL(TO_DATE(pro_end, 'RR/MM/DD') - SYSDATE), gift_desc, item_name, item_cnt, gift_min, gift_dlv, pro_end ";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, procd);
			pstmt.setString(2, giftcd);

			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				list = new ArrayList<Item>();
				String item_name;
				int item_cnt;
				
				do {
					item_name = rs.getString("item_name");
					item_cnt = rs.getInt("item_cnt");
					item = new Item(item_name, item_cnt);
					list.add(item);
				} while ( rs.next() );
			}
			
			return list;
		} finally {
			JdbcUtil.close(rs);
		}
		
	}

	public int supPay(Connection conn, String mcd, String procd, String giftcd, String spadd, String total,
			String addr_cd, String pm_cd) throws SQLException {
		int rowCount = 0;
		
		String sql = " INSERT INTO sp_pay (sp_cd, sp_date, sp_total, sp_add, m_cd, pro_cd, addr_cd, pm_cd, gift_cd) "
					   + " VALUES ('SPT' || SEQ_SP_PAY.NEXTVAL, SYSDATE, ?, ?, ?, ?, ?, ?, ? ) ";
				
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, Integer.parseInt(total));
			pstmt.setInt(2, Integer.parseInt(spadd));
			pstmt.setString(3, mcd);
			pstmt.setString(4, procd);
			pstmt.setString(5, addr_cd);
			pstmt.setString(6, pm_cd);
			pstmt.setString(7, giftcd);				

			rowCount = pstmt.executeUpdate();
			
			return rowCount;
		}
		
	}

	public void increasedSup(Connection conn, int prosup, String procd) throws SQLException {
		String sql = " UPDATE project SET pro_sup = pro_sup + 1 WHERE pro_cd = ? ";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, procd);
			pstmt.executeUpdate();
		} 
	}	
	 
}
