package board.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.CommandAction;

//@WebServlet("/ControllerAction")
public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//명령어와 명령어 처리 클래스를 한 쌍으로 저장
	private Map<String, Object> commandMap = new HashMap<String, Object>();

//	명령어와 명령어 처리 클래스가 매핑되어 있는 
//	CommandPro.properties 파일을 읽어
//	Map 객체인 commandMap에 저장함
	public void init(ServletConfig config) throws ServletException {
		//web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		
		//명령어와 명령어 처리 클래스의 매핑 정보를 저장할 Properties 객체를 생성함
		Properties pr = new Properties();
		
		FileInputStream f = null;
		String path = config.getServletContext().getRealPath("/WEB-INF");
		
		try {
			//CommandPro.properties 파일의 내용 읽어옴
			f = new FileInputStream(new File(path, props));

			//CommandPro.properties 파일의 정보를 properties 객체에 저장함
			pr.load(f);
		} catch (IOException ioe) {
			throw new ServletException(ioe);
		} finally {
			if (f != null) try {f.close();} catch (IOException ioe) {}
		}
		
		Iterator<Object> keyIter = pr.keySet().iterator();
		
		//객체를 하나씩 꺼내서 그 객체명으로 properties 객체에 저장된 객체에 접근함
		while (keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			
			try {
				//해당 문자열을 클래스로 만듦
				Class commandClass = Class.forName(className);
				//해당 클래스의 객체를 생성함
				Object commandInstance = commandClass.newInstance();
				
				//Map 객체인 commandMap에 객체를 저장함
				commandMap.put(command, commandInstance);
				
			} catch (ClassNotFoundException cnfe) {
				// TODO: handle exception
			} catch (InstantiationException ie) {
				// TODO: handle exception
			} catch (IllegalAccessException iae) {
				// TODO: handle exception
			}
			
		}
	}

	//사용자의 요청을 분석해 해당 작업을 처리함
	protected void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction)commandMap.get(command);
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			throw new ServletException();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request, response);
	}

}
