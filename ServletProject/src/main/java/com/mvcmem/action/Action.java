package com.mvcmem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvcmem.control.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
