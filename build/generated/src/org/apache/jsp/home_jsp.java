package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" media=\"all\" href=\"bootstrap/css/bootstrap.css\" />\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"css/home.css\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"css/hover-min.css\">\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js\"></script>\n");
      out.write("       \n");
      out.write("        <title>HOME Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"row\">\n");
      out.write(" \n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("                <form action=\"index.jsp\" method=\"GET\">\n");
      out.write("                    <input type=\"image\" class=\"logo hvr-pulse\" src=\"image/homefb.png\" name=\"modeapp\" class=\"btTxt submit\" value=\"fb\" />\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4 logou\">\n");
      out.write("                <img src=\"images/HomeHome.png\" />\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                <form action=\"index.jsp\" method=\"GET\">\n");
      out.write("                    <input type=\"image\" class=\"logo hvr-pulse\" src=\"image/hometwit.png\" name=\"modeapp\" class=\"btTxt submit\" value=\"tw\"  />\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-6 col-md-offset-3\"><!--img src=\"image/Maskot-Act-Sport.png\"width=\"100%\"></div-->\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <script src=\"bootstrap/js/bootstrap.min.js\" />\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
