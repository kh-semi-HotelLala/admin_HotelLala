package edu.kh.hotellala.reservation.model.service;

import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.hotellala.reservation.model.dao.ReserveDAO;
import edu.kh.hotellala.reservation.model.vo.ReserveCheck;

public class ReserveService {
	
	private ReserveDAO dao = new ReserveDAO();

	
	/**
	 * 예약 목록 조회 Service
	 * @return reserveList
	 * @throws Exception
	 */
	public List<ReserveCheck> selectReserveAll() throws Exception{
		
		Connection conn = getConnection();
//		
		List<ReserveCheck> reserveList = dao.selectReserveAll(conn);
		
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
	public List<ReserveCheck> searchReserveList(String select, String query) throws Exception{
		
		Connection conn = getConnection();
		
		// sql 조건절에 추가될 구문 가공(key, query)
		String condition = null;
		
		switch(select) {
		case "reserve-date" : condition = " AND PAYMENT_DT LIKE '%" + query + "%' "; break;
		case "room-num" : condition = " AND ROOM_NO LIKE '%" + query + "%' "; break;
		case "member-name" : condition = " AND MEMBER_NM LIKE '%" + query + "%' "; break;
		}
		
		List<ReserveCheck> searchReserveList = dao.searchReserveList(conn, condition);
		
		close(conn);
		
		return searchReserveList;
	}



	/**
	 * 예약 상세 조회 Service
	 * @param reservationNo
	 * @return reserveDetail
	 * @throws Exception
	 */
	public List<ReserveCheck> selectReserveDetail(int reservationNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<ReserveCheck> reserveDetail = dao.selectReserveDetail(conn, reservationNo);
		
		close(conn);
		
		return reserveDetail;
	}



	/**
	 * 환불 목록 조회 Service
	 * @return 
	 * @throws Exception
	 */
	public List<ReserveCheck> selectRufundAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	



	
	
	
	
	
	
	
	


	

	
}
