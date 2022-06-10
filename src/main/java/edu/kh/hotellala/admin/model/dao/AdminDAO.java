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
			
			System.out.println("sqp:"+sql);
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

}
