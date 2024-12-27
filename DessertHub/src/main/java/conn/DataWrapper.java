package conn;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DataWrapper {
    private int number;
    private ResultSet rs;

    // 생성자
    public DataWrapper(int number) {
        this.number = number;
    }
    public DataWrapper(int number, ResultSet rs) {
        this.number = number;
        this.rs = rs;
    }

    // Getter와 Setter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void close() {
        if(this.rs != null) {try {this.rs.close();} catch(SQLException e) {}}
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
