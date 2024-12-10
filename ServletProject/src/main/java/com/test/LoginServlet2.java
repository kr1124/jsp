package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Login")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid"); //form에 있던 name
		String pw = request.getParameter("passwd"); //form에 있던 name
		
		System.out.println(id + " : " + pw);
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head> <title> 적당한 로그인 창 </title></head>");
		
		out.println("<body>");
		out.println("<h1>로그인 창입니다.</h1>"
					+ "<hr color='red'>"
					+ "<br>"
					+ "<p>id : " + id + ", \n"
					+ "password : " + pw
					+ "로 로그인하였습니다.</p>"
					+ "</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
