package edu.kh.hotellala.board.model.service;

import java.sql.Connection;
import java.util.List;
import static edu.kh.hotellala.common.JDBCTemplate.*;

import edu.kh.hotellala.board.model.dao.BoardDAO;
import edu.kh.hotellala.board.model.vo.Board;
import edu.kh.hotellala.board.model.vo.BoardQNA;

public class BoardService {

	BoardDAO dao = new BoardDAO();
	
	/**모든 QNA 목록 전체 조회 Service 
	 * @return list 
	 * @throws Exception
	 */
	public List<BoardQNA> selectQnaList()throws Exception{
		Connection conn = getConnection();
		List<BoardQNA> list = dao.selectQnaList(conn);
		close(conn);
		return list;
	}

	/**모든 FAQ목록 전체 조회 Service 
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectFaqList()throws Exception{
		Connection conn = getConnection();
		
		List<Board> list = dao.selectFaqList(conn);

		close(conn);
		
		return list;
	}

	/**게시글 상세내용 조회 Service
	 * @param parameter
	 * @return qnaDetail
	 * @throws Exception
	 */
	public BoardQNA selectQnaDetail(int no)throws Exception{
		Connection conn = getConnection();
		
		BoardQNA qna = dao.selectQnaDetail(conn,no);
		
			if(qna != null) {
				//나중에 추가될 이미지 저장용객체
			}
			
		close(conn);
		
		return qna;
	}

	
	/*
	 * public int deleteQNA(int no)throws Exception{ Connection conn =
	 * getConnection();
	 * 
	 * int result = dao.deleteQNA(conn,no);
	 * 
	 * if(result>0)commit(conn); else rollback(conn);
	 * 
	 * close(conn);
	 * 
	 * return result; }
	 */

}
