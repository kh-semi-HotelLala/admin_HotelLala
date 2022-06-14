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
				qna.setAnswer(rs.getString(4));
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


	/**qna 상세 조회 DAO
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
				qna.setAnswer(rs.getString(4));
				qna.setMemberName(rs.getString(5));
				qna.setCreateDt(rs.getString(6));
				qna.setContent(rs.getString(7));
				qna.setMemberTel(rs.getString(8));
				qna.setMemberEmail(rs.getString(9));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return qna;
	}


	
	
}
