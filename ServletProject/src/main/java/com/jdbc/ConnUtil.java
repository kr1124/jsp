package com.jdbc;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class ConnUtil {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myOracle");
			con = ds.getConnection();
			
			System.out.println("데이터베이스 연결 성공");
		} catch(Exception se) {
			System.out.println("데이터베이스 연결 실패");
		}
		
		return con;
	}
}
