package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import kaypoh.Kaypoh;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>\r\n");
      out.write("\t\t<meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"> \r\n");
      out.write("        <title>Accordion with CSS3</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \r\n");
      out.write("        <meta name=\"description\" content=\"Accordion with CSS3\" />\r\n");
      out.write("        <meta name=\"keywords\" content=\"accordion, css3, sibling selector, radio buttons, input, pseudo class\" />\r\n");
      out.write("        <meta name=\"author\" content=\"Codrops\" />\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/demo.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style1.css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"js/modernizr.custom.29473.js\"></script>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 
        String [] CategoryField=request.getParameterValues("kategori");
        String [] args= new String[10];
        //api
//        args[0]=request.getParameter("mode") ;//"tw";
//        args[1]="kmp";
//        args[2]=request.getParameter("topic");//"Beauty";
//        //tags
//        args[3]=request.getParameter("keyword") ;//"#Salon";
//        out.print(CategoryField.length+4);
//        for(int i=4;i<(CategoryField.length+4);i++){
//        args[i]=CategoryField[i-4];
//        }
        //args[5]="bedak,kalung";
        //args[6]="job";
        args[0]="tw";//request.getParameter("mode") ;
        args[1]="kmp";
        args[2]="Beauty";
        //tags
        args[3]="#Salon";//request.getParameter("keyword") ;
        args[4]="sex";
        args[5]="bedak,kalung";
        args[6]="job";
        args[7]="apapun";
        Kaypoh Kepo = new Kaypoh(args);
        List<List> allresult = Kepo.getResult();

       
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("                <div class=\"maskot\"><img src=\"images/Kaypoh-MaskotSmall.png\"/></div>\r\n");
      out.write("\t\t\t<h1>Search <span>RESULT</span></h1>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t\t<section class=\"ac-container\">\r\n");
      out.write("                            ");
 List<String> NamaKategori= Kepo.topicCategories.get(0); 
      out.write("\r\n");
      out.write("                                <div>\r\n");
      out.write("\t\t\t\t\t<input id=\"ac-");
      out.print(NamaKategori.size());
      out.write("\" name=\"accordion-1\" type=\"radio\" checked />\r\n");
      out.write("\t\t\t\t\t<label for=\"ac-");
      out.print(NamaKategori.size());
      out.write("\">KATEGORI UNKNOWN</label>\r\n");
      out.write("\t\t\t\t\t<article class=\"ac-small\">\r\n");
      out.write("                                            \r\n");
      out.write("                                            ");
 List<String> resultU= allresult.get(NamaKategori.size());
                                            for(int a=0;a<resultU.size();a++) {
      out.write(" \r\n");
      out.write("                                            <br>\r\n");
      out.write("                                            <!--div class=\"picture\">\r\n");
      out.write("                                                <img alt=\"\" src=\"image/Maskot-Act-Beauty.png\"\r\n");
      out.write("                                                     style=\"height: 85px; \" id=\"image\"/>\r\n");
      out.write("                                            </div-->\r\n");
      out.write("                                            \r\n");
      out.write("                                            <div class=\"Twit\">\r\n");
      out.write("                                                <h2>@BimoAryo</h2>\r\n");
      out.write("                                                <p>");
      out.print(resultU.get(a));
      out.write("</p>\r\n");
      out.write("                                                \r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</article>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                                            \r\n");
      out.write("                                            ");
  out.print(NamaKategori.size());
                                    for(int i=0;i<NamaKategori.size();i++) {
      out.write("\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<input id=\"ac-");
      out.print(i);
      out.write("\" name=\"accordion-1\" type=\"radio\" checked />\r\n");
      out.write("\t\t\t\t\t<label for=\"ac-");
      out.print(i);
      out.write("\">KATEGORI ");
      out.print(NamaKategori.get(i));
      out.write("</label>\r\n");
      out.write("\t\t\t\t\t<article class=\"ac-small\">\r\n");
      out.write("                                            \r\n");
      out.write("                                            ");
 List<String> result= allresult.get(i);
                                            for(int a=0;a<result.size();a++) {
      out.write(" \r\n");
      out.write("                                            <br>\r\n");
      out.write("                                            <!--div class=\"picture\">\r\n");
      out.write("                                                <img alt=\"\" src=\"image/Maskot-Act-Beauty.png\"\r\n");
      out.write("                                                     style=\"height: 85px; \" id=\"image\"/>\r\n");
      out.write("                                            </div-->\r\n");
      out.write("                                            \r\n");
      out.write("                                            <div class=\"Twit\">\r\n");
      out.write("                                                <h2>@BimoAryo</h2>\r\n");
      out.write("                                                <p>");
      out.print(result.get(a));
      out.write("</p>\r\n");
      out.write("                                                \r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</article>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("\t\t\t\t<!--div>\r\n");
      out.write("\t\t\t\t\t<input id=\"ac-2\" name=\"accordion-1\" type=\"radio\" />\r\n");
      out.write("\t\t\t\t\t<label for=\"ac-2\">KATEGORI 2</label>\r\n");
      out.write("\t\t\t\t\t<article class=\"ac-medium\">\r\n");
      out.write("\t\t\t\t\t\t<p>Like you, I used to think the world was this great place where everybody lived by the same standards I did, then some kid with a nail showed me I was living in his world, a world where chaos rules not order, a world where righteousness is not rewarded. That's Cesar's world, and if you're not willing to play by his rules, then you're gonna have to pay the price. </p>\r\n");
      out.write("\t\t\t\t\t</article>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<input id=\"ac-3\" name=\"accordion-1\" type=\"radio\" />\r\n");
      out.write("\t\t\t\t\t<label for=\"ac-3\">KATEGORI 3</label>\r\n");
      out.write("\t\t\t\t\t<article class=\"ac-large\">\r\n");
      out.write("\t\t\t\t\t\t<p>You think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man. </p>\r\n");
      out.write("\t\t\t\t\t</article>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<input id=\"ac-4\" name=\"accordion-1\" type=\"radio\" />\r\n");
      out.write("\t\t\t\t\t<label for=\"ac-4\">KATEGORI 4</label>\r\n");
      out.write("\t\t\t\t\t<article class=\"ac-large\">\r\n");
      out.write("\t\t\t\t\t\t<p>You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic. </p>\r\n");
      out.write("                        <p>Today, Brackets only supports Live Preview for HTML and CSS. However, in the current version, changes to\r\n");
      out.write("            JavaScript files are automatically reloaded when you save. We are currently working on Live Preview\r\n");
      out.write("            support for JavaScript. Live previews are also only possible with Google Chrome, but we hope\r\n");
      out.write("            to bring this functionality to all major browsers in the future.</p>\r\n");
      out.write("                        <p>Today, Brackets only supports Live Preview for HTML and CSS. However, in the current version, changes to\r\n");
      out.write("            JavaScript files are automatically reloaded when you save. We are currently working on Live Preview\r\n");
      out.write("            support for JavaScript. Live previews are also only possible with Google Chrome, but we hope\r\n");
      out.write("            to bring this functionality to all major browsers in the future.</p>\r\n");
      out.write("                        <p>Today, Brackets only supports Live Preview for HTML and CSS. However, in the current version, changes to\r\n");
      out.write("            JavaScript files are automatically reloaded when you save. We are currently working on Live Preview\r\n");
      out.write("            support for JavaScript. Live previews are also only possible with Google Chrome, but we hope\r\n");
      out.write("            to bring this functionality to all major browsers in the future.</p>\r\n");
      out.write("\t\t\t\t\t</article>\r\n");
      out.write("\t\t\t\t</div-->\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("            <a href=\"home.jsp\"><div class=\"btn\">Back to Home</div></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    <script src=\"bootstrap/js/bootstrap.min.js\" />\r\n");
      out.write("    </body>\r\n");
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
