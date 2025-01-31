package com.mvc.control;
/*
 * 비즈니스 로직의 수행이 필요한 경우 반드시 ControlServlet이 해당 요청을 처리할 수 있도록
 * 클라이언트의 요청 url을 test.do 형태로 하고, web.xml에 매핑정보를 추가한다. 
*/

/*
 * ActionForward
 * 	- IndexAction의 비즈니스 로직을 수행후 ControlServlet에게
 * 	  반환하는 객체 (이동할 url 과 이동 방법을 저장하는 클래스)
 * */

public class ActionForward {
	private String url;
	private boolean redirect;

	public ActionForward() {}

	public ActionForward(String url) {
		this.url = url;
	}

	public ActionForward(String url, boolean redirect) {
		this.url = url;
		this.redirect = redirect;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
