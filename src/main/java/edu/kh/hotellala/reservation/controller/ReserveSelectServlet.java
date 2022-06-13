package edu.kh.hotellala.reservation.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.hotellala.reservation.model.service.ReserveService;


@WebServlet("/reservation/list")
public class ReserveSelectServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			ReserveService service = new ReserveService();
			
			// 페이지네이션 객체, 게시글 리스트
			Map<String, Object> map = service.selectReserveList(cp);
			
			
			String path = "/WEB-INF/views/reservation/list.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
