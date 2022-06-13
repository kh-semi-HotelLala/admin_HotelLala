package edu.kh.hotellala.reservation.model.service;

import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.Map;

import edu.kh.hotellala.reservation.model.dao.ReserveDAO;

public class ReserveService {
	
	private ReserveDAO dao = new ReserveDAO();

	
	
	/**
	 * 게시글 목록 조회	Service
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectReserveList(int cp) throws Exception {
		
		Connection conn = getConnection();
		
		// 현재 게시판 전체 게시글 수 조회 DAO 호출
		
		// 전체 게시글 수 + 현재 페이지 이용해 페이지네이션 객체 생성
		
		// 게시글 목록 조회
		
		// Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
		
		close(conn);
		
		return null;
	}

}
