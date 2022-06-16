package edu.kh.hotellala.board.model.dao;
import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.hotellala.admin.model.dao.AdminDAO;
import edu.kh.hotellala.board.model.vo.Board;
import edu.kh.hotellala.board.model.vo.BoardQNA;

public class BoardDAO {
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	private Properties prop;
	
	//board-sql에서 xml문서 읽어오기
	public BoardDAO(){
		try {
			prop = new Properties();
			String filePath = AdminDAO.class.getResource("/edu/kh/hotellala/sql/board-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	/**모든 QNA 목록 조회 DAO
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<BoardQNA> selectQnaList(Connection conn)throws Exception{
		List<BoardQNA> qnaList = new ArrayList<BoardQNA>();
		try {
			String sql = prop.getProperty("selectQnaList");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardQNA qna = new BoardQNA();
				qna.setQnaNo(rs.getInt(1));
				qna.setCategory(rs.getString(2));
				qna.setTitle(rs.getString(3));
				qna.setAnswer(rs.getString(4).charAt(0));
				qna.setMemberName(rs.getString(5));
				qna.setCreateDt(rs.getString("DT"));
				qnaList.add(qna);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return qnaList;
	}

	/**모든 FAQ 목록 조회 DAQ
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectFaqList(Connection conn)throws Exception{
		List<Board> list = new ArrayList<Board>();
		try {
			String sql = prop.getProperty("selectFaqList");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board faq = new Board();
				faq.setBoardNo(rs.getInt(1));
				faq.setCategory(rs.getString(2));
				faq.setTitle(rs.getString(3));
				faq.setContent(rs.getString(4));
				faq.setCreateDate(rs.getString(5));
				list.add(faq);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	/**모든 Notice 목록 조회DAO
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Board> selectNoticeList(Connection conn)throws Exception {
		List<Board> list = new ArrayList<Board>();
		try {
			String sql = prop.getProperty("selectNoticeList");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board faq = new Board();
				faq.setCategory(rs.getString(1));
				faq.setTitle(rs.getString(2));
				faq.setCreateDate(rs.getString(3));
				faq.setBoardNo(rs.getInt(4));
				list.add(faq);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		return list;
	}
	
	/**QNA 상세 조회 DAO
	 * @param conn
	 * @param no
	 * @return qna
	 * @throws Exception
	 */
	public BoardQNA selectQnaDetail(Connection conn, int no)throws Exception{
		BoardQNA qna = null;
		try {
			String sql = prop.getProperty("selectQnaDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qna = new BoardQNA();
				qna.setQnaNo(rs.getInt(1));
				qna.setCategory(rs.getString(2));
				qna.setTitle(rs.getString(3));
				qna.setAnswer(rs.getString(4).charAt(0));
				qna.setMemberName(rs.getString(5));
				qna.setCreateDt(rs.getString(6));
				qna.setContent(rs.getString(7));
				qna.setMemberTel(rs.getString(8));
				qna.setMemberEmail(rs.getString(9));
				qna.setAnswerContent(rs.getString(10));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return qna;
	}

	/**QNA작성을 위한 DAO
	 * @param conn
	 * @param no
	 * @param adminNo
	 * @param inputAnswer
	 * @return
	 * @throws Exception
	 */
	public int insertAnswer(Connection conn,int no, int adminNo, String inputAnswer)throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertAnswer");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adminNo); //답변한 관리자의 번호
			pstmt.setString(2, inputAnswer); // 답변 내용
			pstmt.setInt(3, no); //답변해줄 게시글 번호
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/**검색된 QNA전체 리스트 조회
	 * @param conn
	 * @param answer
	 * @param category
	 * @return
	 * @throws Exception
	 */
	public List<BoardQNA> searchQnaList(Connection conn, char answer, int category)throws Exception{
		List<BoardQNA> qnaList = new ArrayList<BoardQNA>();
		try {
			String sql = prop.getProperty("searchQnaList1");
			if(category==0) {				sql += prop.getProperty("searchQnaList2");			}
			else {				sql += " AND  CATEGORY_CD =? "+prop.getProperty("searchQnaList2");			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,String.valueOf(answer));
			
			if(category != 0) {
				pstmt.setInt(2, category);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardQNA qna = new BoardQNA();
				qna.setQnaNo(rs.getInt(1));
				qna.setCategory(rs.getString(2));
				qna.setTitle(rs.getString(3));
				qna.setAnswer(rs.getString(4).charAt(0));
				qna.setMemberName(rs.getString(5));
				qna.setCreateDt(rs.getString("DT"));
				qnaList.add(qna);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return qnaList;
	}

	/**조건에 맞는 Noti/FAQ 목록 조회 
	 * @param conn
	 * @param cNo
	 * @return
	 * @throws Exception
	 */
	public List<Board> searchList(Connection conn, int cNo,int boardNo)throws Exception{
		List<Board> list = new ArrayList<Board>();
		try {
			String sql = prop.getProperty("searchList");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cNo);
			pstmt.setInt(2, boardNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board faq = new Board();
				faq.setBoardNo(rs.getInt(1));
				faq.setCategory(rs.getString(2));
				faq.setTitle(rs.getString(3));
				faq.setContent(rs.getString(4));
				faq.setCreateDate(rs.getString(5));
				list.add(faq);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}


	/**게시글(공지/faq)삽입을 위한 DAO
	 * @param conn
	 * @param board
	 * @param boardType
	 * @return result
	 * @throws Exception
	 */
	public int writeBoard(Connection conn, Board board, int boardType)throws Exception{
		//1.제목 2.내용 3.작성자 4.게시판종류  5.카테고리
		int result = 0;
		
		try {
			String sql = prop.getProperty("writeBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2,board.getContent());
			pstmt.setInt(3, board.getAdminNo());
			pstmt.setInt(4, boardType);
			pstmt.setInt(5, board.getCNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public Board noticeDetail(Connection conn, int i)throws Exception{
		Board notice = null;
		
		try {
			String sql = prop.getProperty("noticeDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				notice = new Board();
				notice.setCategory(rs.getString(1));
				notice.setTitle(rs.getString(2));
				notice.setCreateDate(rs.getString(3));;
				notice.setContent(rs.getString(4));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return notice;
	}



	
	
}
