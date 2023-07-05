package project.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import project.dao.PayDAO;
import project.model.Item;
import project.model.PayList;
import project.model.Supporter;

public class PayService {

	private PayDAO payDao = new PayDAO();
	
	public PayList selectPro(String procd, String giftcd, String spadd) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			PayList payList = payDao.selectByPROCD(conn, procd, giftcd, spadd);
			
			conn.commit();
			
			return payList;
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn); // service의 주기능 : 잘못되면 전체 롤백 
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	
	}

	public Supporter selectSup(String mcd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Supporter supporter = payDao.selectSup(conn, mcd);
			
			conn.commit();
			
			return supporter;
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn); // service의 주기능 : 잘못되면 전체 롤백 
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public List<Item> selectItem(String procd, String giftcd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			List<Item> item = payDao.selectItem(conn, procd, giftcd);
			
			conn.commit();
			
			return item;
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn); // service의 주기능 : 잘못되면 전체 롤백 
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public void insSupport(String mcd, String procd, String giftcd, String spadd, String total, String addr_cd,
			String pm_cd, String prosup) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			int insResult = payDao.supPay(conn, mcd, procd, giftcd, spadd, total, addr_cd, pm_cd);
			
			if ( insResult == 1 ) {
				payDao.increasedSup(conn, Integer.parseInt(prosup), procd);
			}
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			JdbcUtil.rollback(conn); // service의 주기능 : 잘못되면 전체 롤백 
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}	
	}
	
} // class
