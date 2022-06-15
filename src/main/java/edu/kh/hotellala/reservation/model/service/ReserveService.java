package edu.kh.hotellala.reservation.model.service;

import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.hotellala.reservation.model.dao.ReserveDAO;
import edu.kh.hotellala.reservation.model.vo.Reservation;

public class ReserveService {
	
	private ReserveDAO dao = new ReserveDAO();

	
	/**
	 * 예약 목록 조회 Service
	 * @return reserveList
	 * @throws Exception
	 */
	public List<Reservation> selectReserveAll() throws Exception{
		
		Connection conn = getConnection();
//		
		List<Reservation> reserveList = dao.selectReserveAll(conn);
		
		close(conn);
		
		return reserveList;
	}


	
	/**
	 * 검색 목록 조회 Service
	 * @param select
	 * @param query
	 * @return searchReserveList
	 * @throws Exception
	 */
	public List<Reservation> searchReserveList(String select, String query) throws Exception{
		
		Connection conn = getConnection();
		
		// sql 조건절에 추가될 구문 가공(key, query)
		String condition = null;
		
		switch(select) {
		case "reserve-date" : condition = " AND PAYMENT_DT LIKE '%" + query + "%' "; break;
		case "room-num" : condition = " AND ROOM_NO LIKE '%" + query + "%' "; break;
		case "member-name" : condition = " AND MEMBER_NM LIKE '%" + query + "%' "; break;
		}
		
		List<Reservation> searchReserveList = dao.searchReserveList(conn, condition);
		
		close(conn);
		
		return searchReserveList;
	}



	/**
	 * 예약 상세 조회 Service
	 * @param requestNo
	 * @return detail
	 * @throws Exception
	 */
	public Reservation selectReserveDetail(String requestNo) throws Exception{
		
		Connection conn = getConnection();
		
		Reservation detail = dao.selectReserveDetail(conn, requestNo);
		
		close(conn);
		
		return detail;
	}
	



	/**
	 * 환불 목록 조회 Service
	 * @return refundList
	 * @throws Exception
	 */
	public List<Reservation> selectRufundAll() throws Exception {
		
		Connection conn = getConnection();
		
		List<Reservation> refundDetail = dao.selectRefundAll(conn);
		
		close(conn);
		
		return refundDetail;
	}






	



	
	
	
	
	
	
	
	


	

	
}
