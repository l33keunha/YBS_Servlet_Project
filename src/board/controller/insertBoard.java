package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.BoardVO;
import util.MyFileRenamePolicy;

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
		
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024*1024*10; // 10Mbyte로 전송파일 용량 제한
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "resources/img/contentImg";
			
			
			
			File f = new File(savePath);
			
			if(!f.exists()) {
				f.mkdirs();
			}
			
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize,"utf-8",new MyFileRenamePolicy());
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
			
			BoardVO bVO = new BoardVO();
			bVO.setTitle(title);
			bVO.setContent(content);
		
			
			String [] arr = {multi.getParameter("status4"), multi.getParameter("status3")
										,multi.getParameter("status2"),multi.getParameter("status1")
										};
			System.out.println(Arrays.toString(arr));
			arr = Arrays.stream(arr)   // 배열을 순회
	                .filter(s -> !s.equals("N")) // 요소들을 조건에 따라 걸러내는 작업
	                .toArray(String[]::new);
			System.out.println(Arrays.toString(arr));
			int num = Arrays.asList(arr).indexOf("Y");
			System.out.println(num);;
			
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			for(int i=originFiles.size()-1; i>=0; i--) { //사진 거꾸로 저장돼서 다시 거꾸로
				Attachment a = new Attachment();
				a.setImgpath(savePath);
				a.setOriginname(originFiles.get(i));
				a.setRename(saveFiles.get(i));
				a.setThumbnailstatus("N");
				if(num == i) {
					a.setThumbnailstatus("Y");
				}
				
				fileList.add(a);			
				
				System.out.println(i +"번째: " + a.toString());
			}
			
			int result = new BoardService().insertBoard(bVO, fileList);
			
			if(result > 0) { //성공
				response.sendRedirect("selectBoardList.do");
			} 	
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
