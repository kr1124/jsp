package com.mvcmem.model;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.Vector;

public class StudentDAO {
	private static StudentDAO instance = null;
	
	public StudentDAO() {}

	public static StudentDAO getInstance() {
		if(instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		
		return instance;
	}
	
	private Connection getConnection() {
		Connection con = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myOracle");
			con = ds.getConnection();
			
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
		
		return con;
	}
	
	//여기서부터 메소드를 하나씩 추가하여 구현하면 됨
	
	//idCheck
	public boolean idCheck(String id) {
		boolean result = true;
		String sql = "select * from student where id=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				result = false;
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return result;
	}//end idCheck

	public Vector<ZipCodeVO> zipcodeRead(String dong) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
		
		try {
			con = getConnection();
			
			String sql = "select * from zipcode where dong like '" + dong + "%'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ZipCodeVO tempZipCode = new ZipCodeVO();
				tempZipCode.setZipcode(rs.getString("zipcode"));
				tempZipCode.setSido(rs.getString("sido"));
				tempZipCode.setGugun(rs.getString("gugun"));
				tempZipCode.setDong(rs.getString("dong"));
				tempZipCode.setRi(rs.getString("ri"));
				tempZipCode.setBunji(rs.getString("bunji"));
				vecList.add(tempZipCode);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return vecList;
	}//end zipcodeRead
	
}
