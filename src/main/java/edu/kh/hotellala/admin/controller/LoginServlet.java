package edu.kh.hotellala.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인 버튼 클릭시 로그인 검증하고 메인 화면으로 이동시키는 서블릿
@WebServlet("/admin")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String path = "/WEB-INF/views/admin/mainPage.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
