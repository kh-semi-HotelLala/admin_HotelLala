package edu.kh.hotellala.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//로그인 버튼 클릭시 로그인 검증하고 메인 화면으로 이동시키는 서블릿
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
		HttpSession session = req.getSession();
		
		
		int result = 0;
		
		if(result>0){
			session.setAttribute("adminLogin", "임시 로그인값");
			session.setMaxInactiveInterval(3600); 
			
		}else {
			session.setAttribute("message", "정보가 올바르지 않습니다.");
		}
		
		
		String path = req.getContextPath();
		resp.sendRedirect(path);

		}catch(Exception e) {
		
			
			
		}
				
	}
}
