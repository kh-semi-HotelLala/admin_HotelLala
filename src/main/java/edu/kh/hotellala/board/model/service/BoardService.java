package edu.kh.hotellala.board.model.service;

import java.sql.Connection;
import java.util.List;
import static edu.kh.hotellala.common.JDBCTemplate.*;

import edu.kh.hotellala.board.model.dao.BoardDAO;
import edu.kh.hotellala.board.model.vo.BoardQNA;

public class BoardService {

	BoardDAO dao = new BoardDAO();
	
	/**qna목록 전체 조회 Select
	 * @return list 
	 * @throws Exception
	 */
	public List<BoardQNA> selectQnaList()throws Exception{
		Connection conn = getConnection();
		
		List<BoardQNA> list = dao.selectQnaList(conn);

		close(conn);
		
		return list;
	}

}
