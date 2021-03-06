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
		
		//만약 관리자 로그인에 성공하면 자신의 qna리스트 조회해오기
		if(admin != null) {
			admin.setQnaCount(dao.selectCountQna(conn,admin));
		}
		
		close(conn);
		return admin;
	}

	/**입력받은 인증번호 저장
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 */
	public int insertCertification(String inputEmail, String cNumber)throws Exception{
		Connection conn = getConnection();
		
		
		//1) 입력한 이메일과 일치하는 값이 있으면 수정
		int result = dao.updateCertification(conn,inputEmail,cNumber);

		//2) 일치하는 이메일이 없는경우 => 이메일 인증 처음 ==> 삽입
		if(result ==0) {
			result = dao.insertCertification(conn,inputEmail,cNumber);
		}
		
		if(result>0)commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 입력받은 인증번호 검사 Service
	 * @param inputEmail
	 * @param cNumber
	 * @return
	 */
	public int checkNumber(String inputEmail, String cNumber)throws Exception{
		Connection conn = getConnection();
		
		int result = dao.checkNumber(conn, inputEmail, cNumber);
		
		close(conn);
		
		return result;
	}

	
	/** 회원가입을 위한 Service
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public int singUpAdmin(Admin admin)throws Exception{
	Connection conn = getConnection();
		
		int result = dao.signUp(conn,admin);
		
		if(result>0)commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}


}
