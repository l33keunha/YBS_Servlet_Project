package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	public static Connection conn = null;
	
	public Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.51:1521:ORCL", "tass", "TASS123");
			
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// JDBCTemplate ----------------------------
			public void close(ResultSet rset) {
				try {
					if(rset != null && !rset.isClosed()) {
						rset.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			public void close(PreparedStatement pstmt) {
				try {
					if(pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public void close(Statement stmt) {
				try {
					if(stmt != null && !stmt.isClosed()) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public void commit(Connection conn) {
				try {
					if(conn != null && !conn.isClosed()) {
						conn.commit();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			public void rollback(Connection conn) {
				try {
					if(conn != null && !conn.isClosed()) {
						conn.rollback();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
}
