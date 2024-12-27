package member.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.control.ActionForward;
import member.model.MemberDAO;

public class DeleteProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDAO dao = MemberDAO.getInstance();
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("loginID");
		String pass = request.getParameter("pass");
		
		int check = dao.deleteMember(id, pass);
		
		if(check != 0) {
			session.invalidate();
		}
		
		request.setAttribute("check", check);
		
		return new ActionForward("/mvcmem/deleteProc.jsp", false);
	}

}
