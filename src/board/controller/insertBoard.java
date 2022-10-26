package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.BoardVO;

/**
 * Servlet implementation class insertBoard
 */
@WebServlet("/insertBoard.do")
public class insertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		BoardVO bVO = new BoardVO();
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
			
//		System.out.println(bVO);
//		System.out.println("컨트롤러 : " + bVO.toString());
		
//		BoardService service = new BoardService();
//		int result = service.insertBoard(bVO);	
		
		
		System.out.println("start");
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024*1024*10; // 10Mbyte로 전송파일 용량 제한
			
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "resources/img/contentImg";
			
			System.out.println(savePath);
			
			File f = new File(savePath);
			
			if(!f.exists()) {
				f.mkdirs();
			}
			
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize,"euc-kr");
			
			ArrayList<String> saveFiles = new ArrayList<String>(); //바뀐 파일명 저장
			ArrayList<String> originFiles = new ArrayList<String>(); //원래 파일명 저장
			
			Enumeration<String> files = multi.getFileNames(); //파일 가져오기
			
			while(files.hasMoreElements()) { //Element 있는만큼 
				String name = files.nextElement(); 
				
				if(multi.getFilesystemName(name) != null) { //파일명이 있으면
					saveFiles.add(multi.getFilesystemName(name)); //변경된 파일명 추가
					originFiles.add(multi.getOriginalFileName(name)); //원본 파일명 추가
				}
			}
			
			//서비스에 보내기
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			
			bVO.setTitle(title);
			bVO.setContent(content);
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			for(int i=originFiles.size(); i>=0; i--) { //사진 거꾸로 저장돼서 다시 거꾸로
				Attachment a = new Attachment();
				a.setImgpath(savePath);
				a.setOriginname(originFiles.get(i));
				a.setRename(saveFiles.get(i));
				
				fileList.add(a);			
			}
			
			int result = new BoardService().insertBoard(bVO, fileList);
			if(result > 0) { //성공
				response.sendRedirect("boardList.jsp");
			} else {
				for(int i=0; i<saveFiles.size(); i++) {
					File fail = new File(savePath + saveFiles.get(i));
					fail.delete();
				}
				
				request.setAttribute("msg", "이미지 등록에 실패하였습니다.");			
			}
		}		
		request.getRequestDispatcher("WEB-INF/views/boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
