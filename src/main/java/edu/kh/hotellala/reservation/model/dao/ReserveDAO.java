package edu.kh.hotellala.reservation.model.dao;

import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.jsp.jstl.sql.Result;

import edu.kh.hotellala.reservation.model.vo.Member;
import edu.kh.hotellala.reservation.model.vo.Payment;
import edu.kh.hotellala.reservation.model.vo.Reservation;

public class ReserveDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;

	
	public ReserveDAO() {
		
		try {
			prop = new Properties();
			
			String filePath = ReserveDAO.class.getResource("/edu/kh/hotellala/sql/reserve-sql.xml").getPath();
			
			prop.loadFromXML( new FileInputStream(filePath) );
		 
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	
	/**
	 * 예약 목록 조회 DAO
	 * @param conn
	 * @return reserveList
	 * @throws Exception
	 */
	public List<Reservation> selectReserveAll(Connection conn) throws Exception{
		
		List<Reservation> reserveList = new ArrayList<Reservation>();
		
		try {
			
			String sql = prop.getProperty("selectReserveAll");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Reservation rc = new Reservation();
				
				rc.setPaymentDate(rs.getDate("PAYMENT_DT"));
				rc.setMemberName(rs.getString("MEMBER_NM"));
				rc.setRoomNo(rs.getInt("ROOM_NO"));
				rc.setCheckIn(rs.getDate("CHECK_IN"));
				rc.setCheckOut(rs.getDate("CHECK_OUT"));
				rc.setRequestNo(rs.getString("REQUEST_NO"));
				
				reserveList.add(rc);
			}	
			
		} finally {
			close(stmt);
			close(rs);
		}		
		
		return reserveList;
	}



	/**
	 * 검색 목록 조회 DAO
	 * @param conn
	 * @param condition
	 * @return searchReserveList
	 * @throws Exception
	 */
	public List<Reservation> searchReserveList(Connection conn, String condition) throws Exception{
		
		List<Reservation> searchReserveList = new ArrayList<Reservation>();
		
		try {
			
			String sql = prop.getProperty("searchReserveList");
			
			
		} finally {
			
		}
		
		return searchReserveList;
	}



	
	
	/**
	 * 예약 상세 조회 DAO
	 * @param conn
	 * @param requestNo
	 * @return detail
	 * @throws Exception
	 */
	public Reservation selectReserveDetail(Connection conn, String requestNo) throws Exception{
		
		Reservation detail = null;
		
		try {
			
			String sql = prop.getProperty("selectReserveDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, requestNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				detail= new Reservation();
				
				detail.setRequestNo(rs.getString("REQUEST_NO"));
				
			}
			
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return detail;
	}
	
	
	



	/**
	 *  환불 전체 조회 DAO
	 * @param conn
	 * @return refundList
	 * @throws Exception
	 */
	public List<Reservation> selectRefundAll(Connection conn) throws Exception {
		
		List<Reservation> refundList = new ArrayList<Reservation>();
		
		try {
			
			String sql = prop.getProperty("selectRefundAll");
			
			
			
			
		} finally {
			
		}
		
		return refundList;
	}



	
	
	
	

}