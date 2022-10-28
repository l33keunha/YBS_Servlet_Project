package board.model.service;

import java.util.ArrayList;
import java.util.Map;

import board.model.DAO.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.BoardVO;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	public Map<String, Object> selectBoardList() {
		return dao.selectBoardList();
	}
	
	public int insertBoard(BoardVO bVO, ArrayList<Attachment> fileList){
	
		int result = dao.insertBoard(bVO); 
		
		if(result > 0) {
			int bNo = dao.selectBno();
			result = dao.insertAttachment(fileList, bNo);
			if(result > 0) {
				return result; // 1
			} else { // 사진게시판 insert 실패 : 0
				return result;
			}
		} else { // 일반게시판 insert 실패 : 0
			return result;
		}
	}
	
}
