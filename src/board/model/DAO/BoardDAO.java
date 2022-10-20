package board.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.BoardVO;
import util.JDBCTemplate;

public class BoardDAO {
	JDBCTemplate template = new JDBCTemplate();
	private static Connection conn = null;
	String query;
	Statement stmt = null;
	ResultSet rset = null;
	PreparedStatement pstmt = null;
	
	public ArrayList<BoardVO> selectBoardList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo = new BoardVO();
		
		conn = template.getConnection();
		query = "SELECT TITLE, CONTENT FROM BOARD";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				vo = new BoardVO();
				vo.setTitle(rset.getString("TITLE"));
				vo.setContent(rset.getString("CONTENT"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			template.close(stmt);
			template.close(rset);
		}
		
		return list;
	}
	
//	public ArrayList<BoardVO> insertBoard(){
//		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		BoardVO vo = new BoardVO();
//		
//		conn = template.getConnection();
//		query = "INSERT INTO BOARD VALUES (BNO_SEQ.nextval, ?, ?, ?, SYSDATE, NULL, NULL, 5, 0, 'N', 0, 'Y')";
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			
//			//pstmt.setInt(1, )
//			
//			
//			
//			
//			
//			
//			pstmt.executeUpdate();
//			
//			
//			
//			System.out.println("--------------------INSERT 성공");
//			
//		} catch (SQLException e) {		
//			e.printStackTrace();
//		} finally {
//			template.close(pstmt);
//		}
//	}
}
