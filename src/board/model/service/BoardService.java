package board.model.service;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	public Map<String, Object> selectBoardDetail(int bNo) {
		BoardVO bVO = new BoardVO();
		ArrayList<Attachment> aList = new ArrayList<Attachment>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int result = dao.increaseCnt(bNo); // 1. 조회수 update
		
		if(result > 0) {
			bVO = dao.selectBoardDetail(bNo); // 2. 조회수 업데이트가 성공했다면 board 가져오기
			if(bVO != null) {
				aList = dao.selectImageDetail(bNo); // 3. board가 존재한다면 사진list 가져오기
				if(aList.size() < 0) {
					
				}
			} 
		}
		
		map.put("bVO", bVO);
		map.put("aList", aList);
		
		return map;
	}
	
}
