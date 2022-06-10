package edu.kh.hotellala.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardControlServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String path = req.getRequestURI();
		int dash = path.lastIndexOf("/");
		String temp = path.substring(dash)+".jsp";
		
		String folderPath = "/WEB-INF/views/board"+temp;
		req.getRequestDispatcher(folderPath).forward(req, resp);
	}
	
}
