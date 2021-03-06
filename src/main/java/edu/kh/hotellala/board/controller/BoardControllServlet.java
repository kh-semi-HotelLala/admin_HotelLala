package edu.kh.hotellala.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.hotellala.admin.model.vo.Admin;
import edu.kh.hotellala.board.model.service.BoardService;
import edu.kh.hotellala.board.model.vo.Board;
import edu.kh.hotellala.board.model.vo.BoardQNA;
import edu.kh.hotellala.common.Util;

/**
 * @author deadWhale
 *
 */
@WebServlet("/board/*")
public class BoardControllServlet extends HttpServlet {

	BoardService service = new BoardService();

	/**
	 * 작성의 경우 요청
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * 모든 조회
	 *
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getRequestURI();
		int point = path.lastIndexOf("/");
		String boardType = path.substring(point);
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			// 들어온 요청이 공지사항 일때
			if (boardType.equals("/notice")) {				map = noticeBoard(req);			}
			// 들어온 요청이 FAQ 일때
			if (boardType.equals("/faq")) {				map = faqBoard(req);			}
			// 들어온 요청이 Q&A일 경우
			if (boardType.equals("/qna")) {				map = qnaBoard(req);			}
			// 게시글 작성
			if (boardType.equals("/write")) {				map = write(req);			}

			if ((boolean) map.get("bol")) {
				// 요청 위임해야 하는 경우 Map에 담긴 주소로 forward된다
				String folderPath = "/WEB-INF/views/board" + (String) map.get("path");
				req.getRequestDispatcher(folderPath).forward(req, resp);

			} else {
				// Redirect가 필요할 경우
				resp.sendRedirect((String) map.get("path"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * FAQ 게시판의 경우 수행 함수
	 * 
	 * @param req
	 * @throws Exception
	 */
	private Map<String, Object> faqBoard(HttpServletRequest req) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		if (req.getQueryString() == null && req.getMethod().equals("GET")) {

			List<Board> faqList = service.selectFaqList();
			req.setAttribute("faqList", faqList);

			map.put("path", "/faq.jsp");
			map.put("bol", true);
		} else {
			String type = req.getParameter("type");

			switch (type) {
			case "search":

				List<Board> faqList = service.searchList(req.getParameter("key"), 2);
				req.setAttribute("faqList", faqList);

				map.put("path", "/faq.jsp");
				map.put("bol", true);
				break;
			case "reservation":
				break;

			}
		}
		return map;
	}

	/**
	 * QNA 게시판의 경우 수행 함수
	 * 
	 * @param req
	 * @throws Exception
	 */
	public Map<String, Object> qnaBoard(HttpServletRequest req) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("adminLogin");
		int no = 0;
		// 게시글번호 파라미터가 없을 경우 그냥 전체 조회인 경우라 그냥 모든 리스트 가져와서
		// res에 setAttribute해줌.

		if (req.getQueryString() == null && req.getMethod().equals("GET")) {
			List<BoardQNA> qnaList = service.selectQnaList();
			req.setAttribute("qnaList", qnaList);
			map.put("path", "/qna.jsp");
			map.put("bol", true); // forward의 경우 true
		} else {
			// 아닌 경우 파라미터에서 어느 수행 요청인지 type을 가져와 확인한다.
			String type = req.getParameter("type");

			switch (type) {
			// forward인지 redirect인지 구분한 boolean값
			// 둘 모두 가야될 위치를 저장한 변수 path를
			// hash Map에 저장에 doGet 메서드에서 사용한다.
			case "search":
				// ?type=search&answer=Y&category=1
				char answer = req.getParameter("answer").charAt(0);
				int category = Integer.parseInt(req.getParameter("category"));
				List<BoardQNA> qnaList = service.searchQnaList(answer, category);
				req.setAttribute("qnaList", qnaList);
				map.put("path", "/qna.jsp");
				map.put("bol", true); // forward의 경우 true
				break;
			// 상세조회의 경우.조회한 게시글의 상세 주소를 가지고
			case "detail":
				no = Integer.parseInt(req.getParameter("no")); // 문의글 번호
				BoardQNA qna = service.selectQnaDetail(no);
				req.setAttribute("qna", qna);
				map.put("path", "/qnaDetail.jsp");
				map.put("bol", true);
				break;
			case "insertAnswer":
				no = Integer.parseInt(req.getParameter("no")); // 문의글 번호
				int result = service.insertAnswer(no, admin.getAdminNo(), req.getParameter("inputAnswer"));
				if (result > 0) {
					session.setAttribute("message", "답변이 작성되었습니다.");
					admin.setQnaCount(admin.getQnaCount() - 1);
				}
				map.put("path", "qna");
				map.put("bol", false); // redirect의 경우 false
				break;
			}
		}
		return map;
	}

	// notice 게시판의 경우 수행 함수
	public Map<String, Object> noticeBoard(HttpServletRequest req) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = req.getSession();
		
		if (req.getQueryString() == null) {
			List<Board> noticeList = service.selectNoticeList();
			req.setAttribute("noticeList", noticeList);
			map.put("path", "/notice.jsp");
			map.put("bol", true); // forward의 경우 true
		} else {
			String type = req.getParameter("type");
			switch (type) {
			case "search":
				List<Board> noticeList = service.searchList(req.getParameter("key"), 1);
				req.setAttribute("noticeList", noticeList);
				map.put("path", "/notice.jsp");
				map.put("bol", true);
				break;
			case "detail":
				Board notice = service.noticeDetail(Integer.parseInt(req.getParameter("no")));
				req.setAttribute("notice", notice);
				map.put("path", "/noticeDetail.jsp");
				map.put("bol", true);
				break;
				//type=delete&no=53
			case "delete" :
				String message = service.deleteBoard(Integer.parseInt(req.getParameter("no")));
				session.setAttribute("message", message);
				map.put("path", "notice");
				map.put("bol", false);
				break;

			}
		}

		return map;
	}

	/**
	 * notice + faq 작성경우 수행 함수
	 * 
	 * @param req
	 * @return map
	 * @throws Exception
	 */
	private Map<String, Object> write(HttpServletRequest req) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = req.getSession();

		if (req.getQueryString() == null && req.getMethod().equals("GET")) {
			map.put("path", "/write.jsp");
			map.put("bol", true);
		} else { // 게시글 작성 후에 post방식으로 전달
			Board board = new Board();
			int boardType = Integer.parseInt(req.getParameter("boardType"));
			board.setCNo(Integer.parseInt(req.getParameter("category")));
			board.setTitle(req.getParameter("title"));
			board.setContent(req.getParameter("editordata"));
			board.setAdminNo(Integer.parseInt(req.getParameter("adminNo")));
			System.out.println(board);
			// 결과 반환 후 작성한 게시판으로 이동 작성한 게시판을 service에서 가공해서 반환함
			String path = service.writeBoard(board, boardType);
			System.out.println(path);
			if (path != null) {
				session.setAttribute("message", "게시글이 작성되었습니다.");
			} else {
				session.setAttribute("message", "게시글 작성이 실패했습니다.");
			}
			map.put("path", path);
			map.put("bol", false);
		}

		return map;
	}

}