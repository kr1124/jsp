package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.control.ActionForward;
import member.model.MemberDAO;
import member.model.MemberVO;

public class RegProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = new MemberVO(loginID, request.getParameter("pass"),
									request.getParameter("email"), request.getParameter("nick"));
		
		boolean flag = dao.memberInsert(vo);
		request.setAttribute("flag", flag);
		
		return new ActionForward("/mvcmem/regProc.jsp", false);
	}

}
