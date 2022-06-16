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
				
				rc.setPaymentDate(rs.getString("PAYMENT_DT"));
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
				
				detail.setRequestNo(rs.getString(1));
				detail.setPaymentDate(rs.getString(2));
				detail.setRoomNo(rs.getInt(3));
				detail.setCheckIn(rs.getDate(4));
				detail.setDateRange(rs.getString(5));
				detail.setRoomType(rs.getString(6));
				detail.setAdultCount(rs.getInt(7)+rs.getInt(8));
				
				detail.setMemberName(rs.getString(9));
				detail.setMemberTel(rs.getString(10));
				detail.setMemberBR(rs.getString(11));
				detail.setMemberAddress(rs.getString(12));
				detail.setExtraRequest(rs.getString(13));
			
				
			}
			
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return detail;
	}
	
	
	/**
	 * 예약 상태 조회 DAO
	 * @param conn
	 * @param requestNo
	 * @return status
	 * @throws Exception
	 */
	public Reservation reserveStatus(Connection conn, String requestNo) throws Exception {
		
		Reservation status = null;
		
		try {
			
			String sql = prop.getProperty("reserveStatus");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, requestNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				status = new Reservation();
				
				status.setReservationFlag((rs.getString(1)).charAt(0));
				status.setRefundFlag((rs.getString(2)).charAt(0));
				
			}
			
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return status;
	}
	
	
	
	/**
	 * 결제 정보 조회 DAO 
	 * @param conn
	 * @param requestNo
	 * @return payment
	 * @throws Exception
	 */
	public Reservation reservePayment(Connection conn, String requestNo) throws Exception{
		
		Reservation payment = null;
		
		try {
			
			String sql = prop.getProperty("reservePayment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, requestNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				payment = new Reservation();
				
				payment.setRoomRates(rs.getInt(1));
				payment.setOptionType(rs.getString(2));
				payment.setPayType(rs.getString(3));
				payment.setPaymentAmount(rs.getInt(4));
				
			}
			
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return payment;
	}

	
	
	
	
	/**
	 * 층별 객실 조회 DAO
	 * @param conn
	 * @param roomType
	 * @return room
	 * @throws Exception
	 */
	public List<Reservation> selectFloor(Connection conn, String roomType) throws Exception{
		
		List<Reservation> room = new ArrayList<Reservation>();
		
		try {
			
			String sql = prop.getProperty("selectFloor");
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, roomType);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Reservation r = new Reservation();
				
				r.setRequestNo(rs.getString(1));
				r.setCheckIn(rs.getDate(2));
				r.setCheckOut(rs.getDate(3));
				r.setDateRange(rs.getString(4));
				r.setRoomNo(rs.getInt(5));
				r.setMemberName(rs.getString(6));
				
				room.add(r);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("룸"+room);
		return room;
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
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Reservation r = new Reservation();
				
				r.setRefundNo(rs.getInt(1));
				r.setMemberName(rs.getString(2));
				r.setRoomNo(rs.getInt(3));
				r.setPaymentDate(rs.getString(4));
				r.setRefundDate(rs.getDate(5));
				r.setRefundFlag(rs.getString(6).charAt(0));
				
				refundList.add(r);
				
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return refundList;
	}



	




	



	






	
	
	
	

}