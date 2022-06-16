package edu.kh.hotellala.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.hotellala.reservation.model.service.ReserveService;


@WebServlet("/room/selectInfo")
public class RoomModalServlet extends HttpServlet {

	// /modal/selectRoomList (POST)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			ReserveService service = new ReserveService();
			
//			req.getParameter(memberNo);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
