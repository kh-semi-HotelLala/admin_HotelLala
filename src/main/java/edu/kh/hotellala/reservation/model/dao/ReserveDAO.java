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

import edu.kh.hotellala.reservation.model.vo.ReserveCheck;

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
	public List<ReserveCheck> selectReserveAll(Connection conn) throws Exception{
		
		List<ReserveCheck> reserveList = new ArrayList<ReserveCheck>();
		
		try {
			
			String sql = prop.getProperty("selectReserveAll");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				ReserveCheck rc = new ReserveCheck();
				
				rc.setPaymentDate(rs.getDate("PAYMENT_DT"));
				rc.setMemberName(rs.getString("MEMBER_NM"));
				rc.setRoomNo(rs.getInt("ROOM_NO"));
				rc.setCheckIn(rs.getDate("CHECK_IN"));
				rc.setCheckOut(rs.getDate("CHECK_OUT"));
				
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
	public List<ReserveCheck> searchReserveList(Connection conn, String condition) throws Exception{
		
		List<ReserveCheck> searchReserveList = new ArrayList<ReserveCheck>();
		
		try {
			
			String sql = prop.getProperty("searchReserveList");
			
			
		} finally {
			
		}
		
		return searchReserveList;
	}



	/**
	 * 예약 상세 조회 DAO 
	 * @param conn
	 * @param reservationNo
	 * @return reserveDetail
	 * @throws Exception
	 */
	public List<ReserveCheck> selectReserveDetail(Connection conn, int reservationNo) throws Exception {
		
		List<ReserveCheck> reserveDetail = new ArrayList<ReserveCheck>();
		
		try {
			
			String sql = prop.getProperty("selectReserveDetail");
			
			
			
			
		} finally {
			
		}
		
		return reserveDetail;
	}
	
	
	
	
	

}