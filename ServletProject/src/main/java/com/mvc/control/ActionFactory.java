package com.mvc.control;

import com.mvc.action.Action;
import com.mvc.action.IndexAction;

/*
 * 사용자(클라이언트)의 요청을 처리할 비즈니스 로직이 구현된 
 * IndexAction 객체의 생성을 담당
 * */

public class ActionFactory {
	private static ActionFactory factory = null;
	
	public ActionFactory() {}
	
	public static synchronized ActionFactory getInstance() {
		if (factory == null) {
			factory = new ActionFactory();			
		}
		
		return factory;		
	}
	
	public Action getAction(String cmd) {
		Action action = null;
		
		if (cmd.equals("index")) {
			action = new IndexAction();
		}
		
		return action;	
	}
}
