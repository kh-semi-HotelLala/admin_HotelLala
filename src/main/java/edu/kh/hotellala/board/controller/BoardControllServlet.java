package edu.kh.hotellala.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardControllServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String path = req.getRequestURI();
		int point = path.lastIndexOf("/");
		String boardType = path.substring(point)+".jsp";
		
		//공지사항 또는 FAQ 일 때
		if(boardType.equals("notice")||boardType.equals("faq")) {
			
		}
		
		//들어온 요청이 Q&A일 경우
		if(boardType.equals("qna")) {
			
		}
		
		
		
		String folderPath = "/WEB-INF/views/board"+boardType;
		req.getRequestDispatcher(folderPath).forward(req, resp);
	}
	
}
