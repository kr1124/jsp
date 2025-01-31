package com.mvctwo;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//명령어와 명령어 처리 클래스를 쌍으로 저장
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	
	/* 명령어와 처리클래스가 매핑되어 있는 Command.properties 파일을 읽어서
	 * Map 객체인 commandMap에 저장함
	 * */
	
	public void init(ServletConfig config) throws ServletException {
		//web.xml 파일에서 init-param 태그의 파라미터 이름인
		//propertyConfig에 해당하는 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		
		//명령어와 처리클래스의 매핑정보를 저장할 Properties 객체를 생성함
		Properties pr = new Properties();
		
		String path = config.getServletContext().getRealPath("/WEB-INF");
		
		FileInputStream f = null;
		
		try {
			//Command.Pproperties 파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			
			//Command.Pproperties 파일의 정보를 Properties 객체에 저장함
			pr.load(f);
			
		} catch (IOException ie) {
			throw new ServletException(ie);
		} finally {
			if(f != null) try { f.close();} catch (IOException ie) {}
		}
		
		// Iterator 객체는 반복자, 순차적으로 읽어옴
		Iterator<Object> keyIter = pr.keySet().iterator();
		
		// 객체를 하나씩 꺼내서 그 객체명으로 properties 객체에 저장된 객체에 접근함
		while (keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			try { //해당 문자열을 활용하여 클래스를 만듦
				Class commandClass = Class.forName(className);
				
				//해당 클래스를 객체로 만듦
				Object commandInstance = commandClass.newInstance();
				
				//Map 객체인 commandMap에 저장함
				commandMap.put(command, commandInstance);
				
			} catch (ClassNotFoundException ce) {
				throw new ServletException(ce);
			} catch (InstantiationException ie) {
				throw new ServletException(ie);				
			} catch (IllegalAccessException iae) {
				throw new ServletException(iae);				
			}
		}
	}

	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandProcess com = null;
		
		try {
			String command = request.getRequestURI();
			
			if (command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			
			com = (CommandProcess)commandMap.get(command);
			view = com.requestPro(request, response);
			
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		
		dispatcher.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

}
