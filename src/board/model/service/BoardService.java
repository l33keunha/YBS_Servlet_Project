package board.model.service;

import java.util.ArrayList;

import board.model.DAO.BoardDAO;
import board.model.vo.BoardVO;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	
	public ArrayList<BoardVO> selectBoardList() {
		ArrayList<BoardVO> list = dao.selectBoardList();
		
		return list;
	}
	
	public int insertBoard(BoardVO bVO){

		return dao.insertBoard(bVO);
	}

}
