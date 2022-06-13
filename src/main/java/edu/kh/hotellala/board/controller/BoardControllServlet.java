package edu.kh.hotellala.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.hotellala.board.model.service.BoardService;
import edu.kh.hotellala.board.model.vo.BoardQNA;

@WebServlet("/board/*")
public class BoardControllServlet extends HttpServlet {

	BoardService service = new BoardService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getRequestURI();
		System.out.println("path:"+path);
		int point = path.lastIndexOf("/");
		String boardType = path.substring(point);
		
		
		try {
			// 들어온 요청이 공지사항 또는 FAQ 일 때
			if (boardType.equals("notice") || boardType.equals("faq")) {

			}

			// 들어온 요청이 Q&A일 경우
			if (boardType.equals("/qna")) {
			

			}

			String folderPath = "/WEB-INF/views/board" + boardType + ".jsp";
			req.getRequestDispatcher(folderPath).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void qnaBoard(HttpServletRequest req)throws Exception{
		
		// 게시글번호 파라미터가 없을 경우 그냥 전체 조회인 경우라 그냥 모든 리스트 가져와서
		// res에 setAttribute해줌.36
		if (req.getQueryString() == null) {
			List<BoardQNA> qnaList = service.selectQnaList();
			req.setAttribute("qnaList", qnaList);
		} else{
			
		}
	}
	
	
}