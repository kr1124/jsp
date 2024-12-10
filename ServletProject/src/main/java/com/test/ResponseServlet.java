package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/Response" })
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head> <title> 오늘의 날짜 </title></head>");
		
		out.println("<body>");
		out.println("My First Servlet Programming");

		out.println("<hr color='red'>");
		out.println("<br>");
		out.println(date.toString());
		
		

		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	@PostConstruct // 선처리 작업
	public void initMethod() {
		System.out.println("initMethod");
	}

	@PreDestroy // 후처리 작업
	public void clean() {
		System.out.println("clean");
	}
}
