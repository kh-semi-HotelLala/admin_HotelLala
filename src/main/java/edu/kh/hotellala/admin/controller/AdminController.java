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
	
		
		String uriPath = req.getRequestURI();
		int point = uriPath.lastIndexOf("/");
		String boardType = uriPath.substring(point);
		
		//공지사항 또는 FAQ 일 때
		if(boardType.equals("signUp")) {
			System.out.println(req.getParameter("email"));
			System.out.println(req.getParameter("password"));
			System.out.println(req.getParameter("passwordConfirm"));
			System.out.println(req.getParameter("tell"));
		}
		
		
		
		String path = "/WEB-INF/views/admin/signUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uriPath = req.getRequestURI();
		int point = uriPath.lastIndexOf("/");
		String boardType = uriPath.substring(point);
		
		//공지사항 또는 FAQ 일 때
		if(boardType.equals("signUp")) {
			System.out.println(req.getParameter("email"));
			System.out.println(req.getParameter("password"));
			System.out.println(req.getParameter("passwordConfirm"));
			System.out.println(req.getParameter("tell"));
		}
	}
}
