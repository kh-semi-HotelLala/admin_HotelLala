package edu.kh.hotellala.admin.model.dao;
import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import edu.kh.hotellala.admin.model.vo.Admin;


public class AdminDAO {

	PreparedStatement pstmt;
	ResultSet rs;
	
	private Properties prop;
	
	//admin-sql에서 xml문서 읽어오기
	public AdminDAO(){
		try {
			prop = new Properties();
			String filePath = AdminDAO.class.getResource("/edu/kh/hotellala/sql/admin-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**로그인하기 위해 DAO
	 * @param conn
	 * @param adminEmail
	 * @param adminPw
	 * @return admin
	 * @throws Exception
	 */
	public Admin adminLogin(Connection conn, String adminEmail, String adminPw)throws Exception{
		Admin admin = null;
		
		try {
			String sql = prop.getProperty("adminLogin");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adminEmail);
			pstmt.setString(2, adminPw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				admin = new Admin();
				admin.setAdminNo(rs.getInt("ADMIN_NO"));
				admin.setAdminName(rs.getString("ADMIN_NM"));
				admin.setAdminTel(rs.getString("ADMIN_TEL"));
				admin.setAdminEmail(rs.getString("ADMIN_EMAIL"));
			}	
		}finally {
			close(rs);
			close(pstmt);
		}
		return admin;
	}

	
	//----------------------------------------------------------------------
	//----------------------------------------------------------------------
	//이메일 인증 번호 
	
	   /** 인증번호 생성 DAO
	    * @param conn
	    * @param inputEmail
	    * @param cNumber
	    * @return result
	    * @throws Exception
	    */
	   public int insertCertification(Connection conn, String inputEmail, String cNumber) throws Exception {
	      int result = 0;
	      
	      try {
	         String sql = prop.getProperty("insertCertification");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, inputEmail);
	         pstmt.setString(2, cNumber);
	         
	         result = pstmt.executeUpdate();
	         
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	   /** 인증번호, 발급일 수정 DAO
	    * @param conn
	    * @param inputEmail
	    * @param cNumber
	    * @return result
	    * @throws Exception
	    */
	   public int updateCertification(Connection conn, String inputEmail, String cNumber) throws Exception {
	      int result = 0;
	      
	      try {
	         String sql = prop.getProperty("updateCertification");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, cNumber);
	         pstmt.setString(2, inputEmail);
	         
	         result = pstmt.executeUpdate();
	         
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	   /** 인증번호 확인 DAO
	    * @param conn
	    * @param inputEmail
	    * @param cNumber
	    * @return result
	    * @throws Exception
	    */
	   public int checkNumber(Connection conn, String inputEmail, String cNumber) throws Exception{
	      int result = 0;
	      
	      try {
	         
	         String sql = prop.getProperty("checkNumber");
	         
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, inputEmail);
	         pstmt.setString(2, cNumber);
	         pstmt.setString(3, inputEmail);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            result = rs.getInt(1);
	         }
	         
	         
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

}
