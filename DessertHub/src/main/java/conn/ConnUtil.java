package conn;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class ConnUtil {
	private static DataSource ds;

	static {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myOracle");
			
			System.out.println("데이터베이스 연결 성공");
		} catch(NamingException ne) {
			System.out.println("커넥션 생성 실패");
			ne.printStackTrace();
		} catch(SQLException se) {
			System.out.println("커넥션 생성 실패");
			se.printStackTrace();
		} catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
