/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-10 07:53:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.board.BoardDAO;
import com.board.BoardVO;
import java.util.*;
import java.text.SimpleDateFormat;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/board/view/color.jsp", Long.valueOf(1733795253248L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("com.board.BoardDAO");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("com.board.BoardVO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

String bodyback_c = "#e0ffff";
String back_c = "#8fbc8f";
String title_c = "#5f9ea0";
String value_c = "#b0e0e6";
String bar = "#778899";

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	int count = 0;
	int number = 0;
	List<BoardVO> articleList = null;
	BoardDAO dbPro = BoardDAO.getInstance();
	
	count = dbPro.getArticleCount();
	
	if(count > 0) {
		articleList = dbPro.getArticles();
	}
	number = count;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title></title>\r\n");
      out.write("	<link href=\"style.css\" type=\"text/css\" rel=\"stylesheet\" >\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"");
      out.print(bodyback_c);
      out.write("\">\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		<b>글목록(전체 글 : ");
      out.print(count);
      out.write(")</b>\r\n");
      out.write("		<table width=\"700\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td align=\"right\" bgcolor=\"");
      out.print(value_c);
      out.write("\">\r\n");
      out.write("					<a href=\"writeForm.jsp\">글쓰기</a>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	");
if(count == 0) { 
      out.write("\r\n");
      out.write("		<table style=\"width: 700; border: 1;\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td align=\"center\">\r\n");
      out.write("					게시판에 저장된 글이 없습니다.\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	");
} else {
      out.write("\r\n");
      out.write("		<!-- <table style=\"width: 700; border: 1; align-items: center\" cellpadding=\"0\" cellspacing=\"0\"> -->\r\n");
      out.write("		<table style=\"width: 700; align-items: center;\" border=\"1\"  cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("		\r\n");
      out.write("			<tr height=\"30\" bgcolor=\"");
      out.print(value_c);
      out.write("\">\r\n");
      out.write("				<td align=\"center\" width=\"50\">번호</td>\r\n");
      out.write("				<td align=\"center\" width=\"250\">제목</td>\r\n");
      out.write("				<td align=\"center\" width=\"100\">작성자</td>\r\n");
      out.write("				<td align=\"center\" width=\"150\">작성일</td>\r\n");
      out.write("				<td align=\"center\" width=\"50\">조회수</td>\r\n");
      out.write("				<td align=\"center\" width=\"100\">IP</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			");

			for(int i = 0; i < articleList.size(); i++) {
				BoardVO article = (BoardVO)articleList.get(i);
			
      out.write("\r\n");
      out.write("			<tr height=\"30\">\r\n");
      out.write("				<td align=\"center\" width=\"50\">");
      out.print(number-- );
      out.write("</td>\r\n");
      out.write("				<td width=\"250\">\r\n");
      out.write("					<a href=\"content.jsp?num=");
      out.print(article.getNum());
      out.write("&pageNum1\">\r\n");
      out.write("						");
      out.print(article.getSubject() );
      out.write("\r\n");
      out.write("					</a>\r\n");
      out.write("					");
 if(article.getReadcount() >= 20) { 
      out.write("\r\n");
      out.write("					<img src=\"img/hot.gif\" border=\"0\" height=\"16\">\r\n");
      out.write("					");
} 
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("				<td align=\"center\" width=\"100\">\r\n");
      out.write("					<a href=\"mailto:");
      out.print(article.getEmail());
      out.write("\">\r\n");
      out.write("						");
      out.print(article.getWriter() );
      out.write("\r\n");
      out.write("					</a>\r\n");
      out.write("				</td>\r\n");
      out.write("				<td align=\"center\" width=\"150\">\r\n");
      out.write("					");
      out.print(sdf.format(article.getRegdate()) );
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("				<td align=\"center\" width=\"50\">\r\n");
      out.write("					");
      out.print(article.getReadcount() );
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("				<td align=\"center\" width=\"100\">\r\n");
      out.write("					");
      out.print(article.getIp() );
      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			\r\n");
      out.write("			");
}
      out.write("\r\n");
      out.write("		</table>\r\n");
} 
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}