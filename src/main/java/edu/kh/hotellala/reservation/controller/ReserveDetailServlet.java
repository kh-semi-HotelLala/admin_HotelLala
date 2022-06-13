package edu.kh.hotellala.reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.hotellala.reservation.model.service.ReserveService;

@WebServlet("/reservation/listDetail")
public class ReserveDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 1. 파라미터 중 예약번호 얻어오기
			int reservationNo = Integer.parseInt(req.getParameter("no"));
			
			// 2. 예약 서비스 객체 만들기
			ReserveService service = new ReserveService(); 
			
			// 3. 예약정보 + 결제 정보 조회
//			ListDetail detail = service.selectReserveDetail(reservationNo);
			
			// 4. 예약정보 + 결제 정보를 jsp에서 쓸 수 있도록
			
			
			String path = "/WEB-INF/views/reservation/listDetail.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}