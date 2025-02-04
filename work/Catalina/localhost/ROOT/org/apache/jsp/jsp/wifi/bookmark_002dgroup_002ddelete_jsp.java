/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.25
 * Generated at: 2024-07-31 03:37:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.wifi;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.hmw.jsp.wifi.dto.BookMarkGroupDto;

public final class bookmark_002dgroup_002ddelete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/jsp/header.jsp", Long.valueOf(1722338900579L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("com.hmw.jsp.wifi.dto.BookMarkGroupDto");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
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

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/style2.css\">\n");
      out.write("</head>\n");
      out.write("\n");

BookMarkGroupDto bm = (BookMarkGroupDto)request.getAttribute("bookMarkGroupDto");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<h1>위치 히스토리 목록</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div>\n");
      out.write("    <a href=\"http://localhost:8080\">홈</a> |\n");
      out.write("    <a href=\"http://localhost:8080/wifi/historyList.jsp\">위치 히스토리 목록</a> |\n");
      out.write("    <a href=\"http://localhost:8080/wifi/load-wifi\">Open API 와이파이 정보 가져오기</a> |\n");
      out.write("    <a href=\"http://localhost:8080/wifi/bookmark-list.jsp\">즐겨 찾기 보기</a> |\n");
      out.write("    <a href=\"http://localhost:8080/wifi/bookmark-group.jsp\">즐겨 찾기 그룹 관리</a>\n");
      out.write("</div>\n");
      out.write("</body>");
      out.write("\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("북마크 그룹 이름을 삭제하시겠습니까?\n");
      out.write("\n");
      out.write("<form action=\"http://localhost:8080/wifi/bookmark-group-delete-submit.jsp\" method=\"get\">\n");
      out.write("\n");
      out.write("    <table>\n");
      out.write("        <br>\n");
      out.write("        <tr>\n");
      out.write("            <th>북마크 이름</th>\n");
      out.write("            <td><input type=\"text\" name=\"bookmarkName\" value=\"");
      out.print(bm.getName());
      out.write("\"/></td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <th>순서</th>\n");
      out.write("            <td><input type=\"text\" name=\"order\" value=\"");
      out.print(bm.getOrder());
      out.write("\"/></td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        <input hidden=\"hidden\" name=\"id\" value=\"");
      out.print(bm.getId());
      out.write("\">\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    <div style=\"text-align: center; margin-top: 10px;\">\n");
      out.write("        <a href=\"http://localhost:8080/wifi/bookmark-group.jsp\">돌아가기</a>|<button type=\"submit\">삭제</button>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("</body>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
