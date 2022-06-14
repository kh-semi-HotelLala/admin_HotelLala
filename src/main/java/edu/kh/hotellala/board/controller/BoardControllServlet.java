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
import edu.kh.hotellala.board.model.vo.Board;
import edu.kh.hotellala.board.model.vo.BoardQNA;

/**
 * @author deadWhale
 *
 */
@WebServlet("/board/*")
public class BoardControllServlet extends HttpServlet {

	BoardService service = new BoardService();
	
	/**작성의 경우 요청
	 *
	 */
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		}
	
	
	/**모든 경우의 조회
	 *
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getRequestURI();
		int point = path.lastIndexOf("/"); 
		String boardType = path.substring(point);
		
		
		try {
			// 들어온 요청이 공지사항 일때
			if (boardType.equals("notice")) {

			}
			
			// 들어온 요청이 FAQ 일때
			if (boardType.equals("faq")) {
				faqBoard(req,resp);
			}


			// 들어온 요청이 Q&A일 경우
			if (boardType.equals("/qna")) {
				qnaBoard(req,resp);
			}

			String folderPath = "/WEB-INF/views/board" + boardType + ".jsp";
			req.getRequestDispatcher(folderPath).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**FAQ 게시판의 경우 수행 함수
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	private void faqBoard(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		
		if (req.getQueryString() == null) {
			List<Board> faqList = service.selectFaqList();
			req.setAttribute("faqList", faqList);
		}else {
			
		}
		
	}

	/**QNA 게시판의 경우 수행 함수
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	public void qnaBoard(HttpServletRequest req,HttpServletResponse resp)throws Exception{
		
		// 게시글번호 파라미터가 없을 경우 그냥 전체 조회인 경우라 그냥 모든 리스트 가져와서
		// res에 setAttribute해줌.36
		if (req.getQueryString() == null) {
			List<BoardQNA> qnaList = service.selectQnaList();
			req.setAttribute("qnaList", qnaList);
		} else{
			
		}
	}
	
	// notice 게시판의 경우 수행 함수
	public void noticeBoard(HttpServletRequest req,HttpServletResponse resp)throws Exception{}
	
}