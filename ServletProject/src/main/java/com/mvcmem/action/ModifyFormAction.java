package com.mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvcmem.control.ActionForward;
import com.mvcmem.model.StudentDAO;
import com.mvcmem.model.StudentVO;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StudentDAO dao = StudentDAO.getInstance();
		HttpSession session = request.getSession();
		String loginID = (String)session.getAttribute("loginID");
		StudentVO vo = dao.getMember(loginID);
		
		request.setAttribute("id", vo.getId());
		request.setAttribute("pass", vo.getPass());
		request.setAttribute("name", vo.getName());
		request.setAttribute("phone1", vo.getPhone1());
		request.setAttribute("phone2", vo.getPhone2());
		request.setAttribute("phone3", vo.getPhone3());
		request.setAttribute("email", vo.getEmail());
		request.setAttribute("zipcode", vo.getZipcode());
		request.setAttribute("address1", vo.getAddress1());
		request.setAttribute("address2", vo.getAddress2());		
		
		return new ActionForward("/mvcmem/modifyForm.jsp", false);
	}

}
