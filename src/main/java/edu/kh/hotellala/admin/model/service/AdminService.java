package edu.kh.hotellala.admin.model.service;

import edu.kh.hotellala.admin.model.dao.AdminDAO;
import edu.kh.hotellala.admin.model.vo.Admin;
import static edu.kh.hotellala.common.JDBCTemplate.*;

import java.sql.Connection;

public class AdminService {

	AdminDAO dao = new AdminDAO();
	
	/**로그인하기 위한 Service
	 * @param adminEmail
	 * @param adminPw
	 * @return admin
	 * @throws Exception
	 */
	public Admin adminLogin(String adminEmail, String adminPw)throws Exception{
		Connection conn = getConnection();
		
		Admin admin = dao.adminLogin(conn,adminEmail,adminPw);
		
		close(conn);
		
		return admin;
	}

}
