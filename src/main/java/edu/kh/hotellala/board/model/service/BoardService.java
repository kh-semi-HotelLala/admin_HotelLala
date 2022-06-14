package edu.kh.hotellala.board.model.service;

import java.sql.Connection;
import java.util.List;
import static edu.kh.hotellala.common.JDBCTemplate.*;

import edu.kh.hotellala.board.model.dao.BoardDAO;
import edu.kh.hotellala.board.model.vo.Board;
import edu.kh.hotellala.board.model.vo.BoardQNA;

public class BoardService {

	BoardDAO dao = new BoardDAO();
	
	/**모든 QNA 목록 전체 조회 Select 
	 * @return list 
	 * @throws Exception
	 */
	public List<BoardQNA> selectQnaList()throws Exception{
		Connection conn = getConnection();
		
		List<BoardQNA> list = dao.selectQnaList(conn);

		close(conn);
		
		return list;
	}

	/**모든 FAQ목록 전체 조회 Select 
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectFaqList()throws Exception{
		Connection conn = getConnection();
		
		List<Board> list = dao.selectFaqList(conn);

		close(conn);
		
		return list;
	}

}
