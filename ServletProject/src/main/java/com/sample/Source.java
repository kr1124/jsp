package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 페이지 이동 방법
 *  - 메소드 호출을 통해서 페이지를 이동하는 두가지 방법
 *  1. forward
 *  2. redirect
 *  
 *  구분				forward		redirect
 *  url 				유지		변함
 *  요청객체, 응답객체	유지		유지 안됨
 *  속도				빠름		느림
 *  소속				request		response
 * */

@WebServlet("/Source")
public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		System.out.println("Source Start ........");
		//1. forward 
//		RequestDispatcher view = request.getRequestDispatcher("Destination");
//		view.forward(request, response);
		
		//2. redirect
		response.sendRedirect("Destination");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
