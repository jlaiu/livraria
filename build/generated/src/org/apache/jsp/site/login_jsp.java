package org.apache.jsp.site;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Cliente;
import dao.ClienteDAO;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/site/rodape.jsp");
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    //Se os dois campos forem informados, é login
    if(request.getParameter("txtEmail")!=null && 
            request.getParameter("txtSenha")!= null){
        ClienteDAO dao = new ClienteDAO();
        Cliente cli = dao.logar(request.getParameter("txtEmail"), 
                request.getParameter("txtSenha"));
        
        if(cli != null){
            session.setAttribute("cliente", cli);
            response.sendRedirect("finalizar.jsp");
            return;
        }
        else{
            
      out.write("\n");
      out.write("            <script>alert('Login e/ou senha inválidos.');\n");
      out.write("            </script>\n");
      out.write("            ");
}
        }
        //Se preencheu o cadastro
        if(request.getParameter("txtNEmail")!=null && 
            request.getParameter("txtNSenha")!= null && 
            request.getParameter("txtNEnd")!= null &&
            request.getParameter("txtNNome")!= null){
        ClienteDAO dao = new ClienteDAO();
        Cliente cli = new Cliente();
        cli.setEmail(request.getParameter("txtNEmail"));
        cli.setEndereco(request.getParameter("txtNEnd"));
        cli.setSenha(request.getParameter("txtNSenha"));
        cli.setNome(request.getParameter("txtNNome"));
        dao.incluir(cli);

        session.setAttribute("cliente", cli);
        response.sendRedirect("finalizar.jsp");
        return;
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Livraria Veiga</title>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta name=\"description\" content=\"Wish shop project\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap4/bootstrap.min.css\">\n");
      out.write("<link href=\"plugins/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/checkout.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/checkout_responsive.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("        \n");
      out.write("<div class=\"super_container\">\n");
      out.write("\t\n");
      out.write("\t<!-- Header -->\n");
      out.write("\n");
      out.write("\t<header class=\"header\">\n");
      out.write("\t\t<div class=\"header_inner d-flex flex-row align-items-center justify-content-start\">\n");
      out.write("                    <div class=\"logo\"><a href=\"#\"><h2>Livraria Veiga</h2></a></div>\n");
      out.write("\t\t\t<nav class=\"main_nav\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("                                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                                    <li><a href=\"contato.jsp\">Contato</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t<div class=\"header_content ml-auto\">\n");
      out.write("\t\t\t\t<div class=\"search header_search\">\n");
      out.write("\t\t\t\t\t<form action=\"#\">\n");
      out.write("\t\t\t\t\t\t<input type=\"search\" class=\"search_input\" required=\"required\">\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" id=\"search_button\" class=\"search_button\"><img src=\"images/magnifying-glass.svg\" alt=\"\"></button>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"shopping\">\n");
      out.write("\t\t\t\t\t<!-- Cart -->\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<div class=\"cart\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"images/shopping-bag.svg\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"cart_num_container\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"cart_num_inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"cart_num\">1</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<!-- Star -->\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<div class=\"star\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"images/star.svg\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"star_num_container\">\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"star_num_inner\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"star_num\">0</div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<!-- Avatar -->\n");
      out.write("\t\t\t\t\t<a href=\"#\">\n");
      out.write("\t\t\t\t\t\t<div class=\"avatar\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"images/avatar.svg\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"burger_container d-flex flex-column align-items-center justify-content-around menu_mm\"><div></div><div></div><div></div></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<!-- Menu -->\n");
      out.write("\n");
      out.write("\t<div class=\"menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400\">\n");
      out.write("\t\t<div class=\"menu_close_container\"><div class=\"menu_close\"><div></div><div></div></div></div>\n");
      out.write("                <div class=\"logo menu_mm\"><a href=\"#\"><h2>Livraria Veiga</h2></a></div>\n");
      out.write("\t\t<div class=\"search\">\n");
      out.write("\t\t\t<form action=\"#\">\n");
      out.write("\t\t\t\t<input type=\"search\" class=\"search_input menu_mm\" required=\"required\">\n");
      out.write("\t\t\t\t<button type=\"submit\" id=\"search_button_menu\" class=\"search_button menu_mm\"><img class=\"menu_mm\" src=\"images/magnifying-glass.svg\" alt=\"\"></button>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<nav class=\"menu_nav\">\n");
      out.write("\t\t\t<ul class=\"menu_mm\">\n");
      out.write("                            <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                            <li><a href=\"contato.jsp\">Contato</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- Checkout -->\n");
      out.write("\n");
      out.write("\t<div class=\"checkout\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- Billing Details -->\n");
      out.write("\t\t\t\t<div class=\"col-lg-6\">\n");
      out.write("\t\t\t\t\t<div class=\"billing\">\n");
      out.write("                                            <br></br><br></br>\n");
      out.write("                                            <form method=\"post\" action=\"#\" >\n");
      out.write("\t\t\t\t\t\t<div class=\"checkout_title\">Login</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"checkout_form_container\">\n");
      out.write("\t\t\t\t\t\t\t<form action=\"#\" id=\"checkout_form\">\n");
      out.write("                                                            <label for=\"fname\">E-mail</label>\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"email\" id=\"fname\" name=\"txtEmail\" class=\"checkout_input\" placeholder=\"Digite seu e-mail\" required=\"required\">\n");
      out.write("                                                                <label for=\"lname\">Senha</label>        \n");
      out.write("                                                                <input type=\"password\" id=\"lname\" name=\"txtSenha\" class=\"checkout_input\" placeholder=\"Digite sua senha\" required=\"required\">\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"cart_total_button\"><a href=\"finalizar.jsp\">ENTRAR</a></button>\n");
      out.write("                                                        </form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("                                                <br></br>\n");
      out.write("                                                <div class=\"checkout_title\">CADASTRO</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"checkout_form_container\">\n");
      out.write("\t\t\t\t\t\t\t<form action=\"#\" id=\"checkout_form\">\n");
      out.write("                                                            <label for=\"fname\">E-mail</label>\n");
      out.write("                                                            <input type=\"email\" id=\"fname\" name=\"txtNEmail\" class=\"checkout_input\" placeholder=\"Digite seu e-mail\" required=\"required\">\n");
      out.write("                                                            <label for=\"lname\">Senha</label>        \n");
      out.write("                                                            <input type=\"password\" id=\"lname\" name=\"txtNSenha\" class=\"checkout_input\" placeholder=\"Digite sua senha\" required=\"required\">\n");
      out.write("                                                            <label for=\"lnome\">Nome</label>        \n");
      out.write("                                                            <input type=\"text\" id=\"lnome\" name=\"txtNNome\" class=\"checkout_input\" placeholder=\"Digite seu nome\" required=\"required\">\n");
      out.write("                                                            <label for=\"fend\">Endereço</label>    \n");
      out.write("                                                            <input type=\"text\" id=\"fend\" name=\"txtNEnd\" class=\"checkout_input\" placeholder=\"Digite seu endereço\" required=\"required\">    \n");
      out.write("                                                            <div class=\"billing_options\">\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"cart_total_button\"><a href=\"finalizar.jsp\">CADASTRAR</a></button>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("                                                </form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("                                    \n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\t<!-- Newsletter -->\n");
      out.write("        <br><br/><br><br/><br><br/>\n");
      out.write("\t<div class=\"newsletter\">\n");
      out.write("\t\t<div class=\"newsletter_content\">\n");
      out.write("\t\t\t<div class=\"newsletter_image\" style=\"background-image:url(images/newsletter.jpg)\"></div>\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t<div class=\"col\">\n");
      out.write("\t\t\t\t\t\t<div class=\"section_title_container text-center\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"section_title\">Assine para receber novidades</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"row newsletter_container\">\n");
      out.write("\t\t\t\t\t<div class=\"col-lg-10 offset-lg-1\">\n");
      out.write("\t\t\t\t\t\t<div class=\"newsletter_form_container\">\n");
      out.write("\t\t\t\t\t\t\t<form action=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"email\" class=\"newsletter_input\" required=\"required\" placeholder=\"E-mail\">\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"newsletter_button\">Assinar</button>\n");
      out.write("\t\t\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"newsletter_text\">Assine e receba por e-mail todas as promoções e novidades da semana.</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- Footer -->\n");
      out.write("        \n");
      out.write("\t<footer class=\"footer\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t<div class=\"col text-center\">\n");
      out.write("                                    <div class=\"footer_logo\"><a href=\"#\"><h2>Livraria Veiga</h2></a></div>\n");
      out.write("\t\t\t\t\t<nav class=\"footer_nav\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("                                                    <li><a href=\"#\">Home</a></li>\n");
      out.write("                                                    <li><a href=\"categories.html\">Livros</a></li>\n");
      out.write("                                                    <li><a href=\"categories.html\">Promoções</a></li>\n");
      out.write("                                                    <li><a href=\"contact.html\">Contato</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</nav>\n");
      out.write("\t\t\t\t\t\n");
      out.write("                                        <div class=\"footer_social\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("                                                    <li><a href=\"https://www.w3schools.com\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("                                    <br><br/>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("<script src=\"styles/bootstrap4/popper.js\"></script>\n");
      out.write("<script src=\"styles/bootstrap4/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\n");
      out.write("<script src=\"plugins/easing/easing.js\"></script>\n");
      out.write("<script src=\"plugins/parallax-js-master/parallax.min.js\"></script>\n");
      out.write("<script src=\"plugins/colorbox/jquery.colorbox-min.js\"></script>\n");
      out.write("<script src=\"js/custom.js\"></script>\n");
      out.write("</body>\n");
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
