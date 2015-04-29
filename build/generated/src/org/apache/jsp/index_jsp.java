package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import kaypoh.FacebookCrawler;
import kaypoh.TwitterCrawler;
import kaypoh.Kaypoh;
import StringMatching.KnuthMorrisPratt;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.LinkedList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Search</title>\n");
      out.write("        <link rel=\"stylesheet\" media=\"all\" href=\"bootstrap/css/bootstrap.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js\"></script>\n");
      out.write("    <script language=\"javascript\">\n");
      out.write("        //inisialisasi List kategori\n");
      out.write("        ");
 List<String> topics = asList("Health & Beauty", "Entertainment", "Sport", "Tech");
          List< List<String> > topicCategories = asList(
        asList("Obat", "Perawatan Tubuh", "Perawatan Wajah","Fashion"),
        asList("Musik", "Movies", "TV","Celebrity"),
        asList("Bola", "Raket", "Atlet"),
        asList("Internet","Gadget","Science")
    );
      out.write("\n");
      out.write("        ");
 String a = request.getParameter("modeapp") ;

            int CO;
        
      out.write("\n");
      out.write("    function Beauty() \n");
      out.write("    {\n");
      out.write("        document.getElementById(\"image\").src = \"image/Maskot-Act-Beauty2.png\";\n");
      out.write("         document.body.style.background = \"#FF81FA\";\n");
      out.write("         \n");
      out.write("        ");
CO=0;
      out.write("\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function Music() \n");
      out.write("    {\n");
      out.write("        document.getElementById(\"image\").src = \"image/Maskot-Act-Music2.png\"; \n");
      out.write("        document.body.style.background = \"#50FF54\";\n");
      out.write("        ");
CO=1;
      out.write("\n");
      out.write("        ");
List<String> Kategori= topicCategories.get(CO); 
      out.write("\n");
      out.write("        ");
 for(int i=0;i<Kategori.size();i++) {
      out.write("\n");
      out.write("                document.getElementById(\"NamaKategori\").innerHTML = \"Kategori ");
      out.print( Kategori.get(i));
      out.write("\";\n");
      out.write("        ");
}
      out.write("       \n");
      out.write("    };\n");
      out.write("    function Sport() \n");
      out.write("    {\n");
      out.write("        document.getElementById(\"image\").src = \"image/Maskot-Act-Sport2.png\";\n");
      out.write("        document.body.style.background = \"#6D9987\";\n");
      out.write("        ");
CO=2;
      out.write("\n");
      out.write("                \n");
      out.write("    }\n");
      out.write("    function Tech() \n");
      out.write("    {\n");
      out.write("        document.getElementById(\"image\").src = \"image/Maskot-Act-Tech2.png\"; \n");
      out.write("        document.body.style.background = \"#2CCC8A\";\n");
      out.write("        ");
CO=3;
      out.write("\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");
CO=0;
      out.write("\n");
      out.write("    <div class=\"TopicArt\"> \n");
      out.write("       <img alt=\"\" src=\"image/Maskot-Act-Beauty2.png\" \n");
      out.write("            style=\"height: 500px; position:relative;\" id=\"image\" />\n");
      out.write("        <p>\n");
      out.write("        <input id=\"Button1\" class=\"btn btn-default\" type=\"button\" value=\"Beauty\" onclick=\"Beauty()\" />&nbsp;&nbsp; \n");
      out.write("        <input id=\"Button2\" class=\"btn btn-default\" accept=\"\"type=\"button\" value=\"Music\" onclick=\"Music()\" />&nbsp;&nbsp;\n");
      out.write("        <input id=\"Button3\" class=\"btn btn-default\" type=\"button\" value=\"Sport\" onclick=\"Sport()\" />&nbsp;&nbsp;\n");
      out.write("        <input id=\"Button4\" class=\"btn btn-default\" type=\"button\" value=\"Tech\" onclick=\"Tech()\" />&nbsp;&nbsp;\n");
      out.write("        <form action=\"index11.html\">\n");
      out.write("            <input type=\"submit\" value=\"About\">\n");
      out.write("        </form>\n");
      out.write("        </p>\n");
      out.write("    </div>\n");
      out.write("        <div class = \"searchform\" >\n");
      out.write("            <form class=\"form-horizontal\" action=\"index2.jsp\" method=\"GET\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputCategory\" id=\"NamaKeyword\" class=\"col-sm-2 control-label\">Keyword ");
      out.print(topics.get(CO));
      out.write("</label>\n");
      out.write("                    <div class=\"col-sm-11\">\n");
      out.write("                        <input type=\"hidden\" name=\"topic\" value=\"");
      out.print(topics.get(CO));
      out.write("\"/>\n");
      out.write("                        <input type=\"text\" name=\"keyword\" class=\"form-control\"  placeholder=\"#hiburan\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
List<String> Kategori= topicCategories.get(CO); 
      out.write("\n");
      out.write("                ");
 for(int i=0;i<Kategori.size();i++) {
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    \n");
      out.write("                    <label for=\"inputCategory\" id=\"NamaKategori\" class=\"col-sm-2 control-label\">Kategori ");
      out.print( Kategori.get(i));
      out.write("</label>\n");
      out.write("                    <div class=\"col-sm-11\">\n");
      out.write("                        <input type=\"text\" name=\"kategori\"class=\"form-control\"  placeholder=\"Tv, Bedak, Mikasa\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                     <input type=\"hidden\" name=\"mode\" class=\"form-control\" value=\"");
      out.print(a);
      out.write("\" >\n");
      out.write("                <br/>\n");
      out.write("                <input type=\"radio\" name=\"group2\" value=\"kmp\"> KMP  \n");
      out.write("                <input type=\"radio\" name=\"group2\" value=\"bm\" checked> BM\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-offset-7 col-sm-10\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Search</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("    \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("<!--footer>\n");
      out.write("</footer-->\n");
      out.write("<script src=\"bootstrap/js/bootstrap.min.js\" />\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
