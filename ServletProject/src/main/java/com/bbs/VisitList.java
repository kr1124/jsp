package com.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitList")
public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter(); 

		try {
			out.println("<html>");
			out.println("<head><title>방명록 리스트</title></head>");

			out.println("<body>");
			String sql = "select no, writer, memo, regdate from visit order by no desc";
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				out.println("<table align=center width=500 border=1>");
				while(rs.next()) {
					int no = rs.getInt("no");
					String writer = rs.getString("writer");
					String memo = rs.getString("memo");
					Date regdate = rs.getDate("regdate");
					
					out.println("<tr>");
					out.println("<th width=50>번호</th>");
					out.println("<td width=50 align=center>" + no + "</td>");
					out.println("<th width=70>작성자</th>");
					out.println("<td width=180 align=center>" + writer + "</td>");
					out.println("<th width=50>날짜</th>");
					out.println("<td width=100 align=center>" + regdate + "</td>");
					out.println("</tr>");					

					out.println("<tr>");
					out.println("<th width=50>내용</th>");
					out.println("<td colspan=5>&nbsp;<textarea rows=3 cols=50>" + memo + "</textarea></td>");
					out.println("</tr>");
				}
				out.println("</table>");
			} catch (ClassNotFoundException ce) {
				ce.printStackTrace();
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {if(rs != null) {rs.close();}	} catch (SQLException e) {e.printStackTrace();}
				try {if(pstmt != null) {pstmt.close();}	} catch (SQLException e) {e.printStackTrace();}
				try {if(con != null) {con.close();}	} catch (SQLException e) {e.printStackTrace();}
			}
			
			out.println("<p align=center><a href=/bbs/write.html>글쓰기</a></p>");
			out.println("</body></html>");
			
		} finally {
			out.close();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
