package board.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Attachment;
import board.model.vo.BoardVO;
import util.JDBCTemplate;

public class BoardDAO {
	JDBCTemplate template = new JDBCTemplate();
	private static Connection conn = null;
	String query;
	Statement stmt = null;
	ResultSet rset = null;
	PreparedStatement pstmt = null;
	int result = 0;
	
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
	
	public int insertBoard(BoardVO bVO){		
		
		conn = template.getConnection();
		query = "INSERT INTO TASS.BOARD VALUES(BNO_SEQ.nextval, '관리자', ?, ?, SYSDATE, NULL, NULL, 5, 0, 'N', 0, 'Y')";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bVO.getTitle());
			pstmt.setString(2, bVO.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			template.commit(conn);
			template.close(pstmt);
		}
		return result;
	}
	
	public int insertAttachment(ArrayList<Attachment> fileList, int bNo){
		
		conn = template.getConnection();
		query = "INSERT INTO TASS.BOARD_IMG VALUES(?, ?, ?, ?, ?, 'N')";
		int cnt = 1;
			
			try {
				for(int i=0; i<fileList.size(); i++) {
					Attachment a = fileList.get(i);
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, bNo);
					pstmt.setInt(2, cnt++);
					pstmt.setString(3, a.getOriginname());
					pstmt.setString(4, a.getRename());
					pstmt.setString(5, a.getImgpath());
					
					result = pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				template.commit(conn);
				template.close(pstmt);
			}
			return result;
	}

	public int selectBno() {
		conn = template.getConnection();
		query = "SELECT BNO FROM BORAD WHERE ROWNUM=1 ORDER BY DESC";
		
		try {
			pstmt = conn.prepareStatement(query);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			template.commit(conn);
			template.close(pstmt);
		}
	
		return result;		
	}
}
