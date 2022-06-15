package edu.kh.hotellala.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.kh.hotellala.reservation.model.service.ReserveService;
import edu.kh.hotellala.reservation.model.vo.Reservation;


@WebServlet("/reservation/room")
public class RoomServelt extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// DB에서 roomNo 가져오기?
			// 층 수 -> type을 vs에서 이클립스로 얻어와야함.
			// 과정 다시 적어보기
			// room jsp 에서 층 수를 클릭했을 때 roomNo를 이용해 조회 하려 한다.
//			 이때 room.js에서 ajax로 값 받아오고 data를 넘기고
			ReserveService service = new ReserveService();
			
			String roomType = "SINGLE";
			
			List<Reservation> room = service.selectFloor(roomType);
			
			
			req.setAttribute("room", room);
			
			
			String path = "/WEB-INF/views/reservation/room.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
					
			ReserveService service = new ReserveService();
			
			String roomType = req.getParameter("floor");
			
			List<Reservation> room = service.selectFloor(roomType);
			
			
			req.setAttribute("room", room);
			
			//new Gson().toJson(room, resp.getWriter());
			new GsonBuilder().setDateFormat("yy.MM.dd").create().toJson(room, resp.getWriter());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
}