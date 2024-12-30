package com.boardmvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boardmvc.model.BoardDAO;

public class DeleteProcAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		String pageNum = request.getParameter("pageNum");
		
		BoardDAO dbPro = BoardDAO.getInstance();

		int check = dbPro.deleteArticle(num, pass);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		return "/boardmvc/deleteProc.jsp";
	}

}
