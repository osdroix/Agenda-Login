package org.apache.jsp.Avisos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <meta name=\"keywords\" content=\"Art Sign Up Form Responsive Widget, \n");
      out.write("              Audio and Video players, Login Form Web Template, Flat Pricing \n");
      out.write("              Tables, Flat Drop-Downs, Sign-Up Web Templates, \n");
      out.write("\tFlat Web Templates, Login Sign-up Responsive Web Template, Smartphone \n");
      out.write("        Compatible Web Template, Free Web Designs for Nokia, Samsung, \n");
      out.write("        LG, Sony Ericsson, Motorola Web Design\"\n");
      out.write("    />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" \n");
      out.write("         integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/CSS/ventana.css\">\n");
      out.write("    <link href=\"/CSS/diseño.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <title>Mensaje</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bod7\" onload=\"redireccionarPagina()\">\n");
      out.write("        <br><br>\n");
      out.write("       <center> <div class=\"capsulas\" >\n");
      out.write("            <h1 align=\"center\" >");
out.println(request.getParameter("in"));
      out.write("<br><hr>\n");
      out.write("        <img src=\"");
out.println(request.getParameter("img"));
      out.write("\" width=\"300\" height=\"300\"/></h1><br>\n");
      out.write("        <h3 align=\"center\">");
out.println(request.getParameter("error"));
      out.write("</h3>\n");
      out.write("        <br><br><br>\n");
      out.write("        </div></center>\n");
      out.write("        <script> \n");
      out.write("            function redireccionarPagina() { \n");
      out.write("                setTimeout(\"location.href='/index.html'\", 200000); }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
