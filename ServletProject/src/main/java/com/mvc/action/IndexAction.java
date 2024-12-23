package com.mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.control.ActionForward;

/*
 * IndexAction
 *  - Action 인터페이스의 메소드를 재정의하고 있는 클래스
 *  - 실질적인 비즈니스 로직을 구현하는 클래스(구현체)
 * */

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("IndexAction의 execute() 메소드 수행됨!");		
		
		return new ActionForward("index.jsp", false);
	}

}
