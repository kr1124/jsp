package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boardmvc.model.BoardDAO;
import com.boardmvc.model.BoardVO;

public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//글에대한 글 번호를 가져옴
		int num = Integer.parseInt(request.getParameter("num"));
		//페이지 번호를 가져옴
		String pageNum = request.getParameter("pageNum");
		
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = dbPro.updateGetArticle(num);
		
		//updateForm.jsp 페이지에서 사용할 속성을 저장
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		
		return "/boardmvc/updateForm.jsp";
	}

}
