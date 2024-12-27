package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.control.ActionForward;
import member.model.MemberDAO;
import member.model.MemberVO;

public class ModifyProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String loginID = (String)session.getAttribute("loginID");
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = new MemberVO(loginID, request.getParameter("pass"),
									request.getParameter("email"), request.getParameter("nick"));
		
		dao.updateMember(vo);
		
		return new ActionForward("/mvcmem/modifyProc.jsp", false);
	}

}
