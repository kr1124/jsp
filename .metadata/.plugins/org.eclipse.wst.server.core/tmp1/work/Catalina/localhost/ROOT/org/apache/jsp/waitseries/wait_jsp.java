/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-16 02:10:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.waitseries;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class wait_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("    <title id=\"top_title\">1초만 기다리면</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/wait_style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("        <p id=\"head_text\">\r\n");
      out.write("            1초만 기다리면 페이지를 찾을 수 있어요!\r\n");
      out.write("        </p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <img src=\"/img/wait01.webp\" class=\"cimg\" id=\"wait_photo\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"box\"></div>\r\n");
      out.write("        <div class=\"box\" width=\"60%\">\r\n");
      out.write("            <p id=\"text1\" class=\"main_text\" style=\"display:block\">\r\n");
      out.write("                왜냐면 이제부터 기다림이 1초를 넘을 때마다<br>\r\n");
      out.write("\r\n");
      out.write("                대가리를 존나 쎄게 쳐서 제 머릿속을 뒤죽박죽 엉망진창으로 만들 거거든요! <br><br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                기다렸다는 것이 기억이 나지 않는다면<br>\r\n");
      out.write("\r\n");
      out.write("                안 기다린 게 아닐까요?<br>\r\n");
      out.write("\r\n");
      out.write("                그렇게 페이지가 나올때까지 1초가 지나기 전에 기억을 지운다면<br><br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                1초만에 페이지가 나오는 것이 아닐까요???<br>\r\n");
      out.write("\r\n");
      out.write("                1초만 기다리면 페이지가 나온다니! <br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                생각만 해도 너무 즐거워요~!!!\r\n");
      out.write("            </p>\r\n");
      out.write("            <p id=\"text2\" class=\"main_text\" style=\"display:none\">\r\n");
      out.write("                외나먼 이 제부더 기다 림이 1초 를 넘을대마다<br><br><br>\r\n");
      out.write("\r\n");
      out.write("                대가 리를 존나 세게 처서 제머 리소글 뒤주뱍주 어마지차으로 만드 거거드요?<br><br><br><br><br>\r\n");
      out.write("\r\n");
      out.write("                기다러다는 거시 기억이 나지 안는다먼<br><br><br>\r\n");
      out.write("\r\n");
      out.write("                안 기다린 게 아니 가요!<br><br><br>\r\n");
      out.write("\r\n");
      out.write("                그러헤 페이지가 나 올대가지 1초가지나기 저헤 기어흘 지운다면<br><br><br>\r\n");
      out.write("\r\n");
      out.write("                1초마헤 페이지가 나오는는 거히 아니가요!!!<br><br><br><br><br>\r\n");
      out.write("\r\n");
      out.write("                1 초만 기다리허 페이지가 나온다니?<br><br><br>\r\n");
      out.write("\r\n");
      out.write("                생강만 해 도 너무 즐거 어요~???\r\n");
      out.write("            </p>\r\n");
      out.write("            <p id=\"text3\" class=\"main_text_v2\" style=\"display:none\">\r\n");
      out.write("                <span class=\"red_under\">왜!</span>!!<span class=\"darkblue\">!!</span>!!!!<span class=\"darkslateblue\">냐</span><span class=\"dimgrey\">!!!!!</span>!!!면!!​!!!​!!! 이히이이이이이이이이이이이이이이이이이이이이이!?!?@?@?!?&gt;@&lt;!!! <br><br><br>\r\n");
      out.write("\r\n");
      out.write("                머리이이이이이이이이¡!!!!!¡¡!!¡!¡!¡!!!! <br><br><br>\r\n");
      out.write("\r\n");
      out.write("                하루하루!!!!!¡¡!!!!!!#^#*¤​♧☆¥​¥°$^*¿¡!?!!?!¡​¿​¡?¡ <br><br><br>\r\n");
      out.write("                \r\n");
      out.write("                끼얏호우~~~!!!!~~~!!~\r\n");
      out.write("            </p>\r\n");
      out.write("            <p id=\"text4\" class=\"main_text_v2\" style=\"display:none\">\r\n");
      out.write("                404 not found\r\n");
      out.write("            </p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"box\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <button class=\"custom-button\" id=\"next_button\" value=\"\">1초는 이미 지난거 같다만...</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    const nbutton = document.getElementById(\"next_button\");\r\n");
      out.write("    let page_step = 1; //1~4\r\n");
      out.write("    let isRepeat = 1;\r\n");
      out.write("    let change_speed = 5; //bigger, slower\r\n");
      out.write("    //1C = 255, 6C = 1530\r\n");
      out.write("    //255 510 765 1020 1275 1530\r\n");
      out.write("    change_head();\r\n");
      out.write("\r\n");
      out.write("    nbutton.addEventListener('click', function() {\r\n");
      out.write("        //let page_step = document.getElementById(\"next_button\").value * 1;\r\n");
      out.write("\r\n");
      out.write("        page_step += 1;\r\n");
      out.write("        if(page_step > 4) { //마지막 버튼 누를때\r\n");
      out.write("        	history.go(-1);\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        document.getElementById(\"next_button\").value = page_step;\r\n");
      out.write("        change_photo(page_step);\r\n");
      out.write("        change_paragraph(page_step);\r\n");
      out.write("        //change main\r\n");
      out.write("        change_button(page_step);\r\n");
      out.write("        scrollToTop();\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    // function change_page() {\r\n");
      out.write("    //     //let page_step = document.getElementById(\"next_button\").value * 1;\r\n");
      out.write("\r\n");
      out.write("    //     page_step += 1;\r\n");
      out.write("    //     if(page_step > 4) page_step=4;\r\n");
      out.write("        \r\n");
      out.write("    //     document.getElementById(\"next_button\").value = page_step;\r\n");
      out.write("    //     change_photo(page_step);\r\n");
      out.write("    //     //change main\r\n");
      out.write("    //     change_button(page_step);\r\n");
      out.write("    // }\r\n");
      out.write("\r\n");
      out.write("    function change_photo(ps) {\r\n");
      out.write("        let photo_src = \"/img/wait01.webp\"\r\n");
      out.write("        switch (ps) {\r\n");
      out.write("            case 1:\r\n");
      out.write("            case 2:\r\n");
      out.write("                photo_src = \"/img/wait01.webp\"\r\n");
      out.write("                break;\r\n");
      out.write("            case 3:\r\n");
      out.write("                photo_src = \"/img/wait03.jpeg\"\r\n");
      out.write("                break;\r\n");
      out.write("            case 4:\r\n");
      out.write("                photo_src = \"/img/wait04.png\"\r\n");
      out.write("                break;\r\n");
      out.write("            default:\r\n");
      out.write("                break;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        document.getElementById(\"wait_photo\").src = photo_src;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function change_paragraph(ps) {\r\n");
      out.write("        document.getElementById(\"text1\").style.display = \"none\";\r\n");
      out.write("        document.getElementById(\"text2\").style.display = \"none\";\r\n");
      out.write("        document.getElementById(\"text3\").style.display = \"none\";\r\n");
      out.write("        document.getElementById(\"text4\").style.display = \"none\";\r\n");
      out.write("        switch (ps) {\r\n");
      out.write("            case 1:\r\n");
      out.write("                document.getElementById(\"text1\").style.display = \"block\";\r\n");
      out.write("                break;\r\n");
      out.write("            case 2:\r\n");
      out.write("                document.getElementById(\"text2\").style.display = \"block\";\r\n");
      out.write("                break;\r\n");
      out.write("            case 3:\r\n");
      out.write("                document.getElementById(\"text3\").style.display = \"block\";\r\n");
      out.write("                break;\r\n");
      out.write("            case 4:\r\n");
      out.write("                document.getElementById(\"text4\").style.display = \"block\";\r\n");
      out.write("                break;\r\n");
      out.write("            default:\r\n");
      out.write("                break;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function change_button(ps) {\r\n");
      out.write("        let button_text = \"\";\r\n");
      out.write("\r\n");
      out.write("        switch (ps) {\r\n");
      out.write("            case 1:\r\n");
      out.write("                button_text = \"1초는 이미 지난거 같다만...\"\r\n");
      out.write("                break;\r\n");
      out.write("            case 2:\r\n");
      out.write("                button_text = \"？？？뭐？？？\"\r\n");
      out.write("                break;\r\n");
      out.write("            case 3:\r\n");
      out.write("                button_text = \"이 무슨....\"\r\n");
      out.write("                break;\r\n");
      out.write("            case 4:\r\n");
      out.write("                button_text = \".........\"\r\n");
      out.write("                break;\r\n");
      out.write("            default:\r\n");
      out.write("                break;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        document.getElementById(\"next_button\").innerHTML = button_text;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function scrollToTop() {\r\n");
      out.write("        // 페이지를 최상단으로 스크롤\r\n");
      out.write("        window.scrollTo({\r\n");
      out.write("            top: 0,\r\n");
      out.write("            //behavior: 'smooth' // 부드럽게 스크롤 이동\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function sleep(ms) {\r\n");
      out.write("        return new Promise(resolve => setTimeout(resolve, ms));\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    async function change_head() {\r\n");
      out.write("        const ht = document.getElementById(\"head_text\");\r\n");
      out.write("        ht.style.fontSize = \"30px\";\r\n");
      out.write("\r\n");
      out.write("        while(isRepeat == 1) {\r\n");
      out.write("            ht.style.color = calc_rgb();\r\n");
      out.write("            await sleep(10);\r\n");
      out.write("        }        \r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function calc_rgb() {\r\n");
      out.write("        const now = new Date();\r\n");
      out.write("        const origin_timestamp = now.getTime();\r\n");
      out.write("        let timestamp = origin_timestamp / change_speed;\r\n");
      out.write("        //console.log(timestamp); // 밀리초 단위의 타임스탬프 출력\r\n");
      out.write("\r\n");
      out.write("        const M = 255;\r\n");
      out.write("        let color_hash = timestamp % 1530;\r\n");
      out.write("\r\n");
      out.write("        let color_r = M;\r\n");
      out.write("        let color_g = M;\r\n");
      out.write("        let color_b = M;\r\n");
      out.write("\r\n");
      out.write("        if (color_hash <= M) {\r\n");
      out.write("            color_r = M;\r\n");
      out.write("            color_g = color_hash;\r\n");
      out.write("            color_b = 0;\r\n");
      out.write("        }\r\n");
      out.write("        else if (color_hash <= M * 2) {\r\n");
      out.write("            color_r = color_hash * -1 + M * 2;\r\n");
      out.write("            color_g = M;\r\n");
      out.write("            color_b = 0;\r\n");
      out.write("        }\r\n");
      out.write("        else if (color_hash <= M * 3) {\r\n");
      out.write("            color_r = 0;\r\n");
      out.write("            color_g = M;\r\n");
      out.write("            color_b = color_hash - M * 2;\r\n");
      out.write("        }\r\n");
      out.write("        else if (color_hash <= M * 4) {\r\n");
      out.write("            color_r = 0;\r\n");
      out.write("            color_g = color_hash * -1 + M * 4;\r\n");
      out.write("            color_b = M;\r\n");
      out.write("        }\r\n");
      out.write("        else if (color_hash <= M * 5) {\r\n");
      out.write("            color_r = color_hash - M * 4;\r\n");
      out.write("            color_g = 0;\r\n");
      out.write("            color_b = M;\r\n");
      out.write("        }\r\n");
      out.write("        else if (color_hash <= M * 6) {\r\n");
      out.write("            color_r = M;\r\n");
      out.write("            color_g = 0;\r\n");
      out.write("            color_b = color_hash * -1 + M * 6;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        return \"rgb(\" + color_r + \", \" + color_g + \", \" + color_b + \")\";\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
