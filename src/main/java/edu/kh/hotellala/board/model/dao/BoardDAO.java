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
				
				qnaList.add(qna);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		return qnaList;
	}

}
