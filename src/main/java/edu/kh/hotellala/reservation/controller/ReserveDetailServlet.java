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

@WebServlet("/reservation/listDetail")
public class ReserveDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 1. 파라미터 중 예약번호 얻어오기
			String requestNo = req.getParameter("no");
			
			// 2. 예약 서비스 객체 만들기
			ReserveService service = new ReserveService(); 
			
			// 3-1. 예약정보
			Reservation detail = service.selectReserveDetail(requestNo);
			
			// 3-2. 예약상태
			Reservation status = service.reserveStatus(requestNo);
			
			// 3-3. 결제정보 (옵션)
			Reservation payment = service.reservePayment(requestNo);

			
			// 4. 예약정보 + 결제 정보를 jsp에서 쓸 수 있도록
			req.setAttribute("detail", detail);
			req.setAttribute("status", status);
			req.setAttribute("payment", payment);
			
			String path = "/WEB-INF/views/reservation/listDetail.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}