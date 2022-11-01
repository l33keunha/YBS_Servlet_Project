package board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

/**
 * Servlet implementation class selectBoardDetail
 */
@WebServlet("/selectBoardDetail.do")
public class selectBoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectBoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		
		System.out.println(request.getParameter("bNo"));
		
//		int bNo = Integer.parseInt(request.getParameter("bNo"));
		int bNo = 371;

		Map<String, Object> map = service.selectBoardDetail(bNo);
		
		System.out.println(map.get("aList"));
		System.out.println(map.get("bVO"));
		
//		request.setAttribute("aList", map.get("aList"));
//		request.setAttribute("bVO", map.get("bVO"));		
		
//		request.getRequestDispatcher("WEB-INF/views/boardDetail.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
