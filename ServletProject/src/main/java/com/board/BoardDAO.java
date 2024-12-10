package com.board;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;


public class BoardDAO {
	private static BoardDAO instance = null;
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			synchronized(BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		
		return instance;
	}
	
	//데이터베이스에 데이터 추가
	public void insertArticle(BoardVO article) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		
		int number = 0;
		String sql = "";
		
		try {
			con = ConnUtil.getConnection();
			pstmt =  con.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				number = rs.getInt(1);
			} else {
				number = 1;
			}
			
			if(number != 0) {//답글일 경우
				sql = "update board set step=step+1 where ref=? and step > ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				pstmt.executeUpdate();
				step++;
				depth++;
				
			} else {//새글일 경우
				ref = number;
				step = 0;
				depth = 0;
			}
			//데이터 추가하는 쿼리문
			sql = "insert into board(num, writer, email, subject, pass, ref, step, depth, regdate, content, ip) "
					+ "values(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPass());
			//pstmt.setInt(5, 0);
			pstmt.setInt(5, ref);
			pstmt.setInt(6, step);
			pstmt.setInt(7, depth);
			pstmt.setTimestamp(8, article.getRegdate());
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
	}
	
	// 글 목록 화면 작성
	// 전체 글의 갯수를 가져올 메소드 구현
	public int getArticleCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		
		try {
			con = ConnUtil.getConnection();
			String sql = "select count(*) from board";
			pstmt =  con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return x;
	}
	
	public List<BoardVO> getArticles() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> articleList = null;
		
		try {
			con = ConnUtil.getConnection();
			String sql = "select * from board order by num desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList<BoardVO>();
				do {
					BoardVO article = new BoardVO();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					
					articleList.add(article);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {try {rs.close();} catch(SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch(SQLException e) {}}
			if(con != null) {try {con.close();} catch(SQLException e) {}}
		}
		
		return articleList;
	}
}
