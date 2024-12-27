package com.boardmvc.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boardmvc.model.BoardDAO;
import com.boardmvc.model.BoardVO;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum"); 
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 5; //밑에 나열할 페이지 숫자들의 개수 (6, 7, 8, 9, 10같은거)
		int currentPage = Integer.parseInt(pageNum);
		
		// 한 페이지의 시작 글번호
		int startRow = (currentPage - 1) * pageSize;
		
		// 한 페이지의 마지막 글번호
		int endRow = currentPage * pageSize;
		
		int count = 0;
		int number = 0;
		List<BoardVO> articleList = null;
		
		BoardDAO dbPro = BoardDAO.getInstance();
		
		count = dbPro.getArticleCount();
		
		if(count > 0) {
			articleList = dbPro.getArticles(startRow, endRow);
		} else {
			articleList = Collections.emptyList();
		}
		
		//글 목록에 표시할 글 번호
		number = count - (currentPage - 1) * pageSize;
		
		//해당 뷰(list.jsp)에서 사용할 속성 저장
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("articleList", articleList);
		
		return "/boardmvc/list.jsp";
	}

}
