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
	
    public static DataWrapper sql_execute(String func_name, String sql_type, String sql_part1, String sql_part2, String[] plist) {        
		Connection con = null;
		PreparedStatement pstmt = null;
        
        DataWrapper dw = null;
        int result = 1;
		ResultSet rs = null;

        String sql = sql_type + sql_part1 + db_name + sql_part2;

		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql);
            for(int i = 0; i < plist.length; i++) {
			    pstmt.setString(i + 1, plist[i]);
            }
			
            if(sql_type == select) {
			    rs = pstmt.executeQuery();

                if(!rs.next()) {
                    result = 0;
                }
                dw = new DataSource(result, rs);
            } else {
			    result = pstmt.executeUpdate();
                dw = new DataSource(result);
            }
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			//if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return dw;
    }
}
