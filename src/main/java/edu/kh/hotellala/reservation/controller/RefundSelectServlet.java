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


@WebServlet("/reservation/refund")
public class RefundSelectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			ReserveService service = new ReserveService();
			
			List<Reservation> refundList = null;
			
			// 일반목록
			if(req.getParameter("select") == null) {
				
				refundList = service.selectRufundAll();
				
			} else {// 검색목록
				
				
				
			}
			
			
			
			
			
			
			String path = "/WEB-INF/views/reservation/refund.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
