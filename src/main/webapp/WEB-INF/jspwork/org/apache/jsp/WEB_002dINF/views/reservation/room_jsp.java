/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.62
 * Generated at: 2022-06-14 03:19:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.reservation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class room_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1654736871595L));
    _jspx_dependants.put("jar:file:/Users/sin-ayun/workspace/local/Admin_HotelLala/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>객실관리</title>\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/main-style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/sideBar-style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/reservation/room-style.css\">\n");
      out.write("    \n");
      out.write("    <script src=\"https://kit.fontawesome.com/a7e904a504.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <main class=\"container\">\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/sideBar.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <section id=\"content\">\n");
      out.write("\n");
      out.write("            <div class=\"content-header\">\n");
      out.write("                <div class=\"content-name\">Room Manage</div> \n");
      out.write("                <div class=\"content-detailname\">- 객실관리</div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"floor-icon\">\n");
      out.write("                <div>\n");
      out.write("                    <div id=\"sixthF\">6F</div>\n");
      out.write("                    <div id=\"fifthF\">5F</div>\n");
      out.write("                    <div id=\"forthF\">4F</div>\n");
      out.write("                    <div id=\"thirdF\">3F</div>\n");
      out.write("                    <div id=\"secondF\">2F</div>\n");
      out.write("                    <div>LOBBY</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"room\">\n");
      out.write("                \n");
      out.write("                <div class=\"top\">\n");
      out.write("                    <div class=\"room-info In\">\n");
      out.write("                        <div>101</div>\n");
      out.write("                        <div>유저일 님</div>\n");
      out.write("                        <div>22.06.01~(1박)</div>\n");
      out.write("                        <div>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <button class=\"reserve-detail\">예약상세</button>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"room-info In\">\n");
      out.write("                        <div>102</div>\n");
      out.write("                        <div>유저일 님</div>\n");
      out.write("                        <div>22.06.01~(1박)</div>\n");
      out.write("                        <div>\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                <button class=\"reserve-detail\">예약상세</button>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"room-info\">\n");
      out.write("                        <div>103</div>\n");
      out.write("                        <div>예약가능</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("    <div class=\"modal\">\n");
      out.write("        <div class=\"modal-window\">\n");
      out.write("            <div class=\"modal-close\">&times;</div>\n");
      out.write("            <div class=\"title\">\n");
      out.write("                <div>예약 상세</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>예약번호</div>\n");
      out.write("                        <div>01</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>예약자명</div>\n");
      out.write("                        <div>유저일</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>예약접수일</div>\n");
      out.write("                        <div>2022-06-01 00:00:00</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>입실일</div>\n");
      out.write("                        <div>2022.06.03(수) / 1박</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>인원</div>\n");
      out.write("                        <div>성인 : 2명</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>휴대폰번호</div>\n");
      out.write("                        <div>010-1234-1234</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>예약상태</div>\n");
      out.write("                        <div>예약완료</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <div>객실 요청 사항</div>\n");
      out.write("                        <div>헤어드라이기</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-btn-area\">\n");
      out.write("                <button id=\"modal-btn\">확인</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- jQuery 라이브러리 추가 -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\" integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <!-- <script>const roomNo = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roomNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</script> -->\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/reservation/room.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
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
