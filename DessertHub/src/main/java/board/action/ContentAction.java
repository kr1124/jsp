package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//글에대한 글 번호를 가져옴
		int num = Integer.parseInt(request.getParameter("num"));
		//페이지 번호를 가져옴
		String pageNum = request.getParameter("pageNum");
		
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = dbPro.getArticle(num);
		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		
		return "/boardmvc/content.jsp";
	}

}
