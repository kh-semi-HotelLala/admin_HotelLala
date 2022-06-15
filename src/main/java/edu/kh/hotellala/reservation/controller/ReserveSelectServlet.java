package edu.kh.hotellala.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.hotellala.reservation.model.service.ReserveService;
import edu.kh.hotellala.reservation.model.vo.Reservation;


@WebServlet("/reservation/list")
public class ReserveSelectServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			ReserveService service = new ReserveService();	

			List<Reservation> reserveList = null;
			
		 	// 일반 예약목록 조회
			if(req.getParameter("select") == null) {
				
				reserveList = service.selectReserveAll();
			
			} else { // 검색 예약목록 조회
				
				String select = req.getParameter("select");
				String query = req.getParameter("query");
				
				reserveList = service.searchReserveList(select, query);
				
			}
			
			req.setAttribute("reserveList", reserveList);

			
			String path = "/WEB-INF/views/reservation/list.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
