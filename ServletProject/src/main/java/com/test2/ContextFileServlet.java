package com.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextFileServlet
 */
@WebServlet("/ContextFile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String readFile = "/WEB-INF/testFile.txt";
		InputStream is = getServletContext().getResourceAsStream(readFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		String str = reader.readLine();
		while(str != null) {
			out.println(str + "<br>");
			str=reader.readLine();
		}
		reader.close();
		
		out.print("</body></html>");
		
	}

}
