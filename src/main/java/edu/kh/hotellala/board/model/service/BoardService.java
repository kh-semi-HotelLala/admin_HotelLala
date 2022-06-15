package edu.kh.hotellala.board.model.service;

import java.sql.Connection;
import java.util.List;
import static edu.kh.hotellala.common.JDBCTemplate.*;

import edu.kh.hotellala.board.model.dao.BoardDAO;
import edu.kh.hotellala.board.model.vo.Board;
import edu.kh.hotellala.board.model.vo.BoardQNA;
import edu.kh.hotellala.common.Util;

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

	/**QNA 상세내용 조회 Service
	 * @param parameter
	 * @return qnaDetail
	 * @throws Exception
	 */
	public BoardQNA selectQnaDetail(int no)throws Exception{
		Connection conn = getConnection();
		
		BoardQNA qna = dao.selectQnaDetail(conn,no);
		
		qna.setTitle(Util.reverseLineHandling( qna.getTitle()));
		qna.setContent(Util.reverseLineHandling( qna.getContent()));
	
		//만약 답변이 있는 경우에만 답변 개행 처리
		if(qna.getAnswer()=='Y') {
			qna.setAnswerContent(Util.reverseLineHandling( qna.getAnswerContent()));
		}
		
		close(conn);
		
		return qna;
	}

	/**QNA 답변 작성 Service
	 * @param no
	 * @param adminNo
	 * @param inputAnswer
	 * @return result
	 * @throws Exception
	 */
	public int insertAnswer(int no, int adminNo, String inputAnswer)throws Exception{
		Connection conn = getConnection();
		
		inputAnswer = Util.XssHandling(inputAnswer);
		inputAnswer = Util.newLineHandling(inputAnswer);
		int result = dao.insertAnswer(conn,no,adminNo,inputAnswer);
		
		if(result>0)commit(conn);
		
		else rollback(conn);;
		close(conn);
		return result;
	}
	
	/**QNA검색 
	 * @param category 
	 * @param answer 
	 * @return list
	 * @throws Exception
	 */
	public List<BoardQNA> searchQnaList(char answer, int category)throws Exception{
		Connection conn = getConnection();
		List<BoardQNA> list = dao.searchQnaList(conn,answer,category);
		close(conn);
		return list;
	}

	public List<Board> searchFaqList(String key)throws Exception{
		Connection conn = getConnection();
		int cNo=0;
		switch(key){
			case "other":cNo=1; break;
			case "payment":cNo=3; break;
			case "reservation":cNo=4; break;
			case "facilities":cNo=5; break;
			case "group":cNo=6; break;
		}
		
		List<Board> list = dao.searchQnaList(conn,cNo);
		
		close(conn);
		
		return list;
	}
}
