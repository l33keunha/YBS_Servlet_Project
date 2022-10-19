package board.model.DAO;

import java.io.Closeable;
import java.sql.Connection;
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

}
