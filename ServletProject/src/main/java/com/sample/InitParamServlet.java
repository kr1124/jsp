package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name = "initParma");
//@WebServlet(name = "InitPara", init)


//@WebServlet("/InitParam")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String company;
	private String manager;
	private String tel;
	private String email;
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("초기화 메소드 수행됨...");

		//ServletConext의 초기 파라미터 값 읽어옴
		company = getServletContext().getInitParameter("company");
		manager = getServletContext().getInitParameter("manager");

		//ServletConext의 초기 파라미터 값 읽어옴
		tel = getServletContext().getInitParameter("tel");
		email = getServletContext().getInitParameter("email");
		
		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			out.print("<html><body>");

			out.print("<li>회사면 : " + company + "</li>");
			out.print("<li>회사면 : " + company + "</li>");
			out.print("<li>회사면 : " + company + "</li>");
			out.print("<li>회사면 : " + company + "</li>");
			
			out.print("<html><body>");			
		} finally {
			out.close();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
