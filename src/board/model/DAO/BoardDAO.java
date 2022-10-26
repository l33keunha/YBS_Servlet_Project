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
			template.close(rset);
		}
		System.out.println(result);
		return result;
	}
	
	public int insertAttachment(ArrayList<Attachment> fileList){
		
		conn = template.getConnection();
		query = "INSERT INTO TASS.BOARD_IMG VALUES(BNO_SEQ.nextval, ?, ?, ?, ?, ?)";
			
			try {
				for(int i=0; i<fileList.size(); i++) {
					Attachment a = fileList.get(i);
					int count = 0;
					pstmt = conn.prepareStatement(query);
					for(int j=0; j<4; j++) {
						pstmt.setInt(1, a.getImgNo()+count);
						count++;
					}
					pstmt.setString(2, a.getOriginname());
					pstmt.setString(3, a.getRename());
					pstmt.setString(4, a.getImgpath());
					
					result += pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				template.commit(conn);
				template.close(pstmt);
			}
			return result;
	}
}
