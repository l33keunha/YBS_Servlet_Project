package board.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	public Map<String, Object> selectBoardList() {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<BoardVO> bList = new ArrayList<BoardVO>();
		ArrayList<Attachment> aList = new ArrayList<Attachment>();
		
		BoardVO bVO = new BoardVO();
		Attachment aVO = new Attachment();
		conn = template.getConnection();
		query = "SELECT A.BNO, A.TITLE, A.CONTENT, A.WRITTEN_DATE, A.MAIN_STATUS, B.IMG_PATH, B.THUMBNAIIL_STATUS, B.RE_NAME \r\n"
				+ "FROM board A,\r\n"
				+ "BOARD_IMG B\r\n"
				+ "WHERE 1=1\r\n"
				+ "AND A.BNO = B.BNO(+)\r\n"
				+ "AND B.THUMBNAIIL_STATUS ='Y' OR B.THUMBNAIIL_STATUS IS NULL\r\n"
				+ "ORDER BY A.BNO DESC";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				bVO = new BoardVO();
				bVO.setbNo(rset.getInt("BNO"));
				bVO.setTitle(rset.getString("TITLE"));
				bVO.setContent(rset.getString("CONTENT"));
				bVO.setWrittenDate(rset.getDate("WRITTEN_DATE"));
				bVO.setMainStatus(rset.getString("MAIN_STATUS"));
				
				aVO = new Attachment();
				aVO.setbNo(rset.getInt("BNO"));
				aVO.setRename(rset.getString("RE_NAME"));
				aVO.setImgpath(rset.getString("IMG_PATH"));
				aVO.setThumbnailstatus(rset.getString("THUMBNAIIL_STATUS"));
				
				bList.add(bVO);
				aList.add(aVO);
			
			}
			
			map.put("bList", bList);
			map.put("aList", aList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			template.close(stmt);
			template.close(rset);
		}
		
		return map;
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
		query = "INSERT INTO TASS.BOARD_IMG VALUES(?, ?, ?, ?, ?, ?)";
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
					pstmt.setString(6, a.getThumbnailstatus());
					
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
		query = "SELECT BNO FROM BOARD WHERE ROWNUM=1 ORDER BY BNO DESC";
		
		try {
			stmt = conn.createStatement();
			//파라미터 받을게 없을때, 쿼리 select만 하면 executeQuery
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				result = rset.getInt("bNo");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			template.commit(conn);
			template.close(stmt);
		}
		
		return result;		
	}
	
	public int increaseCnt(int bNo) {
		
		conn = template.getConnection();
		query = "UPDATE BOARD SET CNT=CNT+1 WHERE BNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			template.commit(conn);
			template.close(pstmt);
		}
		return result;
	}
	
	public BoardVO selectBoardDetail(int bNo) {
		BoardVO bVO = new BoardVO();
		
		conn = template.getConnection();
		
		query = "SELECT *\r\n"
				+ "FROM BOARD \r\n"
				+ "WHERE 1=1\r\n"
				+ "AND BNO = ?";
  			
			try {
				
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bNo);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					bVO = new BoardVO();
					bVO.setbNo(rset.getInt("BNO"));
					bVO.setName(rset.getString("NAME"));
					bVO.setTitle(rset.getString("TITLE"));
					bVO.setContent(rset.getString("CONTENT"));
					bVO.setWrittenDate(rset.getDate("WRITTEN_DATE"));
					bVO.setUpdateDate(rset.getDate("UPDATE_DATE"));
					bVO.setDeleteDate(rset.getDate("DELETE_DATE"));
					bVO.setCateNo(rset.getInt("CATE_NO"));
					bVO.setCnt(rset.getInt("CNT"));
					bVO.setMainStatus(rset.getString("MAIN_STATUS"));
					bVO.setLikeCnt(rset.getInt("LIKE_CNT"));
					bVO.setStatus(rset.getString("STATUS"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				template.close(pstmt);
				template.close(rset);
			}

		return bVO;
	}

	public ArrayList<Attachment> selectImageDetail(int bNo) {
		ArrayList<Attachment> aList = new ArrayList<Attachment>();
		Attachment aVO = new Attachment();
		
		conn = template.getConnection();
		query = "SELECT * \r\n"
				+ "FROM BOARD_IMG \r\n"
				+ "WHERE 1=1\r\n"
				+ "AND BNO = ? "
				+ "ORDER BY IMGNO";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
										
			while(rset.next()) {	
				aVO = new Attachment();	
				aVO.setbNo(rset.getInt("BNO"));
				aVO.setImgNo(rset.getInt("IMGNO"));
				aVO.setOriginname(rset.getString("ORIGIN_NAME"));
				aVO.setRename(rset.getString("RE_NAME"));
				aVO.setImgpath(rset.getString("IMG_PATH"));
				aVO.setThumbnailstatus(rset.getString("THUMBNAIIL_STATUS"));
				
				aList.add(aVO);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			template.close(pstmt);
			template.close(rset);
		}
		return aList;
	}
	
}
