package com.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		//deleteForm.jsp 에서 사용할 속성 저장		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		return "/boardmvc/deleteForm.jsp";
	}

}
