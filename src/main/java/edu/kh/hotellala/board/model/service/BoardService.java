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
		
		for(Board item : list) {
			item.getContent().replaceAll("(\r\n|\r|\n|\n\r)", " ");
		}
		
		close(conn);
		
		return list;
	}

	/**모든 Notice 목록 전체 조회 Service
	 * @return list
	 * @throws Exception
	 */
	public List<Board> selectNoticeList()throws Exception{
		Connection conn = getConnection();
		List<Board> list = dao.selectNoticeList(conn);
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

	/**원하는 FAQ만 조회
	 * @param key
	 * @return list
	 * @throws Exception
	 */
	public List<Board> searchList(String key,int boardNo)throws Exception{
		Connection conn = getConnection();
		int cNo=0;
		switch(key){
			case "other":cNo=1; break;
			case "payment":cNo=3; break;
			case "reservation":cNo=4; break;
			case "facilities":cNo=5; break;
			case "group":cNo=6; break;
		}
		
		List<Board> list = dao.searchList(conn,cNo,boardNo);
		
		close(conn);
		
		return list;
	}

	/** 게시글을 작성 후 결과에 따라서 작성한 게시판 경로를 반환한다.
	 * @param board
	 * @param boardType 
	 * @return path
	 * @throws Exception
	 */
	public String writeBoard(Board board, int boardType)throws Exception{
		Connection conn =getConnection();
		
		int result = dao.writeBoard(conn,board,boardType);
		
		//삽입에 성공하면 트랜잭션 처리와 동시에 경로를 path에 저장함.
		//실패한 경우 다시 작성 페이지로 이동함
		String path = "";
		if(result>0) {
			commit(conn);
			switch (boardType) {
			case 1:path = "notice"; break;
			case 2:path = "faq";break;
			}
		}else {
			rollback(conn);
			path = "write";
		}
		
		close(conn);
		
		return path;
	}

	/**공지 상세조회
	 * @param i
	 * @return
	 */
	public Board noticeDetail(int i)throws Exception{
		Connection conn = getConnection();
		Board notice = dao.noticeDetail(conn,i); 
		notice.setContent(notice.getContent().replaceAll("(\r\n|\r|\n|\n\r)", " "));
		close(conn);
		return notice;
	}

	
}
