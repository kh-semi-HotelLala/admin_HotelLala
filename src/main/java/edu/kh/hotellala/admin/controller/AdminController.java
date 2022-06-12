package edu.kh.hotellala.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
		String uriPath = req.getRequestURI();
		int point = uriPath.lastIndexOf("/");
		String Type = uriPath.substring(point);
		String path ="";
		
		//단순 페이지 이동의 경우
		if(Type.equals("/signUp")) { 
			path = "/WEB-INF/views/admin/signUp.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		}

		if(Type.equals("/sendEmail")) {
			int result = sendEmail(req.getParameter("email"));
			resp.getWriter().print(result);
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		     // ajax error 속성 활용을 위한 500에러를 응답으로 전달.
	         resp.setStatus(500);
	         resp.getWriter().print(e.getMessage());
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI();
		int point = uriPath.lastIndexOf("/");
		String boardType = uriPath.substring(point);
		
		//공지사항 또는 FAQ 일 때
		System.out.println(boardType);
		if(boardType.equals("/signUp")) {
			System.out.println(req.getParameter("email"));
			System.out.println(req.getParameter("password"));
			System.out.println(req.getParameter("tell"));
		}
	}
	
	
	
	private int sendEmail(String email){
		
		int result = 0;
		return result;
	}
}
