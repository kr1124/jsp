package com.mvc.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.control.ActionForward;

/*
 * Action 인터페이스
 *  - 인터페이스를 구현한 모든 클래스임
 *  - 비즈니스 로직을 재정의할 메소드를 선언하고 있다.
 * */

public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	}
}
